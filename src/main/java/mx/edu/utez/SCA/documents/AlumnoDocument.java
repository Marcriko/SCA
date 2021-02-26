package mx.edu.utez.SCA.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Alumno")
public class AlumnoDocument {
	@Id
	private String id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String matricula;
	private String correo;
	private String sexo;
	@DBRef(db="Asesoria")
	private UsuarioDocument usuario;
	@DBRef(db = "Asesoria")
	private GrupoDocument grupo;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public UsuarioDocument getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDocument usuario) {
		this.usuario = usuario;
	}
	public GrupoDocument getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoDocument grupo) {
		this.grupo = grupo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
