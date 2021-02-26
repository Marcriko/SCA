package mx.edu.utez.SCA.controller;

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

import mx.edu.utez.SCA.documents.AlumnoAsesoriaDocument;
import mx.edu.utez.SCA.documents.AlumnoDocument;
import mx.edu.utez.SCA.documents.AsesoriaDocument;
import mx.edu.utez.SCA.service.AlumnoAsesoriaService;
import mx.edu.utez.SCA.service.AsesoriaService;

@RestController
@RequestMapping("/app")
@PreAuthorize("ROLE_ALUMNO")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class AsesoriaController {
	@Autowired
	private AsesoriaService asesoriaService;
	@Autowired
	private AlumnoAsesoriaService alumnoAsesoriaService;
//	@PostMapping("/asesoria/saveLL/{idDocente}/{idPeriodo}/{idMateria}")
//	public boolean save(@RequestBody AsesoriaDocument asesoriaDocument,@PathVariable String idDocente,@RequestBody List<AlumnoAsesoriaDocument> listaAlumno,@PathVariable String idPeriodo,@PathVariable String idMateria) {
//		
//		String idAsesoria = asesoriaService.save(asesoriaDocument, idDocente,idPeriodo,idMateria);
//		for (AlumnoAsesoriaDocument alumnoAsesoriaDocument : listaAlumno) {
//			AlumnoDocument alumno=alumnoAsesoriaDocument.getAlumno();
//			alumnoAsesoriaService.save( alumno.getId(), idAsesoria);
//		}
//		return true;
//	}
	@GetMapping("/asesoria/delete/{idAsesoria}/{idAlumnoAsesoria}")
	public boolean delete(@PathVariable String idAsesoria,@PathVariable String idAlumnoAsesoria) {
		alumnoAsesoriaService.delete(idAlumnoAsesoria);
		return asesoriaService.delete(idAsesoria);
	}
	@GetMapping("/asesoria/get/{id}")
	public AlumnoAsesoriaDocument get(@PathVariable String id) {
		return alumnoAsesoriaService.get(id);
	}
	@PostMapping("/asesoria/save/{idDocente}/{idPeriodo}/{idMateria}")
	public String save(@RequestBody AsesoriaDocument asesoriaDocument,@PathVariable String idDocente,@PathVariable String idPeriodo,@PathVariable String idMateria) {
		return asesoriaService.save(asesoriaDocument, idDocente, idPeriodo, idMateria);
	}
	@PostMapping("/alumnoAsesoria/save/{idAsesoria}")
	public void saveAlumnoAsesoria(@RequestBody List<AlumnoAsesoriaDocument> alumnoAsesoriaDocuments,@PathVariable String idAsesoria) {
		System.out.println(idAsesoria);
		for (AlumnoAsesoriaDocument a:alumnoAsesoriaDocuments) {
			System.out.println(a.getAlumno().getId());
			alumnoAsesoriaService.save(a, idAsesoria);	
		}
	}
	@GetMapping("/asesorias/list")
	public List<AlumnoAsesoriaDocument>list(){
		return alumnoAsesoriaService.getAll();
	}
	@GetMapping("/asesoria/list2")
	public List<AsesoriaDocument> lista(){
		return asesoriaService.getAll();
	}

}
