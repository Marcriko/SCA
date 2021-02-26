package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.CarreraDocument;
import mx.edu.utez.SCA.documents.GrupoDocument;
import mx.edu.utez.SCA.repository.CarreraRepository;
import mx.edu.utez.SCA.repository.GrupoRepository;

@Service
@Transactional
public class GrupoService {
	@Autowired
	private GrupoRepository grupoRepository;
	@Autowired 
	private CarreraRepository carreraRepository;
	public boolean save(GrupoDocument grupoEntity,String id) {
		CarreraDocument carrera=carreraRepository.findById(id).get();
		grupoEntity.setCarrera(carrera);
		GrupoDocument grupo=grupoRepository.save(grupoEntity);
		return grupoRepository.existsById(grupo.getId());
	}
	
	public boolean delete(String id) {
		grupoRepository.deleteById(id);
		return grupoRepository.existsById(id);
	}
	
	public List<GrupoDocument>getAll(){
		return grupoRepository.findAll();
	}
	public GrupoDocument get(String id) {
		return grupoRepository.findById(id).get();
	}
	public List<GrupoDocument> listEsp(String id){
		return grupoRepository.findByCarrera(id);
	}
}
