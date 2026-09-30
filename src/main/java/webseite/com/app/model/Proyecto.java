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
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proyecto;

    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String estado;
    private String imagenprincipal;
    private String tipoProyecto;
    private String titulo;
    private String ubicacion;
    private int _condicion;

    @OneToMany(mappedBy = "proyecto")
    private List<Orden> ordenes;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    @OneToMany(mappedBy = "proyecto")
    private List<Galeria> galerias;

    public Proyecto() {
    }

    public Proyecto(Integer id_proyecto, Date fechaInicio, Date fechaFin, String descripcion, String estado,
            String imagenprincipal, String tipoProyecto, String titulo, String ubicacion, int _condicion,
            List<Orden> ordenes, Clientes cliente, List<Galeria> galerias) {
        this.id_proyecto = id_proyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.estado = estado;
        this.imagenprincipal = imagenprincipal;
        this.tipoProyecto = tipoProyecto;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this._condicion = _condicion;
        this.ordenes = ordenes;
        this.cliente = cliente;
        this.galerias = galerias;
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

    public int get_condicion() {
        return _condicion;
    }

    public void set_condicion(int _condicion) {
        this._condicion = _condicion;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Galeria> getGalerias() {
        return galerias;
    }

    public void setGalerias(List<Galeria> galerias) {
        this.galerias = galerias;
    }

    @Override
    public String toString() {
        return "Proyecto [id_proyecto=" + id_proyecto + ", fechaInicio=" + fechaInicio
                + ", fechaFin=" + fechaFin + ", descripcion=" + descripcion + ", estado=" + estado
                + ", imagenprincipal=" + imagenprincipal + ", tipoProyecto=" + tipoProyecto + ", titulo=" + titulo
                + ", ubicacion=" + ubicacion + ", _condicion=" + _condicion + "]";
    }
}