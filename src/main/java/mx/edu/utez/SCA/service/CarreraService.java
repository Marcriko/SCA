package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.CarreraDocument;
import mx.edu.utez.SCA.documents.DivisionDocument;
import mx.edu.utez.SCA.repository.CarreraRepository;
import mx.edu.utez.SCA.repository.DivisionRepository;
@Service
@Transactional
public class CarreraService {
	@Autowired
	private CarreraRepository carreraRepository;
	@Autowired
	private DivisionRepository divisionRepository;
	public boolean save(CarreraDocument carreraDocument,String id) {
		DivisionDocument div=divisionRepository.findBySiglas(id);
		carreraDocument.setDivision(div);
		CarreraDocument carrera=carreraRepository.save(carreraDocument);
		return carreraRepository.existsById(carrera.getId()); 
	}
	
	public boolean delete(String id) {
		carreraRepository.deleteById(id);
		return !carreraRepository.existsById(id);
	}
	
	public List<CarreraDocument>getAll(){
		return carreraRepository.findAll();
	}
	public  CarreraDocument get(String id) {
		
		return carreraRepository.findById(id).get();
	}

}
