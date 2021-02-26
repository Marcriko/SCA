package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.DivisionDocument;
import mx.edu.utez.SCA.repository.DivisionRepository;
@Service
@Transactional
public class DivisionService {
	@Autowired
	private DivisionRepository divisionRepository;
	public boolean save(DivisionDocument divisionDocument) {
		DivisionDocument division=divisionRepository.save(divisionDocument);
		return divisionRepository.existsById(division.getId()); 
	}
	
	public boolean delete(String id) {
		divisionRepository.deleteById(id);
		return !divisionRepository.existsById(id);
	}
	
	public List<DivisionDocument>getAll(){
		return divisionRepository.findAll();
	}
	public  DivisionDocument get(String id) {
		return divisionRepository.findById(id).get();
	}
}
