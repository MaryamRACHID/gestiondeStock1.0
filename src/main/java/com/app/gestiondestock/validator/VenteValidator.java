/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VenteDto venteDto){

        List<String> errors = new ArrayList<>();
        if (venteDto == null || !StringUtils.hasLength(venteDto.getCode())){
            errors.add("Veuillez saisir le code de la vente");
            return errors;
        }
        return errors;
    }
}
