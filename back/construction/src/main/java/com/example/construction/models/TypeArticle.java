package com.example.construction.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private String description;
    private int status = 0;

    //Méthode pour la suppression logique
    public void softDelete() {
        this.status = 1;
    }
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "famille_id", referencedColumnName = "id")
    private FamilleArticle familleArticle;



}
