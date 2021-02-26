package mx.edu.utez.SCA.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.SCA.documents.DocenteDocument;
import mx.edu.utez.SCA.documents.HorarioDocument;
import mx.edu.utez.SCA.documents.UsuarioDocument;
@Repository
public interface DocenteRepository extends MongoRepository<DocenteDocument, String> {
	DocenteDocument findByUsuario(UsuarioDocument usuario);
	
}
