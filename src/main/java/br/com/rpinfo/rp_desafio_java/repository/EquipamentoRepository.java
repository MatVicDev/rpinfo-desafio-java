package br.com.rpinfo.rp_desafio_java.repository;

import br.com.rpinfo.rp_desafio_java.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
