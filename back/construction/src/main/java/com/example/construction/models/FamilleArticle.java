package com.example.construction.models;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable(false)
public class FamilleArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String description;
    private int status = 0;

    
    @OneToMany(mappedBy = "familleArticle", cascade = CascadeType.ALL)
    private List<TypeArticle> typeArticles;



    // Ajoutez cette méthode pour retirer un TypeArticle de la liste
    public void removeArticleType(TypeArticle articleType) {
        this.typeArticles.remove(articleType);
        articleType.setFamilleArticle(null); // Assurez-vous de maintenir la cohérence des deux côtés de la relation
    }

    // Méthode pour la suppression logique
    public void softDelete() {
        this.status = 1;
    }

    // Méthode pour ajouter un TypeArticle à la liste
    public void addTypeArticle(TypeArticle typeArticle) {
        typeArticles.add(typeArticle);
        typeArticle.setFamilleArticle(this); // Maintenir la relation bidirectionnelle
    }

}
