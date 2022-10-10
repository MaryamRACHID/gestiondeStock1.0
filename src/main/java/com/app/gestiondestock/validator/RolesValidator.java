/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDto rolesDto){

        List<String> errors = new ArrayList<>();

        if(rolesDto == null){
            errors.add("Veuillez saisir nommer ce role");
            errors.add("Erreur liée à l'utilisateur");

            return  errors;
        }
        if (!StringUtils.hasLength(rolesDto.getRoleName())){
            errors.add("Veuillez saisir nommer ce role");
        }
        if (rolesDto.getUtilisateur() == null){
            errors.add("Erreur liée à l'utilisateur");
        }
        return errors;
    }
}
