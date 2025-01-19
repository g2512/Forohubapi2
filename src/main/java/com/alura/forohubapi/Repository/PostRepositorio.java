package com.alura.forohubapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.forohubapi.Entity.Post;


public interface PostRepositorio extends  JpaRepository<Post, Long>{
}
