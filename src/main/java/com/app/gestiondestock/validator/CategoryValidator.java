/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> Validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        //org.springframework.util.StringUtils
        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de la categorie");
        }
        return errors;
    }
}
