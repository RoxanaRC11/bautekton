package webseite.com.app.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	/*private Integer id_cliente; Eliminacion de la clase foreanea. La tabla usuario en DB tiene la FK id_cliente. Se utiliza en el JPA se debe
	 * usar el Objeto Clientes y la anotacion @JoinColumn en su lugar */
	private Integer id_usuario;
	private String nombre;
	private String contrasena;
	private String email;
	private Date fechaRegistro;
	private Date fechaActualizacion;
	private String estado;
	
	@OneToOne
	@JoinColumn(name="id_cliente")
	private Clientes cliente;
	
	public Usuario() {
		
	}

	public Usuario(Integer id_usuario, String nombre, String contrasena, String email, Date fechaRegistro,
			Date fechaActualizacion, String estado, Clientes cliente) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.cliente = cliente;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", contrasena=" + contrasena + ", email="
				+ email + ", fechaRegistro=" + fechaRegistro + ", fechaActualizacion=" + fechaActualizacion
				+ ", estado=" + estado + ", cliente=" + cliente + "]";
	}

	
}
