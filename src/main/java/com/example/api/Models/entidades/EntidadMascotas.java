package com.example.api.Models.entidades;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "mascotas", schema = "baseanimal")
public class EntidadMascotas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic
    @Column(name = "raza", nullable = true, length = 100)
    private String raza;
    @Basic
    @Column(name = "peso", nullable = true, precision = 2)
    private BigDecimal peso;
    @Basic
    @Column(name = "edad", nullable = true)
    private Integer edad;
    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)
    private String descripcion;
    @Column(name = "id_usuario", insertable = false, updatable = false)
    private int idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private EntidadUsuarios usuariosByIdUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadMascotas that = (EntidadMascotas) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(raza, that.raza) && Objects.equals(peso, that.peso) && Objects.equals(edad, that.edad) && Objects.equals(descripcion, that.descripcion) && Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, raza, peso, edad, descripcion, idUsuario);
    }

    public EntidadUsuarios getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(EntidadUsuarios usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }
}
