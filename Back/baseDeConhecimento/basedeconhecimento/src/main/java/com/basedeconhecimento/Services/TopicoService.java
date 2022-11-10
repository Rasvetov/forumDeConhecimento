package com.basedeconhecimento.Services;

import com.basedeconhecimento.Excepetions.ObjectNotFoundException;
import com.basedeconhecimento.domain.Topico;
import com.basedeconhecimento.dto.TopicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.basedeconhecimento.repository.TopicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicRepository repo;
    public List<TopicoDTO> findAll() {
        try {
            List<Topico> list = this.repo.findAll();
            List<TopicoDTO> topicos = new ArrayList<>();
             list.stream().map(x ->{
                if (x.getStatus().equals(Boolean.TRUE)){
                    topicos.add(new TopicoDTO(x));
                }
                 return null;
             }).collect(Collectors.toList());
            return topicos;

        } catch (ObjectNotFoundException e) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }


    public Optional<Topico> findById(String id) {
        Optional<Topico> topico = repo.findById(id);
        if (topico == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return topico;
    }

    public Topico insert(Topico obj) {
        return repo.insert(obj);
    }

    public Topico fromDTO(TopicoDTO objDto){
        return new Topico(objDto.getId(), objDto.getTitulo(), objDto.getStatus(), objDto.getCategoria(),objDto.getData(), objDto.getConteudo());
    }

    public Topico save(TopicoDTO dto) {
        return insert(fromDTO(dto));

    }

    public Topico update(TopicoDTO obj){
        Optional<Topico> newTopico = repo.findById(obj.getId());
        updateTopic(newTopico, obj);
        return repo.save(newTopico.get());
    }

    private void updateTopic(Optional<Topico> newTopico, TopicoDTO obj) {
        newTopico.get().setTitulo(obj.getTitulo());
        newTopico.get().setCategoria(obj.getCategoria());
        newTopico.get().setStatus(obj.getStatus());
        newTopico.get().setData(obj.getData());
        newTopico.get().setConteudo(obj.getConteudo());
    }


    public List<Topico> find(TopicoDTO topico) {
        List<Topico> topicos = this.repo.findByStatus(topico.getStatus());
        return topicos;
    }
}


