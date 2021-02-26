package mx.edu.utez.SCA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.utez.SCA.documents.DocenteDocument;
import mx.edu.utez.SCA.documents.UsuarioDocument;
import mx.edu.utez.SCA.repository.DocenteRepository;
import mx.edu.utez.SCA.repository.UsuarioRepository;


@Service
@Transactional
public class DocenteService {
	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired 
	private UsuarioRepository usuarioRepository;
	public boolean save(DocenteDocument docenteEntity) {
		usuarioService.save(docenteEntity.getUsuario());
		DocenteDocument docente =docenteRepository.save(docenteEntity);
		return docenteRepository.existsById(docente.getId());
	}
	
	public boolean delete(String id) {
		System.out.println(id);
		docenteRepository.deleteById(id);
		
		return docenteRepository.existsById(id);
	}
	
	public List<DocenteDocument>getAll(){
		return docenteRepository.findAll();
	}
	public DocenteDocument get(String id) {
		return docenteRepository.findById(id).get();
	}
}
