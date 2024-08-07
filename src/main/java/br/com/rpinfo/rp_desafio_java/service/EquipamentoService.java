package br.com.rpinfo.rp_desafio_java.service;

import br.com.rpinfo.rp_desafio_java.model.Cliente;
import br.com.rpinfo.rp_desafio_java.model.Equipamento;
import br.com.rpinfo.rp_desafio_java.repository.ClienteRepository;
import br.com.rpinfo.rp_desafio_java.repository.EquipamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Equipamento cadastrarEquipamento(String tipo, String marca, String problema, Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        Equipamento equipamento = new Equipamento(tipo, marca, problema, cliente);
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento consultarEquipamento(Long id) {
        return equipamentoRepository.findById(id).orElse(null);
    }

    public List<Equipamento> listarEquipamentos() {
        return equipamentoRepository.findAll();
    }
}
