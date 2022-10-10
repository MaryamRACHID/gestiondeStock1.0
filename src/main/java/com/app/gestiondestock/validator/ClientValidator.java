/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto){

        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("Veuillez rensigner le nom du client");
            errors.add("Veuillez rensigner le prenom du client");
            errors.add("Veuillez rensigner l'email du client");
            errors.add("Veuillez rensigner le numéro de telephone du client");
            return errors;
        }

        if(StringUtils.hasLength(clientDto.getNom())){
            errors.add("Veuillez rensigner le nom du client");
        }

        if(StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Veuillez rensigner le prenom du client");
        }

        if(StringUtils.hasLength(clientDto.getMail())){
            errors.add("Veuillez rensigner l'email du client");
        }

        if(StringUtils.hasLength(clientDto.getTele())){
            errors.add("Veuillez rensigner le numéro de telephone du client");
        }

        return errors;
    }

}
