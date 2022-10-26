/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.*;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.*;
import com.app.gestiondestock.repositories.*;
import com.app.gestiondestock.services.IVenteService;
import com.app.gestiondestock.validator.CommandeFournisseurValidator;
import com.app.gestiondestock.validator.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements IVenteService {

    private VenteRepository venteRepository;
    private ArticleRepository articleRepository;
    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VenteServiceImpl(VenteRepository venteRepository, ArticleRepository articleRepository, LigneVenteRepository ligneVenteRepository){
        this.venteRepository = venteRepository;
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VenteDto save(VenteDto venteDto) {

        List<String> errors = VenteValidator.validate(venteDto);

        if(!errors.isEmpty()){
            log.error("Vente n'est pas valide!");
            throw new InvalidEntityException("Vente n'est pas valide!", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        if(venteDto.getVenteList() != null){
            venteDto.getVenteList().forEach(ligne -> {
                if(ligne.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ligne.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add(("L'article n'est pas trouvé; ID : "+ligne.getArticle().getId()));
                    }
                } else{
                    articleErrors.add("Impossible d'enregistrer une Vente avec un article null");
                }
            });
        }

        if(!articleErrors.isEmpty()){
            log.warn(("Operation non effectuée"));
            throw new InvalidEntityException("Article non trouvé sur la BDD",ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        Vente savedVente = venteRepository.save(venteDto.toEntity(venteDto));

        if(venteDto.getVenteList() != null){
            venteDto.getVenteList().forEach( ligne -> {
                LigneVente ligneVente = LigneVenteDto.toEntity(ligne);
                ligneVente.setVente(savedVente);
                ligneVenteRepository.save(ligneVente);
            } );
        }

        return VenteDto.fromEntity(savedVente);    }

    @Override
    public VenteDto findById(Integer id) {
        if( id == null){
            log.error("Commande vente ID is null");
            return null;
        }
        return venteRepository.findById(id)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente Vente n'a ete trouvé. ID : "+id,ErrorCodes.VENTE_NOT_FOUND));

    }

    @Override
    public VenteDto findByCode(String code) {
        if( code == null){
            log.error("Commande vente code is null");
            return null;
        }
        return venteRepository.findByCode(code)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente n'a ete trouvé. ID : "+code,ErrorCodes.VENTE_NOT_FOUND));    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if( id == null){
            log.error("Vente ID is null");
        }
        venteRepository.deleteById(id);
    }
}
