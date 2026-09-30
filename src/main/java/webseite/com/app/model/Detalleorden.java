
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
@Table(name = "detalleorden")
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
    private int _condicion;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    private Orden orden;

    public Detalleorden() {
    }

    public Detalleorden(Integer id_detalleOrden, String descripcion, String estatus, Date fechaInicio,
            Date fechaEntrega, String tarea, String tipo, int _condicion, Orden orden) {
        this.id_detalleOrden = id_detalleOrden;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.tarea = tarea;
        this.tipo = tipo;
        this._condicion = _condicion;
        this.orden = orden;
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

    public int get_condicion() {
        return _condicion;
    }

    public void set_condicion(int _condicion) {
        this._condicion = _condicion;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "Detalleorden [id_detalleOrden=" + id_detalleOrden + ", descripcion=" + descripcion
                + ", estatus=" + estatus + ", fechaInicio=" + fechaInicio + ", fechaEntrega=" + fechaEntrega
                + ", tarea=" + tarea + ", tipo=" + tipo + ", _condicion=" + _condicion + "]";
    }
}