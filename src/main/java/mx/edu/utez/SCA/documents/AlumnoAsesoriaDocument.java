package mx.edu.utez.SCA.documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection  = "AlumnoAsesoria")
public class AlumnoAsesoriaDocument {
	@Id
	private String id;
	@DBRef(db="Asesorias")
	private AsesoriaDocument asesoria;
	@DBRef(db="Asesorias")
	private AlumnoDocument alumno;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AsesoriaDocument getAsesoria() {
		return asesoria;
	}
	public void setAsesoria(AsesoriaDocument asesoria) {
		this.asesoria = asesoria;
	}
	public AlumnoDocument getAlumno() {
		return alumno;
	}
	public void setAlumno(AlumnoDocument alumno) {
		this.alumno = alumno;
	}
	
}
