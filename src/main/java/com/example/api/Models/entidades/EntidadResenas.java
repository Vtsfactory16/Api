package com.example.api.Models.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "resenas", schema = "baseanimal", catalog = "")
public class EntidadResenas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_usuario", nullable = true)
    private Integer idUsuario;
    @Basic
    @Column(name = "id_cuidador", nullable = true)
    private Integer idCuidador;
    @Basic
    @Column(name = "puntuacion", nullable = true)
    private Integer puntuacion;
    @Basic
    @Column(name = "comentario", nullable = true, length = -1)
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private EntidadUsuarios usuariosByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "id_cuidador", referencedColumnName = "id")
    private EntidadUsuarios usuariosByIdCuidador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(Integer idCuidador) {
        this.idCuidador = idCuidador;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadResenas that = (EntidadResenas) o;
        return id == that.id && Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idCuidador, that.idCuidador) && Objects.equals(puntuacion, that.puntuacion) && Objects.equals(comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idCuidador, puntuacion, comentario);
    }

    public EntidadUsuarios getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(EntidadUsuarios usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }

    public EntidadUsuarios getUsuariosByIdCuidador() {
        return usuariosByIdCuidador;
    }

    public void setUsuariosByIdCuidador(EntidadUsuarios usuariosByIdCuidador) {
        this.usuariosByIdCuidador = usuariosByIdCuidador;
    }
}
