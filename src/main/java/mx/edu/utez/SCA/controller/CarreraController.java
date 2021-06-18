package mx.edu.utez.SCA.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.SCA.documents.CarreraDocument;
import mx.edu.utez.SCA.service.CarreraService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT }, allowedHeaders = "*")
public class CarreraController {
	@Autowired
	private CarreraService carreraService;

	@GetMapping("/carrera/list")
	public List<CarreraDocument> list() {
		return carreraService.getAll();
	}

	@GetMapping("/carrera/get/{id}")
	public CarreraDocument get(@PathVariable String id) {
		System.out.println(id);
		return carreraService.get(id);
	}

	@PostMapping("/carrera/save")
	public boolean save(@Valid @RequestBody CarreraDocument carreraDocument,@NotBlank @NotNull @RequestParam("id") String id) {
		System.out.println(id + " ----------- " + carreraDocument.getNombreCarrera());

		return carreraService.save(carreraDocument, id);

	}

	@DeleteMapping("/carrera/delete/{id}")
	public boolean delete(@PathVariable String id) {
		System.out.println(id);
		return carreraService.delete(id);
	}
} 	
