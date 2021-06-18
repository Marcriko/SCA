package mx.edu.utez.SCA.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="asesoria")
public class AsesoriaDocument {
	@Id
	private String id;
	private String fecha; 
	private String descripcion;
	private boolean asesoriaCanalizacion;
	private String horaInicio;
	private String horaFinal;
	private int estadoAsesoria;
	@DBRef
	private PeriodoEscolarDocument periodoEscolar;
	@DBRef
	private DocenteDocument docente;
	@DBRef
	private MateriaDocument materiaDocument;
		
	public MateriaDocument getMateriaDocument() {
		return materiaDocument;
	}
	public void setMateriaDocument(MateriaDocument materiaDocument) {
		this.materiaDocument = materiaDocument;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isAsesoriaCanalizacion() {
		return asesoriaCanalizacion;
	}
	public void setAsesoriaCanalizacion(boolean asesoriaCanalizacion) {
		this.asesoriaCanalizacion = asesoriaCanalizacion;
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
	public int getEstadoAsesoria() {
		return estadoAsesoria;
	}
	public void setEstadoAsesoria(int estadoAsesoria) {
		this.estadoAsesoria = estadoAsesoria;
	}
	public PeriodoEscolarDocument getPeriodoEscolar() {
		return periodoEscolar;
	}
	public void setPeriodoEscolar(PeriodoEscolarDocument periodoEscolar) {
		this.periodoEscolar = periodoEscolar;
	}
	public DocenteDocument getDocente() {
		return docente;
	}
	public void setDocente(DocenteDocument docente) {
		this.docente = docente;
	}
	
	
}
