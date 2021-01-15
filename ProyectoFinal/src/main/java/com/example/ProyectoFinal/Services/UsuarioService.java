package com.example.ProyectoFinal.Services;

import com.example.ProyectoFinal.Entity.Usuario;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface UsuarioService {

     public Iterable<Usuario> findAll();

     public Page<Usuario> findAll(Pageable pageable);

     public Optional<Usuario> findById(Long id) ;

     public Usuario save(Usuario usuario);

     public void deleteById(Long id) ;
     
     List<Usuario> findByCiudad(String ciudad);
     
     List<Usuario> findByDate(LocalDate date);

}