package br.com.rpinfo.rp_desafio_java.service;

import br.com.rpinfo.rp_desafio_java.model.Cliente;
import br.com.rpinfo.rp_desafio_java.model.Endereco;
import br.com.rpinfo.rp_desafio_java.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente cadastrarCliente(String nome, Endereco endereco, String telefone, String email) {
        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        return repository.save(cliente);
    }

    public Cliente consultarCliente(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }
}
