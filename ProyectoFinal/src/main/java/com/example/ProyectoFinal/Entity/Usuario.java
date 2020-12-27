package com.example.ProyectoFinal.Entity;

import java.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.validation.constraints.Email;
import java.validation.constraints.NotBlank;
import java.validation.constraints.Size;
@Entity
@Table(name ="Usuario",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotBlank
    @Size(max = 20)
    private String nombre;

    @NotBlank
    @Size(max = 20)
    private String apellido;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    public Usuario() {
    }

    @NotBlank
    @Size(max = 120)
    private String password;

    @Column(name = "FechaCreacion")
    @Basic
    private java.sql.Date FechaCreacion;

    @NotBlank
    @Size(max = 20)
    private String ciudad;

    @NotBlank
    @Size(max = 20)
    private String provincia;

    @NotBlank
    @Size(max = 20)
    private String pais;


   
   
  public Usuario(String nombre, String apellido,String email, String encode, String fecha, String ciudad, String provincia, String pais) {
     this.nombre = nombre;
     this.apellido = apellido;
     this.email = email;
     this.password=encode;
     this.FechaCreacion = fecha;
     this.ciudad = ciudad;
     this.provincia = provincia;
     this.pais = pais;
    }

  public Long getUsuario_id() {
     return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
     this.usuario_id = usuario_id;
     }

  public String getNombre() {
     return nombre;
    } 

  public void setNombre(String nombre) {
     this.nombre = nombre;
    }

  public String getApellido() {
     return apellido;
    }

  public void setApellido(String apellido) {
     this.apellido = apellido;
    }

   public String getEmail() {
     return email;
   }

   public void setEmail(String email) {
     this.email = email;
   }

   public String getPassword() {
     return password;
    }
       
  public void setPassword(String password) {
     this.password = password;
    }

   public String getFechaCreacion() {
     return fecha;
    }

  public void setFechaCreacion(String FechaCreacion) {
     this.FechaCreacion = FechaCreacion;
    }

   public String getCiudad() {
      return ciudad;
    }

  public void setCiudad(String ciudad) {
     this.ciudad = ciudad;
    }

   public String getProvincia() {
     return provincia;
    }

   public void setProvincia(String provincia) {
      this.provincia = provincia;
    }

  public String getPais() {
     return pais;
    }

  public void setPais(String pais) {
     this.pais = pais;
   }
}