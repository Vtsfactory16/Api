package com.example.api.Models.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "resenas", schema = "baseanimal")
public class EntidadResenas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "id_cuidador")
    private Integer idCuidador;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "comentario", length = 255)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private EntidadUsuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_cuidador", referencedColumnName = "id", insertable = false, updatable = false)
    private EntidadUsuarios cuidador;

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
    public EntidadUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(EntidadUsuarios usuario) {
        this.usuario = usuario;
    }

    public EntidadUsuarios getCuidador() {
        return cuidador;
    }

    public void setCuidador(EntidadUsuarios cuidador) {
        this.cuidador = cuidador;
    }

}
