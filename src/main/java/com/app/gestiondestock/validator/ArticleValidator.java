/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> Validate(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();

        if(articleDto == null){
            errors.add("Veuillez renseigner le code de l'article'");
            errors.add("Veuillez renseigner la designation de l'article'");
            errors.add("Veuillez renseigner le prix unitaire HT de l'article'");
            errors.add("Veuillez renseigner le taux TVA de l'article'");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article'");
            errors.add("Veuillez selectionner une categorie'");
            return errors;

        }

        //org.springframework.util.StringUtils
        if (!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("Veuillez renseigner le code de l'article'");
        }

        if (!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("Veuillez renseigner la designation de l'article'");
        }

        if (articleDto.getPrixUnitaireHt() == null){
            errors.add("Veuillez renseigner le prix unitaire HT de l'article'");
        }

        if (articleDto.getTauxTva() == null){
            errors.add("Veuillez renseigner le taux TVA de l'article'");
        }

        if (articleDto.getPrixUnitaireTtc() == null){
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article'");
        }

        if (articleDto.getCategorie() == null){
            errors.add("Veuillez selectionner une categorie");
        }

        return errors;
    }

}
