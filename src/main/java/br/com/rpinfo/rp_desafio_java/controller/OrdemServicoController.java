package br.com.rpinfo.rp_desafio_java.controller;

import br.com.rpinfo.rp_desafio_java.model.OrdemServico;
import br.com.rpinfo.rp_desafio_java.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ordem_servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServico> consultaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
