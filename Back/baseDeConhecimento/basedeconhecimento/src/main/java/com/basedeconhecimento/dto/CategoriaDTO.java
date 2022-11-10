package com.basedeconhecimento.dto;

import com.basedeconhecimento.domain.Categoria;

import java.io.Serializable;
import java.util.Optional;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private Boolean status;

    public CategoriaDTO(){}

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
        status = obj.getStatus();
    }

    public CategoriaDTO(Optional<Categoria> obj){}

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
