package com.example.construction.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String designation;
    private String description;
    private Integer poids;
    private Integer prixAchatUnitaire;
    private Integer prixVenteUnitaire;
    private Integer prixReviensUnitaire;

    @ManyToOne
    @JoinColumn(name = "zoneStock", referencedColumnName = "id")
    private ZoneStock zoneStock;

    @ManyToOne
    @JoinColumn(name = "uniteMesure", referencedColumnName = "id")
    private UniteMesure uniteMesure;

    @ManyToOne
    @JoinColumn(name = "typeArticle", referencedColumnName = "id")
    private TypeArticle typeArticle;

    @ManyToOne
    @JoinColumn(name = "famille", referencedColumnName = "id")
    private FamilleArticle familleArticle;
}
