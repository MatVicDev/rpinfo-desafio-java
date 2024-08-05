package br.com.rpinfo.rp_desafio_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class OrdemServico {

    @Id
    private Long id;
    private String atendente = "Beatriz";
    private String tecnico = "Rodrigo";
    private LocalDateTime dataEntrada = LocalDateTime.now();
    private String descricao;

    private Status status;

    @OneToOne
    private Equipamento equipamento;

    public OrdemServico(String descricao, Equipamento equipamento) {
        this.descricao = descricao;
        this.equipamento = equipamento;
    }

    public String getDataFormata() {
        var formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        var dataFormatada = this.dataEntrada.format(formatador);

        return dataFormatada;
    }
}
