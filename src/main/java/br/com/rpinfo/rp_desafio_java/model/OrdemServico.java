package br.com.rpinfo.rp_desafio_java.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String atendente = "Beatriz";
    private String tecnico = "Rodrigo";

    @CreationTimestamp
    private LocalDateTime dataEntrada;
    private String descricao;
    private Status status;

    @OneToOne
    private Equipamento equipamento;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public OrdemServico() {

    }

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
