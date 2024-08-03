package br.com.rpinfo.rp_desafio_java.model;

public class Cliente {
    private Long id;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private String email;
    private Equipamento equipamento;
    private OrdemServico ordemServico;

    public Cliente(String nome, Endereco endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
}
