package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.CarreraDocument;
@Repository
public interface CarreraRepository extends MongoRepository<CarreraDocument, String> {
	CarreraDocument findByNombreCarrera(String nombreCarrera);
}
