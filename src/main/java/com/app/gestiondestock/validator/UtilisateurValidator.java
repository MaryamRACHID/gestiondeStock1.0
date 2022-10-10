/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto){

        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur'");
            errors.add("Veuillez renseigner le prenom de l'utilisateur'");
            errors.add("Veuillez renseigner l'email de l'utilisateur'");
            errors.add("Veuillez renseigner un mot de passe pour l'utilisateur'");
            errors.add("Veuillez renseigner l'adresse de l'utilisateur'");
            return errors;
        }
        //org.springframework.util.StringUtils
        if (!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur'");
        }

        if (!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de l'utilisateur'");
        }

        if (!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner un email pour l'utilisateur'");
        }

        if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuillez renseigner un mot de passe pour l'utilisateur'");
        }

        if(utilisateurDto.getDateDeNaissance() == null){
            errors.add("Veuillez renseigner une date de naissance pour l'utilisateur'");
        }

        if (utilisateurDto.getAdresse() == null){
            errors.add("Veuillez renseigner l'adresse de l'utilisateur'");
        }
        else {
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("Le champs 'Adresse principale' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostal())){
                errors.add("Le champs 'Code postal' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("Le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("Le champs 'Pays' est obligatoire");
            }
        }

        return errors;

    }
}
