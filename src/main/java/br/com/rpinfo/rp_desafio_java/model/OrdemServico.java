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

    @Enumerated(EnumType.STRING)
    private Status status = Status.EM_PROCESSO;

    @OneToOne
    @JoinColumn(name = "equipamento_id")
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public String getAtendente() {
        return atendente;
    }

    public String getTecnico() {
        return tecnico;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDataFormata() {
        var formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        var dataFormatada = this.dataEntrada.format(formatador);

        return dataFormatada;
    }
}
