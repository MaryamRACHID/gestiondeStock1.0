/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){

        List<String> errors = new ArrayList<>();
        if(commandeFournisseurDto == null){
            errors.add("Erreur dans le Code de la commande");
            errors.add("Erreur liée au fournisseur");
            errors.add("Aucune ligne de commande !");

            return errors;
        }
        if (!StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add("Erreur dans le Code de la commande");
        }
        if (commandeFournisseurDto.getFournisseur() == null){
            errors.add("Erreur liée au fournissuer");
        }
        if (commandeFournisseurDto.getLignesCommandeFournisseur() == null){
            errors.add("Aucune ligne de commande !");
        }
        return errors;
    }
}
