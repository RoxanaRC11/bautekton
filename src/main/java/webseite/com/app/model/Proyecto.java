package webseite.com.app.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_proyecto;
	//private Integer id_cliente;
	private Date fechaInicio;
	private Date fechaFin;
	private String Descripcion;
	private String estado;
	private String imagenprincipal;
	private String tipoProyecto;
	private String titulo;
	private String ubicacion;
	
	@OneToOne
	@JoinColumn(name ="id_orden")
	private Orden orden;
	
	/*Un proyecto puede tener varias ordenes (OnetoMany). El mappedBy apunta al campo "proyecto" en la clase Orden
	@OneToMany(mappedBy = "proyecto") 
	private List<Orden> orden;*/
	
	@OneToMany(mappedBy = "proyecto")
	private List<Detalleorden> detalleorden;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Clientes cliente;
	
	@OneToMany(mappedBy = "proyecto") //un proyecto puede tener muchas galerias
	private List<Galeria> galeria; 
	
	public Proyecto() {
		
	}

	public Proyecto(Integer id_proyecto, Date fechaInicio, Date fechaFin, String descripcion, String estado,
			String imagenprincipal, String tipoProyecto, String titulo, String ubicacion, Orden orden,
			List<Detalleorden> detalleorden, Clientes cliente, List<Galeria> galeria) {
		super();
		this.id_proyecto = id_proyecto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		Descripcion = descripcion;
		this.estado = estado;
		this.imagenprincipal = imagenprincipal;
		this.tipoProyecto = tipoProyecto;
		this.titulo = titulo;
		this.ubicacion = ubicacion;
		this.orden = orden;
		this.detalleorden = detalleorden;
		this.cliente = cliente;
		this.galeria = galeria;
	}

	public Integer getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(Integer id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagenprincipal() {
		return imagenprincipal;
	}

	public void setImagenprincipal(String imagenprincipal) {
		this.imagenprincipal = imagenprincipal;
	}

	public String getTipoProyecto() {
		return tipoProyecto;
	}

	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public List<Detalleorden> getDetalleorden() {
		return detalleorden;
	}

	public void setDetalleorden(List<Detalleorden> detalleorden) {
		this.detalleorden = detalleorden;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Galeria> getGaleria() {
		return galeria;
	}

	public void setGaleria(List<Galeria> galeria) {
		this.galeria = galeria;
	}

	@Override
	public String toString() {
		return "Proyecto [id_proyecto=" + id_proyecto + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", Descripcion=" + Descripcion + ", estado=" + estado + ", imagenprincipal=" + imagenprincipal
				+ ", tipoProyecto=" + tipoProyecto + ", titulo=" + titulo + ", ubicacion=" + ubicacion + ", orden="
				+ orden + ", detalleorden=" + detalleorden + ", cliente=" + cliente + ", galeria=" + galeria + "]";
	}

	
	
}
