package br.com.rpinfo.rp_desafio_java.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Embedded
    private Endereco endereco;
    private String telefone;
    private String email;
    @OneToMany
    private List<Equipamento> equipamentos;

    @OneToOne
    private OrdemServico ordemServico;

    public Cliente() {
    }

    public Cliente(String nome, Endereco endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }
}
