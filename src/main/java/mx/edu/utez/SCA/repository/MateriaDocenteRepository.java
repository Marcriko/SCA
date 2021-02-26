package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.MateriaDocenteDocument;
@Repository
public interface MateriaDocenteRepository extends MongoRepository<MateriaDocenteDocument, String>{
	
}
