package webseite.com.app.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String DNI;
	private String email;
	private String estado;
	//private Integer id_usuario;
	private String telefono;
	private String tipo_cliente;
	
	/*El mappedBy debe apuntar al campo correcto en la clase opuesta */
	@OneToOne(mappedBy ="cliente")
	private Usuario usuario;
	
	@OneToMany (mappedBy = "cliente") //debe coincidir con el nombre del atributo en Proyecto
	private List<Proyecto> proyectos; //nomenclatura cambia a plural
	
	public Clientes() {
		
	}

	public Clientes(Integer id_cliente, String nombres, String apellidos, String direccion, String dNI, String email,
			String estado, String telefono, String tipo_cliente, Usuario usuario, List<Proyecto> proyectos) {
		super();
		this.id_cliente = id_cliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		DNI = dNI;
		this.email = email;
		this.estado = estado;
		this.telefono = telefono;
		this.tipo_cliente = tipo_cliente;
		this.usuario = usuario;
		this.proyectos = proyectos;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo_cliente() {
		return tipo_cliente;
	}

	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	@Override
	public String toString() {
		return "Clientes [id_cliente=" + id_cliente + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", DNI=" + DNI + ", email=" + email + ", estado=" + estado
				+ ", telefono=" + telefono + ", tipo_cliente=" + tipo_cliente + ", usuario=" + usuario + ", proyectos="
				+ proyectos + "]";
	}

	
	
}
