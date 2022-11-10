package com.basedeconhecimento.resources;

import com.basedeconhecimento.Services.CategoriaService;
import com.basedeconhecimento.domain.Categoria;
import com.basedeconhecimento.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/categoria")
public class CategoriaResource {



    @Autowired
    private CategoriaService service;


    @GetMapping(value = "/getAll")
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<CategoriaDTO> listDto = this.service.findAll();
        return ResponseEntity.ok().body(listDto);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoriaDTO> findById(@PathVariable String id) {
        Optional<Categoria> obj = this.service.findById(id);
        if (obj.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok().body(new CategoriaDTO(obj.get()));
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Categoria> insert(@RequestBody CategoriaDTO objDTO) {
        Categoria categoria = this.service.save(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Categoria> update(@RequestBody CategoriaDTO objDTO, @PathVariable String id) {
        Categoria categoria = this.service.save(objDTO);
        objDTO.setId();
        return ResponseEntity.noContent().build();
    }


}
