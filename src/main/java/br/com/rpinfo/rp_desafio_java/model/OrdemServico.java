package br.com.rpinfo.rp_desafio_java.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrdemServico {
    private Long id;
    private Atendente atendente;
    private Tecnico tecnico;
    private LocalDateTime dataEntrada = LocalDateTime.now();
    private String descricao;

    public String getDataFormata() {
        var formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        var dataFormatada = this.dataEntrada.format(formatador);

        return dataFormatada;
    }
}
