package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.PeriodoEscolarDocument;
import mx.edu.utez.SCA.repository.PeriodoEscolarRepository;

@Service
@Transactional
public class PeriodoEscolarService {
	@Autowired
	private PeriodoEscolarRepository periodoRepository;
	public boolean save(PeriodoEscolarDocument periodoEntiry) {
		PeriodoEscolarDocument periodo=periodoRepository.save(periodoEntiry);
		return periodoRepository.existsById(periodo.getId()); 
	}
	
	public boolean delete(String id) {
		periodoRepository.deleteById(id);
		
		return !periodoRepository.existsById(id);
	}
	
	public List<PeriodoEscolarDocument>getAll(){
		return periodoRepository.findAll();
	}
	public PeriodoEscolarDocument get(String id) {
		return periodoRepository.findById(id).get();
	}
}
