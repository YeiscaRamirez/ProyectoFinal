package com.example.ProyectoFinal.Services;

import com.example.ProyectoFinal.Entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public Iterable<Post> findAll();

    public Page<Post> findAll(Pageable pageable);

    public Optional<Post> findById(Long id);

    public Post save(Post post);

    public void deleteById(Long id);

   public List<Post> findByTitulo(String titulo);

    //public List<Post> findNotPublicado(Boolean publicado);
}