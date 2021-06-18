package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.AlumnoDocument;
import mx.edu.utez.SCA.documents.UsuarioDocument;
@Repository
public interface AlumnoRepository extends MongoRepository<AlumnoDocument, String>{
	AlumnoDocument findByUsuario(UsuarioDocument usuario);
}
