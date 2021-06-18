package mx.edu.utez.SCA.controller;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.SCA.documents.DocenteDocument;
import mx.edu.utez.SCA.documents.RolDocument;
import mx.edu.utez.SCA.documents.UsuarioDocument;
import mx.edu.utez.SCA.repository.RolRepository;
import mx.edu.utez.SCA.service.DocenteService;
import mx.edu.utez.SCA.service.UsuarioService;
@RestController
@RequestMapping("/app")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")
public class DocenteController {
	@Autowired
	private UsuarioService usuarioS;
	@Autowired
	private DocenteService docenteServie;
	@Autowired
	private RolRepository rolRepo;
//	@PostMapping("/docente/save")
//	public boolean save(@RequestBody DocenteDocument docenteDocument,@PathVariable String idUss) {
//		return docenteServie.save(docenteDocument, idUss);
//	}
	@GetMapping("/docente/list")
	public List<DocenteDocument> list(){
		return docenteServie.getAll();
	}
	@GetMapping("/docente/get/{id}")
	public DocenteDocument get(@PathVariable String id){
		return docenteServie.get(id);
	}
	@PostMapping("/docente/saveUs")
	public boolean saveAll(@RequestBody DocenteDocument docenteDocument) {
		RolDocument rol = rolRepo.findByRol("ROLE_DOCENTE");
		UsuarioDocument usuario = docenteDocument.getUsuario();
		System.out.println(docenteDocument.getUsuario().getUsuario()+"DSADADSA	"+docenteDocument.getNombre());
		usuario.setRol(new HashSet<>(Arrays.asList(rol)));
		usuarioS.save(usuario);
		docenteDocument.setUsuario(usuario);
		return docenteServie.save(docenteDocument);
	}
	@DeleteMapping("/docente/delete/{id}")
	public boolean delete(@PathVariable String id) {
		System.out.println(id);
		return docenteServie.delete(id);
	}
}
