/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.validator;

import com.app.gestiondestock.dto.MvtStockDto;

import java.util.ArrayList;
import java.util.List;

public class MvtStockValidator {

    public  static List<String> validate(MvtStockDto mvtStockDto){
        List<String> errors = new ArrayList<>();

        if(mvtStockDto == null){
            return errors;
        }
        if(mvtStockDto.getArticle() == null){
            errors.add("Erreur liée à l'article");
        }
        if (mvtStockDto.getQuantite() == null){
            errors.add("Erreur dans la quantité");
        }
        if (mvtStockDto.getTypeMvt() == null){
            errors.add("Erreur liée au type de mouvment");
        }

        return errors;
    }
}
