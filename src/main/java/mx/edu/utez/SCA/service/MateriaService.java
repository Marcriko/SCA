package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.CarreraDocument;
import mx.edu.utez.SCA.documents.MateriaDocument;
import mx.edu.utez.SCA.documents.PeriodoEscolarDocument;
import mx.edu.utez.SCA.repository.CarreraRepository;
import mx.edu.utez.SCA.repository.MateriaRepository;
import mx.edu.utez.SCA.repository.PeriodoEscolarRepository;


@Service
@Transactional
public class MateriaService {
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private CarreraRepository carreraRepository;
	@Autowired
	private PeriodoEscolarRepository periodoEscolarRepository;
	public boolean save(MateriaDocument materiaDocument,String idCarrera,String idPeriodo) {
		CarreraDocument carrera =carreraRepository.findById(idCarrera).get();
		materiaDocument.setCarreraDocument(carrera);
		
		PeriodoEscolarDocument periodo=periodoEscolarRepository.findById(idPeriodo).get();
		materiaDocument.setPeriodoEscolar(periodo);
		
		MateriaDocument materia= materiaRepository.save(materiaDocument);
		return materiaRepository.existsById(materia.getId()); 
	}
	
	public boolean delete(String id) {
		materiaRepository.deleteById(id);
		return materiaRepository.existsById(id);
	}
	public List<MateriaDocument>getAll(){
		return materiaRepository.findAll();
	}
	public  MateriaDocument get(String id) {
		return materiaRepository.findById(id).get();
	}
}
