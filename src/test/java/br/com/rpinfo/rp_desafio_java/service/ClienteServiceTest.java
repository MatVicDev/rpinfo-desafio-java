package br.com.rpinfo.rp_desafio_java.service;

import br.com.rpinfo.rp_desafio_java.model.Cliente;
import br.com.rpinfo.rp_desafio_java.model.Endereco;
import br.com.rpinfo.rp_desafio_java.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

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

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente clienteSalvo = clienteService.cadastrarCliente(nome, endereco, telefone, email);

        assertEquals(1L, clienteSalvo.getId());
        assertEquals(nome, clienteSalvo.getNome());
        assertEquals(rua, clienteSalvo.getEndereco().getRua());
        assertEquals(numero, clienteSalvo.getEndereco().getNumero());
        assertEquals(bairro, clienteSalvo.getEndereco().getBairro());
        assertEquals(cidade, clienteSalvo.getEndereco().getCidade());
        assertEquals(estado, clienteSalvo.getEndereco().getEstado());
        assertEquals(telefone, clienteSalvo.getTelefone());
        assertEquals(email, clienteSalvo.getEmail());
    }
}
