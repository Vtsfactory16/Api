package com.example.api.Models.entidades;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "chats", schema = "baseanimal")
public class EntidadChats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario_envia")
    private Long idUsuarioEnvia;

    @Column(name = "id_usuario_recibe")
    private Long idUsuarioRecibe;

    @Column(name = "mensaje", length = -1)
    private String mensaje;

    @Column(name = "fecha_envio")
    private Timestamp fechaEnvio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_envia", referencedColumnName = "id", insertable = false, updatable = false)
    private EntidadUsuarios usuariosByIdUsuarioEnvia;

    @ManyToOne
    @JoinColumn(name = "id_usuario_recibe", referencedColumnName = "id", insertable = false, updatable = false)
    private EntidadUsuarios usuariosByIdUsuarioRecibe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuarioEnvia() {
        return idUsuarioEnvia;
    }

    public void setIdUsuarioEnvia(Long idUsuarioEnvia) {
        this.idUsuarioEnvia = idUsuarioEnvia;
    }

    public Long getIdUsuarioRecibe() {
        return idUsuarioRecibe;
    }

    public void setIdUsuarioRecibe(Long idUsuarioRecibe) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadChats that = (EntidadChats) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idUsuarioEnvia, that.idUsuarioEnvia) &&
                Objects.equals(idUsuarioRecibe, that.idUsuarioRecibe) &&
                Objects.equals(mensaje, that.mensaje) &&
                Objects.equals(fechaEnvio, that.fechaEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuarioEnvia, idUsuarioRecibe, mensaje, fechaEnvio);
    }
}
