package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.DocenteDocument;
import mx.edu.utez.SCA.documents.HorarioDocument;
import mx.edu.utez.SCA.repository.HorarioRepository;


@Service
@Transactional
public class HorarioService {
	@Autowired
	private HorarioRepository horarioRepository;
	@Autowired 
	private DocenteService docenteService;
	public boolean save(HorarioDocument horarioDocument,String id) {
		DocenteDocument docente=docenteService.get(id);
		horarioDocument.setDocente(docente);
		HorarioDocument horario =horarioRepository.save(horarioDocument);
		return horarioRepository.existsById(horario.getId()); 
	}
	
	public boolean delete(String objectId) {
		horarioRepository.deleteById(objectId);
		return horarioRepository.existsById(objectId);
	}
	
	public List<HorarioDocument>getAll(){
		return horarioRepository.findAll();
	}
	public  HorarioDocument get(String id) {
		return horarioRepository.findById(id).get();
	}
}
