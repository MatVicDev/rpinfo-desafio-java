package br.com.rpinfo.rp_desafio_java;

import br.com.rpinfo.rp_desafio_java.model.Cliente;
import br.com.rpinfo.rp_desafio_java.model.Endereco;
import br.com.rpinfo.rp_desafio_java.model.Equipamento;
import br.com.rpinfo.rp_desafio_java.model.OrdemServico;
import br.com.rpinfo.rp_desafio_java.service.ClienteService;
import br.com.rpinfo.rp_desafio_java.service.EquipamentoService;
import br.com.rpinfo.rp_desafio_java.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RpDesafioJavaApplication implements CommandLineRunner {

    private static Scanner leitura = new Scanner(System.in);

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
            System.out.println("2 - Consultar ordem de serviço");
            System.out.println("0 - Sair");

            option = leitura.nextInt();

            switch (option) {
                case 1:
                    novaOrdemServico();
                    break;
                case 2:
                    consultarOrdemServico();
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

    private void consultarOrdemServico() {
    }
}
