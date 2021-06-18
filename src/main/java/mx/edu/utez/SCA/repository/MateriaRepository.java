package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.MateriaDocument;
@Repository
public interface MateriaRepository extends MongoRepository<MateriaDocument, String>{

}
