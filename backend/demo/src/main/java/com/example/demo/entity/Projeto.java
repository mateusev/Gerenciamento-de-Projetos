package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "projetos")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private LocalDate dataCriacao;

    //a anotação abaixo serve para que o Hibernate pegue a data exata do sistema.
    @org.hibernate.annotations.UpdateTimestamp
    private java.time.LocalDateTime dataUltimaModificacao;

    //coloquei esse construtor vazio aqui porque o Hibernate pede.
    public Projeto() {
        this.dataCriacao = LocalDate.now();
    }
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List atividades = new java.util.ArrayList<>();

    //início dos getters e setters
    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public LocalDate getDataCriacao() {return dataCriacao;}

    public LocalDateTime getDataUltimaModification() {return this.dataUltimaModificacao;}
    public void setDataUltimaModificacao (LocalDateTime dataUltimaModificacao) {this.dataUltimaModificacao = dataUltimaModificacao;}

    public java.util.List getAtividades() {return this.atividades;}
    public void setAtividades(java.util.List atividades) {this.atividades = atividades;}
}
