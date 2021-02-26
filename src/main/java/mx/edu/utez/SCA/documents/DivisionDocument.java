package mx.edu.utez.SCA.documents;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="Division")
public class DivisionDocument {
	@Id
	private String id;
	@NotBlank(message = "nombre division no debe ir vacio")
	@NotNull(message = "nombreDivision no debe ser nulo")
	private String nombreDivision;
	@Size(max = 5,min = 3,message = "limite de 5 caracteres")
	@NotBlank(message = "siglas no debe ir vacío")
	@NotNull(message = "Siglas no debe ser nulo")
	private String siglas;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreDivision() {
		return nombreDivision;
	}
	public void setNombreDivision(String nombreDivision) {
		this.nombreDivision = nombreDivision;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	
}
