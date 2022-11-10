package com.basedeconhecimento.repository;
import com.basedeconhecimento.domain.Topico;
import com.basedeconhecimento.dto.TopicoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends MongoRepository<Topico, String> {

    @Query(value = "SELECT " +
            "new com.basedeconhecimento.domain.Topico(t.id, t.titulo, t.status, t.categoria.id, t.data, t.conteudo) " +
            "FROM Topico t " +
            "WHERE t.status = :status")
    List<Topico> findByStatus(Boolean status);


}
