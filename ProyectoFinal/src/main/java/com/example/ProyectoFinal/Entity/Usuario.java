package com.example.ProyectoFinal.Entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Usuario")


public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column(length = 50)
    private String nombre;

    @Column(length =50)
    private String apellido;

   @Column(nullable=false, length = 50, unique = true)
    private String email;

    @Column(nullable=false, length = 8)
    private String password;

    @Column(name = "FechaCreacion")
    @Basic
    private LocalDate date= LocalDate.now();

    @Column(nullable=false, length = 60)
    private String ciudad;

   @Column(nullable=false, length = 60)
    private String provincia;

    @Column(nullable=false, length = 20)
    private String pais;
 
  public Usuario(String nombre, String apellido,String email, String encode, String ciudad, String provincia, String pais) {
     this.nombre = nombre;
     this.apellido = apellido;
     this.email = email;
     this.password=encode;
     this.date = date;
     this.ciudad = ciudad;
     this.provincia = provincia;
     this.pais = pais;
    }

  @OneToMany
  private List<Post> post = new ArrayList<>();
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

   public LocalDate getFechaCreacion() {
     return date ;
    }

  public void setFechaCreacion(LocalDate date) {
     this.date = date;
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
public void addPost(Post post){
    this.post.add(post);
    Post.setAutor(this);
}
}