/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers;

import com.app.gestiondestock.controllers.api.ArticleAPI;
import com.app.gestiondestock.controllers.api.CategoryAPI;
import com.app.gestiondestock.dto.ArticleDto;
import com.app.gestiondestock.dto.CategoryDto;
import com.app.gestiondestock.services.IArticleService;
import com.app.gestiondestock.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController implements CategoryAPI {

    private ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findCategoryByCode(String code) {
        return categoryService.findCategoryByCode(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
