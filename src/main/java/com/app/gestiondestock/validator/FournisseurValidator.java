/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto){

        List<String> errors = new ArrayList<>();

        if(fournisseurDto == null){
            errors.add("Veuillez rensigner le nom du fournisseur");
            errors.add("Veuillez rensigner le prenom du fournisseur");
            errors.add("Veuillez rensigner l'email du fournisseur");
            errors.add("Veuillez rensigner le numéro de telephone du fournisseur");
            return errors;
        }

        if(StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Veuillez rensigner le nom du fournisseur");
        }

        if(StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Veuillez rensigner le prenom du fournisseur");
        }

        if(StringUtils.hasLength(fournisseurDto.getMail())){
            errors.add("Veuillez rensigner l'email du fournisseur");
        }

        if(StringUtils.hasLength(fournisseurDto.getTele())){
            errors.add("Veuillez rensigner le numéro de telephone du fournisseur");
        }

        return errors;
    }


}
