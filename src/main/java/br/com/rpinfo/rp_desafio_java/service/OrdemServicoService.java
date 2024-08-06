package br.com.rpinfo.rp_desafio_java.service;

import br.com.rpinfo.rp_desafio_java.model.Equipamento;
import br.com.rpinfo.rp_desafio_java.model.OrdemServico;
import br.com.rpinfo.rp_desafio_java.repository.ClienteRepository;
import br.com.rpinfo.rp_desafio_java.repository.EquipamentoRepository;
import br.com.rpinfo.rp_desafio_java.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    public OrdemServico cadastrarOrdemServico(String descricao, Long equipamentoId) {
        Equipamento equipamento = equipamentoRepository.findById(equipamentoId).orElseThrow(() -> new IllegalArgumentException("Cliente não cadastrado!"));

        OrdemServico ordemServico = new OrdemServico(descricao, equipamento);
        ordemServico.setCliente(equipamento.getCliente());

        equipamento.setOrdemServico(ordemServico);

        return ordemServicoRepository.save(ordemServico);
    }

    public List<OrdemServico> listarOrdensServico() {
        return ordemServicoRepository.findAll();
    }

    public OrdemServico consultarOrdemServico(Long id) {
        return ordemServicoRepository.findById(id).orElse(null);
    }
}
