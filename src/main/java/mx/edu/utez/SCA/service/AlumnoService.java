package mx.edu.utez.SCA.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.edu.utez.SCA.documents.AlumnoDocument;
import mx.edu.utez.SCA.documents.UsuarioDocument;
import mx.edu.utez.SCA.repository.AlumnoRepository;
@Service
@Transactional
public class AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepository;
	public boolean save(AlumnoDocument alumnoEntity) {
		AlumnoDocument  alumno=alumnoRepository.save(alumnoEntity);
		return alumnoRepository.existsById(alumno.getId());
	}
	public boolean delete(String id) {
		alumnoRepository.deleteById(id);
		return !alumnoRepository.existsById(id);
	}
	public List<AlumnoDocument> getAll(){
		return alumnoRepository.findAll();
	}
	public AlumnoDocument get(String id) {
		return alumnoRepository.findById(id).get();	
	}
	public AlumnoDocument getByUsuario(UsuarioDocument usuario) {
		return alumnoRepository.findByUsuario(usuario);
	}
}