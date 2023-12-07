package com.example.construction.services;

import com.example.construction.models.FamilleArticle;
import com.example.construction.models.TypeArticle;
import com.example.construction.repositories.FamilleArticleRepository;
import com.example.construction.repositories.TypeArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TypeArticleRepository typeArticleRepository;
    private final FamilleArticleRepository familleArticleRepository;


    public TypeArticle addTypeArticleToFamily(TypeArticle typeArticle) {
        try{
            return typeArticleRepository.save(typeArticle);
        }catch(Exception e){
            throw e;
        }
    }

    public FamilleArticle getFamilleById(Long id) {
        return familleArticleRepository.findById(id).orElse(null);
    }
}
