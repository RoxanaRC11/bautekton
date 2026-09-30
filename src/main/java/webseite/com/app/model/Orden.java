package webseite.com.app.model;

import java.sql.Date;
import java.util.List;

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
@Table(name="orden")
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_orden;
	//private Integer id_proyecto;//la relacion de OnetoOne con Proyecto debe ser gestionado por el mapeo de entidades
	private String descripcion;
	private String estado;
	private Date fechaInicio;
	private Date fechaEntrega;
	private String tipoOrden;
	private int _condicion;
	
	/*Sie se asume que una Orden siempre pertenece a un Proyecto y un Proyecto tiene una Orden, esto es OnetoOne. Pero si el Proyecto es el propietario: Orden debe ser al lado 
	 inverso, no propietario. En el codigo: @OnetoOne(mappedBy ="orden") private Proyecto proyecto; (Esto esta correcto en el codigo, asumiendo que el campo en Proyecto se llama orden)*/
	
	// Relacion 1: Con Proyecto (Muchos a Uno)
	// Aqui no debe llevar mappedBy porque "orden" tiene la FK "id_proyecto"
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;
	
	// Relacion 2: Con Detalleorden  (Uno a Muchos)
	// Esto esta Bien: Aqui si va mappedBy porque Detalleorden es quien tiene la FK hacia Orden
	@OneToMany(mappedBy = "orden")// significa que en este campo una orden puede tener varias detalle de orden
	private List<Detalleorden> detallesorden;
	
	
	public Orden() {
		
	}


	public Orden(Integer id_orden, String descripcion, String estado, Date fechaInicio, Date fechaEntrega,
			String tipoOrden, int _condicion, Proyecto proyecto, List<Detalleorden> detallesorden) {
		super();
		this.id_orden = id_orden;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
		this.tipoOrden = tipoOrden;
		this._condicion = _condicion;
		this.proyecto = proyecto;
		this.detallesorden = detallesorden;
	}


	public Integer getId_orden() {
		return id_orden;
	}


	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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


	public String getTipoOrden() {
		return tipoOrden;
	}


	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}


	public int get_condicion() {
		return _condicion;
	}


	public void set_condicion(int _condicion) {
		this._condicion = _condicion;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	public List<Detalleorden> getDetallesorden() {
		return detallesorden;
	}


	public void setDetallesorden(List<Detalleorden> detallesorden) {
		this.detallesorden = detallesorden;
	}


	@Override
	public String toString() {
		return "Orden [id_orden=" + id_orden + ", descripcion=" + descripcion + ", estado=" + estado + ", fechaInicio="
				+ fechaInicio + ", fechaEntrega=" + fechaEntrega + ", tipoOrden=" + tipoOrden + ", _condicion="
				+ _condicion + ", proyecto=" + proyecto + ", detallesorden=" + detallesorden + "]";
	}
	
}
