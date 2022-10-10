/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto commandeClientDto){

        List<String> errors = new ArrayList<>();
        if(commandeClientDto == null){
            errors.add("Erreur dans le Code de la commande");
            errors.add("Erreur liée au client");
            errors.add("Aucune ligne de commande !");

            return errors;
        }
        if (!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("Erreur dans le Code de la commande");
        }
        if (commandeClientDto.getClient() == null){
            errors.add("Erreur liée au client");
        }
        if (commandeClientDto.getLigneCommandeClient() == null){
            errors.add("Aucune ligne de commande !");
        }
        return errors;
    }

}
