/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.LigneVenteDto;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto ligneVenteDto){

        List<String> errors = new ArrayList<>();
        if(ligneVenteDto == null){
            errors.add("Erreur liée à la vente");
            errors.add("Erreur dans la quantité");
            errors.add("Erreur liée au prix unitaire !");

            return errors;
        }
        if (ligneVenteDto.getQuantite() == null){
            errors.add("Erreur dans la quantité");
        }

        if (ligneVenteDto.getVente() == null){
            errors.add("Erreur liée à la vente");
        }
        if (ligneVenteDto.getPrixUnitaire() == null){
            errors.add("Erreur liée au prix unitaire !");
        }
        return errors;
    }

}
