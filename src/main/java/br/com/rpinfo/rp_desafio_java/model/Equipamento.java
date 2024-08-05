package br.com.rpinfo.rp_desafio_java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Equipamento {

    @Id
    private Long id;
    private String tipo;
    private String marca;
    private String problema;

    @OneToOne
    private Cliente cliente;

    public Equipamento(String tipo, String marca, String problema, Cliente cliente) {
        this.tipo = tipo;
        this.marca = marca;
        this.problema = problema;
        this.cliente = cliente;
    }
}
