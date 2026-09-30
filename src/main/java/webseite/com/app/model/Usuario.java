package webseite.com.app.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    private String nombre;
    private String contrasena;
    private String email;
    private Date fechaRegistro;
    private Date fechaActualizacion;
    private String estado;
    private int _condicion;

    @OneToOne
    @JoinColumn(name = "id_cliente", unique = true)
    private Clientes cliente;

    @Transient
    private boolean loggedIn;

    @Transient
    private String sessionToken;

    public Usuario() {
    }

    public Usuario(Integer id_usuario, String nombre, String contrasena, String email, Date fechaRegistro,
            Date fechaActualizacion, String estado, int _condicion, Clientes cliente) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
        this._condicion = _condicion;
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

    public int get_condicion() {
        return _condicion;
    }

    public void set_condicion(int _condicion) {
        this._condicion = _condicion;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", email=" + email
                + ", fechaRegistro=" + fechaRegistro + ", fechaActualizacion=" + fechaActualizacion
                + ", estado=" + estado + ", _condicion=" + _condicion + "]";
    }
}