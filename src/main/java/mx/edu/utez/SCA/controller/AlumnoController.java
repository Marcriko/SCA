package mx.edu.utez.SCA.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.SCA.documents.AlumnoDocument;
import mx.edu.utez.SCA.documents.GrupoDocument;
import mx.edu.utez.SCA.documents.RolDocument;
import mx.edu.utez.SCA.documents.UsuarioDocument;
import mx.edu.utez.SCA.repository.RolRepository;
import mx.edu.utez.SCA.repository.UsuarioRepository;
import mx.edu.utez.SCA.service.AlumnoService;
import mx.edu.utez.SCA.service.GrupoService;
import mx.edu.utez.SCA.service.UsuarioService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class AlumnoController {
	@Autowired
	private UsuarioService usuarioS;
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private RolRepository rolRepo;
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private GrupoService grupoSer;
	@PostMapping("/alumno/saveP")
	public boolean saveP(@RequestBody AlumnoDocument alumno) {
		System.out.println("NOMBRE: "+alumno.getNombre());
		RolDocument rol = rolRepo.findByRol("ROLE_ALUMNO");
		UsuarioDocument usuario = alumno.getUsuario();
		usuario.setRol(new HashSet<>(Arrays.asList(rol)));
		usuarioS.save(usuario);
		List<GrupoDocument> lista = grupoSer.getAll();
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i).getCarrera().getSiglas());
			System.out.println(lista.get(i).getCuatrimestre());
			System.out.println(lista.get(i).getLetra());

			if(lista.get(i).getCarrera().getSiglas().equals(alumno.getGrupo().getCarrera().getSiglas()) && 
					lista.get(i).getCuatrimestre().equals(alumno.getGrupo().getCuatrimestre()) &&
					lista.get(i).getLetra().equals(alumno.getGrupo().getLetra())) {
				alumno.setGrupo(lista.get(i));
			}
		}
		//return true;
		//alumno.setUsuario(usuario);
		return alumnoService.save(alumno);
	}
	@PostMapping("/alumno/perfil")
	@PreAuthorize("ROLE_ALUMNO")
	public AlumnoDocument get(@RequestBody UsuarioDocument usuario) {
		return alumnoService.getByUsuario(usuarioRepo.findByUsuario(usuario.getUsuario()));
	}
}