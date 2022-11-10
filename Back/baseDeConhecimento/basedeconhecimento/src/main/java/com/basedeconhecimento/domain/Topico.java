package com.basedeconhecimento.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document(collection="topico")
public class Topico implements Serializable {

    static {
        long serialVersionUID = 1L;
    }

    @Id
    private String id;
    private String titulo;
    private Boolean status;
    private Categoria categoria;
    private LocalDate data;

    private String conteudo;

    public Topico() {}

    public Topico(String id, String titulo, Boolean status, Categoria categoria, LocalDate data, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.categoria = categoria;
        this.data = data;
        this.conteudo = conteudo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String id) {
        this.conteudo = conteudo;
    }

}

