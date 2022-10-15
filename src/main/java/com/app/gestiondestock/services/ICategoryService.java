/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.CategoryDto;
import java.util.List;

public interface ICategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findCategoryByCode(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
