/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.dto;
import com.app.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class CategoryDto {

    private Integer id;

    private String code;

    private String destination;

    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category){

        if(category == null) {
            return null;
            //TODO throw on exception || erreur metier
        }
        // Mapping de  Category vers CategoryDto
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .destination(category.getDestination())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {

        if(categoryDto == null){
            return null;
            //Throw Exception
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDestination(categoryDto.getDestination());

        return category;
    }


}
