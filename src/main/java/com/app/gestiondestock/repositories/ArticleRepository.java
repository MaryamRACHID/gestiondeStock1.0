/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.repositories;

import com.app.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    /*
    //Requete JPQL
    @Query("SELECT a from article where codearticle = :code and designation = :designation")
    List<Article> findbyCostumQuery(@Param("code") String c, @Param("designation") String d);

    //Requete Native
    @Query(value = "SELECT * from article where codearticle = :code", nativeQuery = true)
    List<Article> findbyCostumQuery(@Param("code") String c, @Param("designation") String d);
    */

    //ignorer les miniscules et magiscules == IgnoreCase
    List<Article> findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle, String designation);


    Optional<Article> findArticleByCodeArticle(String CodeArticle);

}
