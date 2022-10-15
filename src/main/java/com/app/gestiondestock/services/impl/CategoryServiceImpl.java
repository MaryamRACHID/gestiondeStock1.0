/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.ArticleDto;
import com.app.gestiondestock.dto.CategoryDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.Category;
import com.app.gestiondestock.repositories.CategoryRepository;
import com.app.gestiondestock.services.ICategoryService;
import com.app.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements ICategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){ this.categoryRepository = categoryRepository; }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.Validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("La categorie n'est pas valide", categoryDto);
            throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null){
            log.error("L'ID est null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() -> new EntityNotFoundException
                ("Aucune Categorie avec l'ID"+id+"n'a été trouvée", ErrorCodes.CATEGORY_NOT_FOUNT));
    }

    @Override
    public CategoryDto findCategoryByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Le code est null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoryByCode(code);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() -> new EntityNotFoundException
                ("Aucune Categorie avec l'ID"+code+"n'a été trouvée",ErrorCodes.CATEGORY_NOT_FOUNT));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Cet ID est null");
        }
        categoryRepository.deleteById(id);

    }
}
