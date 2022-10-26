/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.FournisseurDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.Fournisseur;
import com.app.gestiondestock.repositories.FournisseurRepository;
import com.app.gestiondestock.services.IFournisseurService;
import com.app.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {

    FournisseurRepository fournisseurRepository;

    @Autowired
    FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if (!errors.isEmpty()){
            log.error("Fournisseur n'est pas valide", fournisseurDto);
            throw new InvalidEntityException("Fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID,errors);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {

        if (id == null){
            log.error("L'ID n'existe pas");
            return null;
        }
        return Optional.of(FournisseurDto.fromEntity(fournisseurRepository.findById(id).get())).orElseThrow(() -> new EntityNotFoundException
                ("Le fournisseur ayant ID : "+id+" n'existe pas", ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public FournisseurDto findFournisseurBymail(String mail) {
        if(!StringUtils.hasLength(mail)){
            log.error("Le CODE est null");
            return null;
        }
        return Optional.of(FournisseurDto.fromEntity(fournisseurRepository.findFournisseurByMail(mail).get())).orElseThrow(
                () -> new EntityNotFoundException("", ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public FournisseurDto findFournisseurBytele(String tele) {
        if(!StringUtils.hasLength(tele)){
            log.error("Le CODE est null");
            return null;
        }
        return Optional.of(FournisseurDto.fromEntity(fournisseurRepository.findFournisseurByMail(tele).get())).orElseThrow(
                () -> new EntityNotFoundException("", ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public void delete(Integer id) {
        if( id == null){
            log.error("L'ID n'existe pas !");
        }
        fournisseurRepository.deleteById(id);
    }
}
