package mx.edu.utez.SCA.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.UsuarioDocument;
@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioDocument, String> {
	UsuarioDocument findByUsuario(String usuario);
	
}
