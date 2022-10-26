/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.CommandeClientDto;
import com.app.gestiondestock.dto.LigneCommandeClientDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.Article;
import com.app.gestiondestock.model.Client;
import com.app.gestiondestock.model.CommandeClient;
import com.app.gestiondestock.model.LigneCommandeClient;
import com.app.gestiondestock.repositories.ArticleRepository;
import com.app.gestiondestock.repositories.ClientRepository;
import com.app.gestiondestock.repositories.CommandeClientRepository;
import com.app.gestiondestock.repositories.LigneCommandeClientRepository;
import com.app.gestiondestock.services.ICommandeClientService;
import com.app.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements ICommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository,
                                     ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository){
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }


    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {

        List<String> errors = CommandeClientValidator.validate(commandeClientDto);

        if(!errors.isEmpty()){
            log.error("Commande n'est pas valide!");
            throw new InvalidEntityException("Commande n'est pas valide!", ErrorCodes.COMMAND_CLIENT_NOT_VALID, errors);
        }

        Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId());
        if ((!client.isPresent())){
            log.warn("Client not found. ID : ", commandeClientDto.getClient().getId());
            throw new EntityNotFoundException("Client not found; ID : "+commandeClientDto.getClient().getId(), ErrorCodes.CLIENT_NOT_FOUND);

        }

        List<String> articleErrors = new ArrayList<>();

        if(commandeClientDto.getLigneCommandeClient() != null){
            commandeClientDto.getLigneCommandeClient().forEach(ligne -> {
                if(ligne.getArticle() != null){
                    Optional<Article> article = articleRepository.findById(ligne.getArticle().getId());
                    if(article.isEmpty()){
                        articleErrors.add(("L'article n'est pas trouvé; ID : "+ligne.getArticle().getId()));
                    }
                } else{
                    articleErrors.add("Impossi d'enregistrer une commande avec un article null");
                }
            });
        }

        if(!articleErrors.isEmpty()){
            log.warn(("Operation non effectuée"));
            throw new InvalidEntityException("Article non trouvé sur la BDD",ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        CommandeClient savedCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));

        if(commandeClientDto.getLigneCommandeClient() != null){
            commandeClientDto.getLigneCommandeClient().forEach(ligne -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligne);
                ligneCommandeClient.setCommandeClient(savedCmdClt);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(savedCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if( id == null){
            log.error("Commande client ID is null");
            return null;
        }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouvé. ID : "+id,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if( code == null){
            log.error("Commande client ID is null");
            return null;
        }
        return commandeClientRepository.findByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouvé. Code : "+code,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if( id == null){
            log.error("Commande client ID is null");
        }
        commandeClientRepository.deleteById(id);
    }
}
