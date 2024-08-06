package br.com.rpinfo.rp_desafio_java.service;

import br.com.rpinfo.rp_desafio_java.model.Equipamento;
import br.com.rpinfo.rp_desafio_java.model.OrdemServico;
import br.com.rpinfo.rp_desafio_java.model.Status;
import br.com.rpinfo.rp_desafio_java.repository.ClienteRepository;
import br.com.rpinfo.rp_desafio_java.repository.EquipamentoRepository;
import br.com.rpinfo.rp_desafio_java.repository.OrdemServicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<OrdemServico> consultarOrdemServico(Long id) {
        return ordemServicoRepository.findById(id);
    }

    @Transactional
    public OrdemServico atualizarOrdemServico(Long id, String descricao, Status status) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Ordem de serviço não encontrada"));

        ordemServico.setDescricao(descricao);
        ordemServico.setStatus(status);

        return ordemServicoRepository.save(ordemServico);
    }
}
