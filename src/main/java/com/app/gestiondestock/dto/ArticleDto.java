/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.dto;

import com.app.gestiondestock.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDto categorie;

    private Integer idEntreprise;

    @JsonIgnore
    private List<LigneVente> ligneVentes;

    @JsonIgnore
    private List<LigneCommandeClient> ligneCommandeClients;

    @JsonIgnore
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @JsonIgnore
    private List<MvtStock> mvtStocks;


    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
            //TODO
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .categorie(CategoryDto.fromEntity(article.getCategory()))
                .idEntreprise(article.getIdEntreprise())
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if (articleDto == null){
            //TODO
            return null;
        }
        Article article = new Article();
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategorie()));
        article.setIdEntreprise(articleDto.getIdEntreprise());

        return article;
    }

}
