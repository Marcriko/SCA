package mx.edu.utez.SCA.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.SCA.documents.MateriaDocument;
import mx.edu.utez.SCA.service.MateriaService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class MateriaController {
	@Autowired
	private MateriaService materiaService;
	@PostMapping(value = "/materia/save/{id}/{idPeriodo}")
	public boolean save(@RequestBody MateriaDocument materiaDocument,@PathVariable Map<String, String> vals) {
		System.out.println(vals.get("id")+"         "+vals.get("idPeriodo"));
		return materiaService.save(materiaDocument, vals.get("id"),vals.get("idPeriodo"));
		
	}
	@GetMapping("/materia/list")
	public List<MateriaDocument>list(){
		return materiaService.getAll();
	}
	
}
