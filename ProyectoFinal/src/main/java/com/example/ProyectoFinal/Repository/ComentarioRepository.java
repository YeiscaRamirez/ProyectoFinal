package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}