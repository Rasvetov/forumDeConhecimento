package com.basedeconhecimento.Services;

import com.basedeconhecimento.Excepetions.ObjectNotFoundException;
import com.basedeconhecimento.domain.Categoria;
import com.basedeconhecimento.dto.CategoriaDTO;
import com.basedeconhecimento.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public List<CategoriaDTO> findAll() {
        try {
            List<Categoria> list = this.repo.findAll();
            List<CategoriaDTO> categoria = new ArrayList<>();
            list.stream().map(x ->{
                if (x.getStatus().equals(Boolean.TRUE)){
                    categoria.add(new CategoriaDTO((x)));
                }
                return null;
            }).collect(Collectors.toList());
            return categoria;

        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }


    public Optional<Categoria> findById(String id) {
        Optional<Categoria> categoria = repo.findById(id);
        if (categoria == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return categoria;
    }

    public Categoria insert(Categoria obj) {
        return repo.insert(obj);
    }

    public Categoria fromDTO(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome(), objDto.getStatus());
    }

    public Categoria save(CategoriaDTO dto) {
        return insert(fromDTO(dto));

    }

    public Categoria update(Categoria obj){
        Optional<Categoria> newCategoria = repo.findById(obj.getId());
        updateCat(newCategoria, obj);
        return repo.save(newCategoria.get());
    }

    private void updateCat(Optional<Categoria> newCategoria, Categoria obj) {
        newCategoria.get().setNome(obj.getNome());
    }


}
