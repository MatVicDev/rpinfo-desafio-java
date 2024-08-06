package br.com.rpinfo.rp_desafio_java.service;

import br.com.rpinfo.rp_desafio_java.model.Cliente;
import br.com.rpinfo.rp_desafio_java.model.Endereco;
import br.com.rpinfo.rp_desafio_java.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrarCliente(String nome, Endereco endereco, String telefone, String email) {
        Cliente cliente = new Cliente(nome, endereco, telefone, email);
        return repository.save(cliente);
    }

    public Cliente consultarCliente(Long id) {
        return repository.findById(id).orElse(null);
    }
}
