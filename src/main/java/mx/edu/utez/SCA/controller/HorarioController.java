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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.SCA.documents.HorarioDocument;
import mx.edu.utez.SCA.service.HorarioService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class HorarioController {
	@Autowired
	private HorarioService horarioService;
	@PostMapping("/horario/save")
	public boolean save(@RequestBody HorarioDocument horarioDocument,@RequestParam String id) {
		
		return horarioService.save(horarioDocument, id);
	}
	@GetMapping("/horario/list")
	public List<HorarioDocument> list(){
		System.out.println("WWWWWWWWWWWWWWWW");
		return horarioService.getAll();
	}
	@PostMapping("/horario/delte/{id}")
	public HorarioDocument get(@PathVariable String id) {
		return horarioService.get(id);
	}
	@GetMapping("/horario/delete")
	public boolean delete(@PathVariable String id) {
		return horarioService.delete(id);
	}
	
}
