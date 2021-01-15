package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Usuario;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);

    Boolean existsByNombre(String nombre);

    Boolean existsByEmail(String email);

    Optional<Usuario> findByIdUser(Long id);

    public List<Usuario> findByDate(LocalDate date);

    public List<Usuario> findByCiudad(String ciudad);

}
