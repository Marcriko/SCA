package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.AsesoriaDocument;
@Repository
public interface AsesoriaRepository extends MongoRepository<AsesoriaDocument, String> {

}
