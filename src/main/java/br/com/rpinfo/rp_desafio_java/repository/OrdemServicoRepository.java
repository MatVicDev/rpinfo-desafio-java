package br.com.rpinfo.rp_desafio_java.repository;

import br.com.rpinfo.rp_desafio_java.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
