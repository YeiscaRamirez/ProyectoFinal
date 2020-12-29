package com.example.ProyectoFinal.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Post implements Serializable {

    /**
     *
     * @param aThis
     */
    static void setAutor(Usuario aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String titulo;
    private String descripcion;
    private String contenido;
    private Boolean publicado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor", referencedColumnName = "id")
    private Usuario autor;

    private LocalDate fecha = LocalDate.now() ;

    public Long getId() {
        return id; }

    public void setId(Long id) {
        this.id = id; }

    public String getTitulo() {
        return titulo; }

    public void setTitulo(String titulo) {
        this.titulo = titulo; }

    public String getDescripcion() {
        return descripcion; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; }

    public String getContenido() {
        return contenido; }

    public void setContenido(String contenido) {
        this.contenido = contenido; }

    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado; }

    public Usuario getAutor() {
        return autor; }


    public LocalDate getFecha() {
        return fecha; }

    public void setFecha( LocalDate fecha) {
        this.fecha = fecha; }
}

