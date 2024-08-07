package br.com.rpinfo.rp_desafio_java.controller;

import br.com.rpinfo.rp_desafio_java.model.OrdemServico;
import br.com.rpinfo.rp_desafio_java.repository.OrdemServicoRepository;
import br.com.rpinfo.rp_desafio_java.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ordem_servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServico> consultaPorId(@PathVariable Long id) {
        OrdemServico ordemServico = ordemServicoService.consultarOrdemServico(id).get();
        return ResponseEntity.ok(ordemServico);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarOrdensServico() {
        return ResponseEntity.ok(ordemServicoService.listarOrdensServico());
    }
}
