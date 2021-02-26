package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import mx.edu.utez.SCA.documents.RolDocument;
@Repository
public interface RolRepository extends MongoRepository<RolDocument, String> {
	RolDocument findByRol(String rol);

}
