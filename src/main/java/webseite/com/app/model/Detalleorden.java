package webseite.com.app.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalleorden")
public class Detalleorden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detalleOrden;
	private String descripcion;
	private String estatus;
	private Date fechaInicio;
	private Date fechaEntrega;
	private String tarea;
	private String tipo;
	/*Se elimina estos dos campos ya q al usar @ManytoOne, JPA crea la clave foranea. Se debe utilzar las entidades completas (Orden y Proyecto) con @ManyToOne y @JoinColumn*/
	//private Integer id_orden;
	//private Integer id_proyecto;
	
	
	@ManyToOne 
	@JoinColumn(name = "id_orden")
	private Orden orden;
	
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto; 
	
	
	public Detalleorden() {
		
	}


	public Detalleorden(Integer id_detalleOrden, String descripcion, String estatus, Date fechaInicio,
			Date fechaEntrega, String tarea, String tipo, Orden orden, Proyecto proyecto) {
		super();
		this.id_detalleOrden = id_detalleOrden;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
		this.tarea = tarea;
		this.tipo = tipo;
		this.orden = orden;
		this.proyecto = proyecto;
	}


	public Integer getId_detalleOrden() {
		return id_detalleOrden;
	}


	public void setId_detalleOrden(Integer id_detalleOrden) {
		this.id_detalleOrden = id_detalleOrden;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public String getTarea() {
		return tarea;
	}


	public void setTarea(String tarea) {
		this.tarea = tarea;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Orden getOrden() {
		return orden;
	}


	public void setOrden(Orden orden) {
		this.orden = orden;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	@Override
	public String toString() {
		return "Detalleorden [id_detalleOrden=" + id_detalleOrden + ", descripcion=" + descripcion + ", estatus="
				+ estatus + ", fechaInicio=" + fechaInicio + ", fechaEntrega=" + fechaEntrega + ", tarea=" + tarea
				+ ", tipo=" + tipo + ", orden=" + orden + ", proyecto=" + proyecto + "]";
	}

	
}
