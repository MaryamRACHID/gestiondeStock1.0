/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){

        List<String> errors = new ArrayList<>();
        if(ligneCommandeFournisseurDto == null){
            errors.add("Erreur liée à la commande");
            errors.add("Erreur liée à l'article");
            errors.add("Erreur dans la quantité de la commande");
            errors.add("Erreur liée au prix unitaire !");

            return errors;
        }
        if (ligneCommandeFournisseurDto.getQuantite() == null){
            errors.add("Erreur dans la quantité de la commande");
        }
        if (ligneCommandeFournisseurDto.getArticle() == null){
            errors.add("Erreur liée à l'article");
        }
        if (ligneCommandeFournisseurDto.getCommandeFournisseur() == null){
            errors.add("Erreur liée à la commande");
        }
        if (ligneCommandeFournisseurDto.getPrixUnitaire() == null){
            errors.add("Erreur liée au prix unitaire !");
        }
        return errors;
    }

}
