package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.AlumnoAsesoriaDocument;
import mx.edu.utez.SCA.documents.AlumnoDocument;
import mx.edu.utez.SCA.documents.AsesoriaDocument;
import mx.edu.utez.SCA.repository.AlumnoAsesoriaRepository;
import mx.edu.utez.SCA.repository.AlumnoRepository;
import mx.edu.utez.SCA.repository.AsesoriaRepository;


@Service
@Transactional
public class AlumnoAsesoriaService {
	@Autowired 
	private AlumnoAsesoriaRepository alumnoAsesoriaRepository;
	@Autowired
	private AsesoriaRepository asesoriaRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	public boolean save(AlumnoAsesoriaDocument alumnoAsesoria,String idAsesoria) {
		String idalumno =alumnoAsesoria.getAlumno().getId();
		AlumnoDocument al =alumnoRepository.findById(idalumno).get();
		alumnoAsesoria.setAlumno(al);
		AsesoriaDocument asesoria=asesoriaRepository.findById(idAsesoria).get();
		alumnoAsesoria.setAsesoria(asesoria);
		AlumnoAsesoriaDocument asesoriaAlumno=alumnoAsesoriaRepository.save(alumnoAsesoria);
		return alumnoAsesoriaRepository.existsById(asesoriaAlumno.getId()); 
	}
	
	public boolean delete(String id) {
		alumnoAsesoriaRepository.deleteById(id);
		return !alumnoAsesoriaRepository.existsById(id);
	} 
	
	public List<AlumnoAsesoriaDocument>getAll(){
		return alumnoAsesoriaRepository.findAll();
	}
	public  AlumnoAsesoriaDocument get(String id) {
		return alumnoAsesoriaRepository.findById(id).get();
	}
}
