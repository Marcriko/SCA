package mx.edu.utez.SCA.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import mx.edu.utez.SCA.documents.GrupoDocument;
@Repository
public interface GrupoRepository extends MongoRepository<GrupoDocument,String> {
	
	
	@Query(value = "{carrera:{'carrera.id':{$eq:0?}}}")
	List<GrupoDocument> findByCarrera(String id);
}
