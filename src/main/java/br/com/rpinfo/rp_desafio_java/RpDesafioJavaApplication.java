package br.com.rpinfo.rp_desafio_java;

import br.com.rpinfo.rp_desafio_java.model.*;
import br.com.rpinfo.rp_desafio_java.service.ClienteService;
import br.com.rpinfo.rp_desafio_java.service.EquipamentoService;
import br.com.rpinfo.rp_desafio_java.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class RpDesafioJavaApplication implements CommandLineRunner {

    private Scanner leitura = new Scanner(System.in);

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EquipamentoService equipamentoService;

    @Autowired
    private OrdemServicoService ordemServicoService;

    public static void main(String[] args) {
        SpringApplication.run(RpDesafioJavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int option;

        do {
            System.out.println("*** Digite uma opção: ****\n");
            System.out.println("1 - Nova ordem de serviço");
            System.out.println("2 - Listar ordens de serviços");
            System.out.println("3 - Consultar ordem de serviço");
            System.out.println("4 - Atualizar ordem de serviço");
            System.out.println("0 - Sair");

            option = leitura.nextInt();

            switch (option) {
                case 1:
                    novaOrdemServico();
                    break;
                case 2:
                    listarOrdensServico();
                    break;
                case 3:
                    consultarOrdemServico();
                    break;
                case 4:
                    atualizarOrdemServico();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
            }

        } while (option != 0);

        leitura.close();
    }

    private void novaOrdemServico() {
        leitura.nextLine();

        Cliente cliente = cadastrarCliente();
        Equipamento equipamento = cadastrarEquipamento(cliente);
        gerarNovaOrdemServico(equipamento);
    }

    private Cliente cadastrarCliente() {
        System.out.println("*** Informações do cliente ***");
        System.out.print("Nome: ");
        var nome = leitura.nextLine();
        System.out.print("Rua: ");
        var rua = leitura.nextLine();
        System.out.print("Número: ");
        var numero = leitura.nextLine();
        System.out.print("Bairro: ");
        var bairro = leitura.nextLine();
        System.out.print("Cidade: ");
        var cidade = leitura.nextLine();
        System.out.print("Estado: ");
        var estado = leitura.nextLine();
        System.out.print("Telefone: ");
        var telefone = leitura.nextLine();
        System.out.print("E-mail: ");
        var email = leitura.nextLine();

        var endereco = new Endereco(rua, numero, bairro, cidade, estado);

        return clienteService.cadastrarCliente(nome, endereco, telefone, email);
    }

    private Equipamento cadastrarEquipamento(Cliente cliente) {
        System.out.println("*** Informações do equipamento ***");
        System.out.print("Tipo: ");
        var tipo = leitura.nextLine();
        System.out.print("Marca: ");
        var marca = leitura.nextLine();
        System.out.print("Problema: ");
        var problema = leitura.nextLine();

        return equipamentoService.cadastrarEquipamento(tipo, marca, problema, cliente.getId());
    }

    private OrdemServico gerarNovaOrdemServico(Equipamento equipamento) {
        System.out.println("*** Informações da ordem de serviço ***");
        System.out.print("Descrição: ");
        var descricao = leitura.nextLine();

        return ordemServicoService.cadastrarOrdemServico(descricao, equipamento.getId());
    }

    private void listarOrdensServico() {
        System.out.println("*** Lista de ordens de servico ***");
        List<OrdemServico> ordensServico = ordemServicoService.listarOrdensServico();

        if (ordensServico.isEmpty()) {
            System.out.println("Nenhuma ordem de serviço encontrada!");
        } else {
            for (OrdemServico ordem : ordensServico) {
                System.out.println("ID: " + ordem.getId());
                System.out.println("Atendendente: " + ordem.getAtendente());
                System.out.println("Técnico responsável: " + ordem.getTecnico());
                System.out.println("Data de entrada: " + ordem.getDataFormata());
                System.out.println("Status: " + ordem.getStatus());
                System.out.println("Nome cliente: " + ordem.getCliente().getNome());
                System.out.println("Equipamento: " + ordem.getEquipamento().getTipo());

                System.out.println("----------------------");
            }
        }
    }

    private void consultarOrdemServico() {
        System.out.print("Procure por uma ordem de servico: ");
        Long idOrdemServico = leitura.nextLong();
        leitura.nextLine();

        if (ordemServicoService.consultarOrdemServico(idOrdemServico).isPresent()) {
            OrdemServico ordem = ordemServicoService.consultarOrdemServico(idOrdemServico).get();

            System.out.println("Atendente: " + ordem.getAtendente());
            System.out.println("Técnico responsável: " + ordem.getTecnico());
            System.out.println("Data de entrada: " + ordem.getDataFormata());
            System.out.println("Status: " + ordem.getStatus());
            System.out.println("Descrição do serviço: " + ordem.getDescricao());
            System.out.println("Nome cliente: " + ordem.getCliente().getNome());
            System.out.println("Equipamento: " + ordem.getEquipamento().getTipo());

            System.out.println("----------------------");
        } else {
            System.out.println("Ordem de serviço não encontrada!");
        }
    }

    private void atualizarOrdemServico() {
        System.out.print("Atualize a ordem de serviço pelo ID: ");
        Long idOrdemServico = leitura.nextLong();
        leitura.nextLine();

        Optional<OrdemServico> ordemServico = ordemServicoService.consultarOrdemServico(idOrdemServico);

        if (ordemServico.isEmpty()) {
            System.out.println("Ordem de serviço não encontrada!");
            return;
        }

        System.out.println("Digite a descrição: ");
        String descricao = leitura.nextLine();

        System.out.print("Digite o status (EM_PROCESSO, PENDENTE, FINALIZADO): ");
        String statusStr = leitura.nextLine().toUpperCase();
        Status status;

        try {
            status = Status.valueOf(statusStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Status inválido. Operação cancelada.");
            return;
        }

        try {
            ordemServico = Optional.of(ordemServicoService.atualizarOrdemServico(idOrdemServico, descricao, status));
            System.out.println("Ordem de serviço atualizada com sucesso! ID: " + ordemServico.get().getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível atualizar a ordem de serviço: " + e.getMessage());
        }
    }
}
