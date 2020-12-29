package com.example.ProyectoFinal.Services;

import com.example.ProyectoFinal.Entity.Post;
import com.example.ProyectoFinal.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {postRepository.deleteById(id);

    }
    
    @Transactional(readOnly = true)
    public List<Post> findByTitle(String titulo) {
        return postRepository.findByTitulo(titulo);
    }

    /*@Override
    @Transactional(readOnly = true)
    public List<Post> findNotPublished(Boolean published) {
        return postRepository.findNotPublished(published);
    }*/

    @Override
    public List<Post> findByTitulo(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}