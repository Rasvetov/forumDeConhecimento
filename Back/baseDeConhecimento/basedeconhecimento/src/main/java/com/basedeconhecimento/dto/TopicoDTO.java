package com.basedeconhecimento.dto;

import com.basedeconhecimento.domain.Categoria;
import com.basedeconhecimento.domain.Topico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

public class TopicoDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String titulo;
    private Boolean status;
    private Categoria categoria;
    private LocalDate data;

    private String conteudo;

    public TopicoDTO(){}

    public TopicoDTO(Topico obj){
        id = obj.getId();
        titulo = obj.getTitulo();
        status = obj.getStatus();
        categoria = obj.getCategoria();
        data = obj.getData();
        conteudo = obj.getConteudo();
    }

    public TopicoDTO(Optional<Topico> obj) {}

    public String getId() {
        return id;
    }

    public void setId() {
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

    public String getConteudo() { return conteudo; }

    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
}
