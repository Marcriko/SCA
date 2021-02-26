package mx.edu.utez.SCA.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Materia")
public class MateriaDocument {
	@Id
	private String id;
	private String nombreMateria;
	@DBRef
	private CarreraDocument carreraDocument;
	@DBRef
	private PeriodoEscolarDocument periodoEscolar;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreMateria() {
		return nombreMateria;
	}
	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	public CarreraDocument getCarreraDocument() {
		return carreraDocument;
	}
	public void setCarreraDocument(CarreraDocument carreraDocument) {
		this.carreraDocument = carreraDocument;
	}
	public PeriodoEscolarDocument getPeriodoEscolar() {
		return periodoEscolar;
	}
	public void setPeriodoEscolar(PeriodoEscolarDocument periodoEscolar) {
		this.periodoEscolar = periodoEscolar;
	}
	
	
}
