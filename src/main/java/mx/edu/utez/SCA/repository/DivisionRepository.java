package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import mx.edu.utez.SCA.documents.DivisionDocument;
@Repository
public interface DivisionRepository extends MongoRepository<DivisionDocument, String> {
	DivisionDocument  findBySiglas(String siglas);
}
