/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null){
            errors.add("Veuillez rensigner le nom de l'entreprise");
            errors.add("Veuillez rensigner le description de l'entreprise");
            errors.add("Veuillez rensigner le codeFiscal de l'entreprise");
            errors.add("Veuillez rensigner l'email de l'entreprise");
            errors.add("Veuillez rensigner le numéro de telephone de l'entreprise");
            errors.add("Veuillez rensigner une adresse pour l'entreprise");

            return errors;
        }

        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Veuillez rensigner le nom de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getDescription())){
            errors.add("Veuillez rensigner le description de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("Veuillez rensigner le codeFiscal de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("Veuillez rensigner l'email de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getTele())){
            errors.add("Veuillez rensigner le numéro de telephone de l'entreprise");
        }

        if(entrepriseDto.getAdresse() == null){
            errors.add("Veuillez rensigner une adresse pour l'entreprise");
        } else {
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse1())){
                errors.add("Le champs 'Adresse principale' est obligatoire");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getCodePostal())){
                errors.add("Le champs 'Code postal' est obligatoire");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getVille())){
                errors.add("Le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(entrepriseDto.getAdresse().getPays())){
                errors.add("Le champs 'Pays' est obligatoire");
            }
        }
        return errors;
    }
}
