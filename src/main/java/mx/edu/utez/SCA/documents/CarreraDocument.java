package mx.edu.utez.SCA.documents;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Carrera")
public class CarreraDocument {
	@Id
	private String id;
	@NotBlank(message = "nombre carrera no debe ir vacio")
	@NotNull(message = "nombre carrera no debe ser nulo")
	private String nombreCarrera;
	@NotBlank(message = "siglas carrera no debe ir vacio")
	@NotNull(message = "siglas carrera no debe ser nulo")
	private String siglas;
	
	@DBRef
	private DivisionDocument division;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public DivisionDocument getDivision() {
		return division;
	}
	public void setDivision(DivisionDocument division) {
		this.division = division;
	}
	
	
}
