package mx.edu.utez.SCA.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "MateriaDocente")
public class MateriaDocenteDocument {
	@Id
	private String id;
	@DBRef
	private DocenteDocument docente;
	@DBRef 
	private MateriaDocument materia;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DocenteDocument getDocente() {
		return docente;
	}
	public void setDocente(DocenteDocument docente) {
		this.docente = docente;
	}
	public MateriaDocument getMateria() {
		return materia;
	}
	public void setMateria(MateriaDocument materia) {
		this.materia = materia;
	}
}
