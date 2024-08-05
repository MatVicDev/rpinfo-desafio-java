package br.com.rpinfo.rp_desafio_java.repository;

import br.com.rpinfo.rp_desafio_java.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
