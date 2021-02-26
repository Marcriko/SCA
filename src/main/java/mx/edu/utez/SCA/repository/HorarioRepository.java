package mx.edu.utez.SCA.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.DocenteDocument;
import mx.edu.utez.SCA.documents.HorarioDocument;
@Repository
public interface HorarioRepository extends MongoRepository<HorarioDocument, String> {
	List<HorarioDocument> findByDocente(DocenteDocument docenteDocument);
}
