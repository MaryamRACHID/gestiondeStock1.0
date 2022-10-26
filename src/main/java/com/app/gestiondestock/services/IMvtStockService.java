/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.CategoryDto;
import com.app.gestiondestock.dto.MvtStockDto;

import java.util.List;

public interface IMvtStockService {

    MvtStockDto save(MvtStockDto mvtStockDto);

    MvtStockDto findById(Integer id);

    MvtStockDto findMvtStockByCode(String code);

    List<MvtStockDto> findAll();

    void delete(Integer id);
}
