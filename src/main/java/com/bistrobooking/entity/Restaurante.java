package com.bistrobooking.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_endereco")
    private Endereco endereco;

    @Column
    private String telefone;

    @Column
    private String tipoCulinaria;

    @Column
    private LocalDateTime excluido;

    public Restaurante() {
    }

    public Restaurante(Long id, String nome, String descricao, Endereco endereco, String telefone, String tipoCulinaria, LocalDateTime excluido) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoCulinaria = tipoCulinaria;
        this.excluido = excluido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoCulinaria() {
        return tipoCulinaria;
    }

    public void setTipoCulinaria(String tipoCulinaria) {
        this.tipoCulinaria = tipoCulinaria;
    }

    public LocalDateTime getExcluido() {
        return excluido;
    }

    public void setExcluido(LocalDateTime excluido) {
        this.excluido = excluido;
    }
}
