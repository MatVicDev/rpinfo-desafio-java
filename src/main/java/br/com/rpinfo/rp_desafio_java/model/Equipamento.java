package br.com.rpinfo.rp_desafio_java.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String marca;
    private String problema;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "ordem_servico_id")
    private OrdemServico ordemServico;

    public Equipamento() {

    }

    public Equipamento(String tipo, String marca, String problema, Cliente cliente) {
        this.tipo = tipo;
        this.marca = marca;
        this.problema = problema;
        this.cliente = cliente;
    }
}
