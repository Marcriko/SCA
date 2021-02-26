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

import mx.edu.utez.SCA.documents.PeriodoEscolarDocument;
import mx.edu.utez.SCA.service.PeriodoEscolarService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class PeriodoEscolarController {
	@Autowired
	private PeriodoEscolarService periodoEscolarService;
	@PostMapping("/periodo/save")
	public boolean save(@RequestBody PeriodoEscolarDocument periodoEscolarDocument) {
		return periodoEscolarService.save(periodoEscolarDocument);
	}
	@GetMapping("/periodo/list")
	public List<PeriodoEscolarDocument> list(){
		return periodoEscolarService.getAll();
	}
	@GetMapping("/periodo/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return periodoEscolarService.delete(id);
	}
	@GetMapping("/periodo/get/{id}")
	public PeriodoEscolarDocument get(@PathVariable String id) {
		return periodoEscolarService.get(id);
	}
}
