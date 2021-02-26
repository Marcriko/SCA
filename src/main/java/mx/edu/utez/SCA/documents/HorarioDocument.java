package mx.edu.utez.SCA.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Horario")
public class HorarioDocument {
	@Id
	private String id;
	private String dia;
	private String horaInicio;
	private String horaFinal;
	@DBRef
	private DocenteDocument docente;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public DocenteDocument getDocente() {
		return docente;
	}
	public void setDocente(DocenteDocument docente) {
		this.docente = docente;
	}
	
}
