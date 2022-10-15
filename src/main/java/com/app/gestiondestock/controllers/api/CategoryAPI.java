/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers.api;

import com.app.gestiondestock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.gestiondestock.utils.Constants.APP_ROOT;

public interface CategoryAPI {


    @PostMapping(value = APP_ROOT + "/category/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto categoryDto);

    @GetMapping(value = APP_ROOT + "/category/{idcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idcategory") Integer id);

    @GetMapping(value = APP_ROOT + "/category/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findCategoryByCode(@PathVariable("code") String codeArticle);

    @GetMapping(value = APP_ROOT + "/category/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/category/delete/{idcategory}")
    void delete(@PathVariable("idcategory") Integer id);
}
