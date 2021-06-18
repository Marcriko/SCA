package mx.edu.utez.SCA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.SCA.documents.GrupoDocument;
import mx.edu.utez.SCA.service.GrupoService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class GrupoController {
	@Autowired
	private GrupoService grupoService;
	
	@PostMapping("/grupo/save/{id}")
	public boolean save(@RequestBody GrupoDocument grupoDocument,@PathVariable String id) {
		return grupoService.save(grupoDocument, id);
	}
	@GetMapping("/grupo/list")
	public List<GrupoDocument> list(){
		return grupoService.getAll();
	}
	@GetMapping("/grupo/get/{id}")
	public GrupoDocument get(@PathVariable String id) {
		return grupoService.get(id);
	}
	@GetMapping ("/grupo/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return grupoService.delete(id);
	}
	@GetMapping("/grupo/getForCarrera/{id}")
	public List<GrupoDocument> getForCarrrera(@PathVariable String id){
		return grupoService.listEsp(id);
		
	}
}
