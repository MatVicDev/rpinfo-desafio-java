package br.com.rpinfo.rp_desafio_java.service;

import br.com.rpinfo.rp_desafio_java.model.Cliente;
import br.com.rpinfo.rp_desafio_java.model.Endereco;
import br.com.rpinfo.rp_desafio_java.model.Equipamento;
import br.com.rpinfo.rp_desafio_java.model.OrdemServico;
import br.com.rpinfo.rp_desafio_java.repository.ClienteRepository;
import br.com.rpinfo.rp_desafio_java.repository.EquipamentoRepository;
import br.com.rpinfo.rp_desafio_java.repository.OrdemServicoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrdemServicoServiceTest {

    @Mock
    private OrdemServicoRepository ordemServicoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private EquipamentoRepository equipamentoRepository;

    @InjectMocks
    private OrdemServicoService ordemServicoService;

    @InjectMocks
    private ClienteService clienteService;

    @InjectMocks
    private EquipamentoService equipamentoService;

    @Test
    void validarDadosInseridosNoBanco() {
        String nome = "Roberto";
        String rua = "Rua Qualquer";
        String numero = "01";
        String bairro = "Centro";
        String cidade = "Curitiba";
        String estado = "PR";
        String telefone = "99911223344";
        String email = "roberto@email.com";

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado);
        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        cliente.setId(1L);

        String tipo = "Celular";
        String marca = "Motorolla";
        String problema = "Tela trincada";

        Equipamento equipamento = new Equipamento(tipo, marca, problema, cliente);
        equipamento.setId(1L);

        String descricao = "Trocar a tela trincada";

        OrdemServico ordemServico = new OrdemServico(descricao, equipamento);
        ordemServico.setId(1L);

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(equipamentoRepository.save(any(Equipamento.class))).thenReturn(equipamento);
        when(equipamentoRepository.findById(1L)).thenReturn(Optional.of(equipamento));
        when(ordemServicoRepository.save(any(OrdemServico.class))).thenReturn(ordemServico);

        clienteService.cadastrarCliente(nome, endereco, telefone, email);
        equipamentoService.cadastrarEquipamento(tipo, marca, problema, cliente.getId());

        OrdemServico ordemServicoSalvo = ordemServicoService.cadastrarOrdemServico(descricao, equipamento.getId());

        assertEquals(1L, ordemServicoSalvo.getId());
    }
}
