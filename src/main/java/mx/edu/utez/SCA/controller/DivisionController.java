package mx.edu.utez.SCA.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.SCA.documents.DivisionDocument;
import mx.edu.utez.SCA.service.DivisionService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
public class DivisionController {
	@Autowired
	private DivisionService divisionService;
	@GetMapping("/division/list")
	public List<DivisionDocument> list(){
		return divisionService.getAll();
	}
	@PostMapping("/division/save")
	public boolean save(@Valid @RequestBody DivisionDocument divisionDocument) {
		return divisionService.save(divisionDocument);
	}
	@GetMapping("/division/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return divisionService.delete(id);
	}
	@GetMapping("/division/get/{id}")
	public DivisionDocument get(@PathVariable String id) {
		return divisionService.get(id);
	}
}
