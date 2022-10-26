/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.EntrepriseDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.Entreprise;
import com.app.gestiondestock.repositories.EntrepriseRepository;
import com.app.gestiondestock.services.IEntrepriseService;
import com.app.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements IEntrepriseService {

    EntrepriseRepository entrepriseRepository;

    @Autowired
    EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("L'entreprise est nulle !", entrepriseDto);
            throw new InvalidEntityException("L'entreprise est nulle !", ErrorCodes.ENTREPRISE_NOT_VALID);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if( id == null){
            log.error("L'ID n'existe pas !");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'entreprise ayant l'ID : "+id+" n'existe pas !",ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String nom) {
        if(!StringUtils.hasLength(nom)){
            log.error("Le nom n'existe pas !");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByNom(nom);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'entreprise ayant le nom: "+nom+" n'existe pas !",ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseByMail(String mail) {
        if(!StringUtils.hasLength((mail))){
            log.error("ce mail n'existe pas !");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByMail(mail);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'entreprise ayant l'email: "+mail+" n'existe pas !",ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseBytele(String tele) {
        if(!StringUtils.hasLength(tele)){
            log.error("Ce numéro téléphone n'existe pas !");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByMail(tele);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'entreprise ayant l'email: "+tele+" n'existe pas !",ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public EntrepriseDto findEntrepriseBycodeFiscal(String codeFiscal) {
        if(!StringUtils.hasLength(codeFiscal )){
            log.error("Ce codeFiscal n'existe pas !");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByMail(codeFiscal);
        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() -> new EntityNotFoundException
                ("L'entreprise ayant l'email: "+codeFiscal+" n'existe pas !",ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("L'ID n'existe pas !");
        }
        entrepriseRepository.deleteById(id);
    }


}
