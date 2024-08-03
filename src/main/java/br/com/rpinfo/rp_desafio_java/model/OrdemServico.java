package br.com.rpinfo.rp_desafio_java.model;

import java.time.LocalDateTime;

public class OrdemServico {
    private Long id;
    private Atendente atendente;
    private Tecnico tecnico;
    private LocalDateTime dataEntrada;
    private String descricao;
}
