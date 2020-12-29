package com.example.ProyectoFinal.Entity;


import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String autor;
    @Column (length = 200)
    private String comentario;
    private LocalDate fecha = LocalDate.now();

    public Long getId() {
        return id; }

    public void setId(Long id) {
        this.id = id; }

    public String getAutor() {
        return autor; }

    public void setAutor(String autor) {
        this.autor = autor; }

    public String getComentario() {
        return comentario; }

    public void setComentario(String comentario) {
        this.comentario = comentario; }

    public LocalDate getFechaCreacion() {
        return fecha; }

    public void setFechaCreacion(LocalDate fecha) {
        this.fecha = fecha;
    }
}
