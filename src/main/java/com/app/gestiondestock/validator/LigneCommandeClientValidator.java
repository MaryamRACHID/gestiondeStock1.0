/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){

        List<String> errors = new ArrayList<>();
        if(ligneCommandeClientDto == null){
            errors.add("Erreur liée à la commande");
            errors.add("Erreur liée à l'article");
            errors.add("Erreur dans la quantité de la commande");
            errors.add("Erreur liée au prix unitaire !");

            return errors;
        }
        if (ligneCommandeClientDto.getQuantite() == null){
            errors.add("Erreur dans la quantité de la commande");
        }
        if (ligneCommandeClientDto.getArticle() == null){
            errors.add("Erreur liée à l'article");
        }
        if (ligneCommandeClientDto.getCommandeClient() == null){
            errors.add("Erreur liée à la commande");
        }
        if (ligneCommandeClientDto.getPrixUnitaire() == null){
            errors.add("Erreur liée au prix unitaire !");
        }
        return errors;
    }

}
