
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
@Table(name = "galeria")
public class Galeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_archivo;

    private String nombre;
    private String descripcion;
    private String ruta;
    private String tipo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private int _condicion;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    public Galeria() {
    }

    public Galeria(Integer id_archivo, String nombre, String descripcion, String ruta, String tipo, Date fechaCreacion,
            Date fechaModificacion, int _condicion, Proyecto proyecto) {
        this.id_archivo = id_archivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ruta = ruta;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this._condicion = _condicion;
        this.proyecto = proyecto;
    }

    public Integer getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(Integer id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    @Override
    public String toString() {
        return "Galeria [id_archivo=" + id_archivo + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", ruta=" + ruta + ", tipo=" + tipo + ", fechaCreacion=" + fechaCreacion
                + ", fechaModificacion=" + fechaModificacion + ", _condicion=" + _condicion + "]";
    }
}