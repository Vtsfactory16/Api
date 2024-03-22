package com.example.api.Models.entidades;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "chats", schema = "baseanimal", catalog = "")
public class EntidadChats {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_usuario_envia", nullable = true)
    private Integer idUsuarioEnvia;
    @Basic
    @Column(name = "id_usuario_recibe", nullable = true)
    private Integer idUsuarioRecibe;
    @Basic
    @Column(name = "mensaje", nullable = true, length = -1)
    private String mensaje;
    @Basic
    @Column(name = "fecha_envio", nullable = true)
    private Timestamp fechaEnvio;
    @ManyToOne
    @JoinColumn(name = "id_usuario_envia", referencedColumnName = "id")
    private EntidadUsuarios usuariosByIdUsuarioEnvia;
    @ManyToOne
    @JoinColumn(name = "id_usuario_recibe", referencedColumnName = "id")
    private EntidadUsuarios usuariosByIdUsuarioRecibe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdUsuarioEnvia() {
        return idUsuarioEnvia;
    }

    public void setIdUsuarioEnvia(Integer idUsuarioEnvia) {
        this.idUsuarioEnvia = idUsuarioEnvia;
    }

    public Integer getIdUsuarioRecibe() {
        return idUsuarioRecibe;
    }

    public void setIdUsuarioRecibe(Integer idUsuarioRecibe) {
        this.idUsuarioRecibe = idUsuarioRecibe;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadChats that = (EntidadChats) o;
        return id == that.id && Objects.equals(idUsuarioEnvia, that.idUsuarioEnvia) && Objects.equals(idUsuarioRecibe, that.idUsuarioRecibe) && Objects.equals(mensaje, that.mensaje) && Objects.equals(fechaEnvio, that.fechaEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuarioEnvia, idUsuarioRecibe, mensaje, fechaEnvio);
    }

    public EntidadUsuarios getUsuariosByIdUsuarioEnvia() {
        return usuariosByIdUsuarioEnvia;
    }

    public void setUsuariosByIdUsuarioEnvia(EntidadUsuarios usuariosByIdUsuarioEnvia) {
        this.usuariosByIdUsuarioEnvia = usuariosByIdUsuarioEnvia;
    }

    public EntidadUsuarios getUsuariosByIdUsuarioRecibe() {
        return usuariosByIdUsuarioRecibe;
    }

    public void setUsuariosByIdUsuarioRecibe(EntidadUsuarios usuariosByIdUsuarioRecibe) {
        this.usuariosByIdUsuarioRecibe = usuariosByIdUsuarioRecibe;
    }
}
