package br.com.rpinfo.rp_desafio_java.model;

public enum Status {
    EM_PROCESSO("Em processo"),
    PENDENTE("Pendente"),
    FINALIZADO("Finalizado");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
