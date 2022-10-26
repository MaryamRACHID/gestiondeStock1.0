/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.UtilisateurDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.Utilisateur;
import com.app.gestiondestock.repositories.UtilisateurRepository;
import com.app.gestiondestock.services.IUtlisateurService;
import com.app.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtlisateurServiceImpl implements IUtlisateurService {


    UtilisateurRepository utilisateurRepository;

    @Autowired
    UtlisateurServiceImpl(UtilisateurRepository utilisateurRepository){ this.utilisateurRepository = utilisateurRepository;}


    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty()){
            log.error("L'utilisateur est null");
            throw new InvalidEntityException("L'utilisateur' est null", ErrorCodes.UTILISATEUR_NOT_VALID);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto)));

    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if( id == null){
            log.error("L'Id n'existe pas !");
            return null;
        }

        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'utilisateur ayant l'ID : "+id+" n'existe pas !",ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto findUtilisateurBymail(String mail) {
        if(!StringUtils.hasLength(mail)){
            log.error("Ce mail : "+mail+" n'existe pas !");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByMail(mail);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'utilisateur ayant l'email : "+mail+" n'existe pas !",ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public UtilisateurDto findUtilisateurBytele(String tele) {
        if(!StringUtils.hasLength(tele)){
            log.error("Ce numéro de télèphone : "+tele+" n'existe pas !");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurBytele(tele);
        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'utilisateur ayant le numéro de télèphone : "+tele+" n'existe pas !",ErrorCodes.UTILISATEUR_NOT_FOUND));    }

    @Override
    public void delete(Integer id) {
        if( id == null){
            log.error("L'ID n'existe pas !");
        }
        utilisateurRepository.deleteById(id);
    }
}
