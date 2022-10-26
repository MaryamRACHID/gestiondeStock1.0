/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.CommandeFournisseurDto;
import com.app.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.*;
import com.app.gestiondestock.repositories.ArticleRepository;
import com.app.gestiondestock.repositories.FournisseurRepository;
import com.app.gestiondestock.repositories.CommandeFournisseurRepository;
import com.app.gestiondestock.repositories.LigneCommandeFournisseurRepository;
import com.app.gestiondestock.services.ICommandeFournisseurService;
import com.app.gestiondestock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements ICommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;


    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, FournisseurRepository fournisseurRepository,
                                     ArticleRepository articleRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository){
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
    }


    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {

        List<String> errors = CommandeFournisseurValidator.validate(commandeFournisseurDto);

        if(!errors.isEmpty()){
            log.error("Commande n'est pas valide!");
            throw new InvalidEntityException("Commande n'est pas valide!", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());
        if ((!fournisseur.isPresent())){
            log.warn("Fournisseur not found. ID : ", commandeFournisseurDto.getFournisseur().getId());
            throw new EntityNotFoundException("Fournisseur not found; ID : "+commandeFournisseurDto.getFournisseur().getId(), ErrorCodes.FOURNISSEUR_NOT_FOUND);

        }

        List<String> articleErrors = new ArrayList<>();

        if(commandeFournisseurDto.getLignesCommandeFournisseur() != null){
            commandeFournisseurDto.getLignesCommandeFournisseur().forEach(ligne -> {
                if(ligne.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ligne.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add(("L'article n'est pas trouvé; ID : "+ligne.getArticle().getId()));
                    }
                } else{
                    articleErrors.add("Impossible d'enregistrer une commande avec un article null");
                }
            });
        }

        if(!articleErrors.isEmpty()){
            log.warn(("Operation non effectuée"));
            throw new InvalidEntityException("Article non trouvé sur la BDD",ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        CommandeFournisseur savedCmdF = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));

        if(commandeFournisseurDto.getLignesCommandeFournisseur() != null){
            commandeFournisseurDto.getLignesCommandeFournisseur().forEach(ligne -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligne);
                ligneCommandeFournisseur.setCommandeFournisseur(savedCmdF);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }

        return CommandeFournisseurDto.fromEntity(savedCmdF);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if( id == null){
            log.error("Commande Fournisseur ID is null");
            return null;
        }
        return commandeFournisseurRepository.findById(id)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande Fournisseur n'a ete trouvé. ID : "+id,ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if( code == null){
            log.error("Commande Fournisseur ID is null");
            return null;
        }
        return commandeFournisseurRepository.findByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande Fournisseur n'a ete trouvé. Code : "+code,ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if( id == null){
            log.error("Commande Fournisseur ID is null");
        }
        commandeFournisseurRepository.deleteById(id);
    }
}
