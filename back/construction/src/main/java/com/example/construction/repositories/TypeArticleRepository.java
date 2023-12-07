package com.example.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.construction.models.TypeArticle;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeArticleRepository extends JpaRepository<TypeArticle , Long>{

    
}
