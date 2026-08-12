package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "atividades")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String titulo;

    private boolean status = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;

    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getTitulo() {return this.titulo;}
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public boolean getStatus() {return this.status;}
    public void setStatus(boolean status) { this.status = status; }

    public Projeto getProjeto() {return this.projeto;}
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }
}
