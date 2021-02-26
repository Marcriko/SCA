package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.AsesoriaDocument;
import mx.edu.utez.SCA.documents.DocenteDocument;
import mx.edu.utez.SCA.documents.MateriaDocument;
import mx.edu.utez.SCA.documents.PeriodoEscolarDocument;
import mx.edu.utez.SCA.repository.AsesoriaRepository;
import mx.edu.utez.SCA.repository.DocenteRepository;
import mx.edu.utez.SCA.repository.MateriaRepository;
import mx.edu.utez.SCA.repository.PeriodoEscolarRepository;

@Service
@Transactional
public class AsesoriaService {
	@Autowired
	private AsesoriaRepository asesoriasRepository;
	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private PeriodoEscolarRepository escolarRepository;
	@Autowired 
	private MateriaRepository materiaRepository;
	public String save(AsesoriaDocument asesoriaDocument,String idDocente,String idPeriodo,String idMateria) {
		DocenteDocument docenteDocument=docenteRepository.findById(idDocente).get();
		asesoriaDocument.setDocente(docenteDocument);
		PeriodoEscolarDocument periodo=escolarRepository.findById(idPeriodo).get();
		asesoriaDocument.setPeriodoEscolar(periodo);
		MateriaDocument materia=materiaRepository.findById(idMateria).get();
		asesoriaDocument.setMateriaDocument(materia);
		AsesoriaDocument asesorias = asesoriasRepository.save(asesoriaDocument);
		return asesorias.getId();
	}
	
	public boolean delete(String id) {
		asesoriasRepository.deleteById(id);
		return !asesoriasRepository.existsById(id);
	}
	
	public List<AsesoriaDocument> getAll(){
		return asesoriasRepository.findAll();
	}
	public AsesoriaDocument get(String id) {
		return asesoriasRepository.findById(id).get();
	}

}
