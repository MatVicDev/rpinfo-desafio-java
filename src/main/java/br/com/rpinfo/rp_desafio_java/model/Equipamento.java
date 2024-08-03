package br.com.rpinfo.rp_desafio_java.model;

public class Equipamento {
    private Long id;
    private String tipo;
    private String marca;
    private String problema;
    private Cliente cliente;

    public Equipamento(String tipo, String marca, String problema, Cliente cliente) {
        this.tipo = tipo;
        this.marca = marca;
        this.problema = problema;
        this.cliente = cliente;
    }
}
