package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Risco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String severidade;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    @JsonIgnore
    private Projeto projeto;

    //Getters e Setters
    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getDescricao() {return this.descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getSeveridade() {return this.severidade;}
    public void setSeveridade(String severidade) {this.severidade = severidade;}

    public Projeto getProjeto() {return this.projeto;}
    public void setProjeto(Projeto projeto) {this.projeto = projeto;}


}
