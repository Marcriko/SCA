package mx.edu.utez.SCA.documents;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Grupo")
public class GrupoDocument {
	@Id 
	private String id;
	@NotBlank(message = "nombre division no debe ir vacio")
	@NotNull(message = "nombreDivision no debe ser nulo")
	
	private String letra;
	@NotBlank(message = "letra no debe ir vacio")
	@NotNull(message = "cuatrimestre no debe ser nulo")
	
	private String cuatrimestre;
	@DBRef
	private CarreraDocument carrera;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(String cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}
	public CarreraDocument getCarrera() {
		return carrera;
	}
	public void setCarrera(CarreraDocument carrera) {
		this.carrera = carrera;
	}
	
	
}
