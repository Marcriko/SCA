package mx.edu.utez.SCA.documents;



import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Usuario")
public class UsuarioDocument {
	@Id
	private String id;
	@NotNull
	@Size(min = 3,max = 10,message = "Field usuario must have at least 3 characters or 10 max")
	private String usuario;
	@NotNull
	@Size(min = 8,message = "Field password must have at least 8 characters or 10 max")
	private String password;
	private boolean enabled;
	@DBRef(db="Asesoria")
	private Set<RolDocument> rol;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<RolDocument> getRol() {
		return rol;
	}
	public void setRol(Set<RolDocument> rol) {
		this.rol = rol;
	}
	
	

	

	
}
