package com.basedeconhecimento.resources;

import com.basedeconhecimento.Services.TopicoService;
import com.basedeconhecimento.domain.Topico;
import com.basedeconhecimento.dto.TopicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/topico")
public class TopicoResource {


    @Autowired
    private TopicoService service;

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<TopicoDTO>> findAll() {
        List<TopicoDTO> listDto = this.service.findAll();
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping (path = "/getByStatus")
    public ResponseEntity<List<Topico>> findByStatus(@RequestBody(required = true) TopicoDTO topico) {
        List<Topico> listDto = this.service.find(topico);
        return ResponseEntity.ok().body(listDto);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TopicoDTO> findById(@PathVariable String id) {
        Optional<Topico> obj = this.service.findById(id);
        if (obj.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok().body(new TopicoDTO(obj.get()));
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Topico> insert(@RequestBody TopicoDTO objDTO) {
      Topico topico = this.service.save(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Topico> update(@RequestBody TopicoDTO objDTO) {
        Topico topico = this.service.update(objDTO);
        objDTO.setId();
        return ResponseEntity.noContent().build();
    }

}