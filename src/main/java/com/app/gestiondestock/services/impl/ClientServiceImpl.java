/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services.impl;

import com.app.gestiondestock.dto.ArticleDto;
import com.app.gestiondestock.dto.ClientDto;
import com.app.gestiondestock.exception.EntityNotFoundException;
import com.app.gestiondestock.exception.ErrorCodes;
import com.app.gestiondestock.exception.InvalidEntityException;
import com.app.gestiondestock.model.Client;
import com.app.gestiondestock.repositories.ClientRepository;
import com.app.gestiondestock.services.IArticleService;
import com.app.gestiondestock.services.IClientService;
import com.app.gestiondestock.validator.ArticleValidator;
import com.app.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService {

    ClientRepository clientRepository;

    @Autowired
    ClientServiceImpl(ClientRepository clientRepository){ this.clientRepository =  clientRepository;}


    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("Le client est null");
            throw new InvalidEntityException("Le client est null", ErrorCodes.CLIENT_NOT_VALID);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));

    }

    @Override
    public ClientDto findById(Integer id) {
        if( id == null){
            log.error("L'Id n'existe pas !");
            return null;
        }

        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() -> new EntityNotFoundException
                ("Le client ayant l'ID : "+id+" n'existe pas !",ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public ClientDto findClientBymail(String mail) {
        if(!StringUtils.hasLength(mail)){
            log.error("Ce mail : "+mail+" n'existe pas !");
            return null;
        }
        Optional<Client> client = clientRepository.findClientByMail(mail);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() -> new EntityNotFoundException
                ("Le client ayant l'email : "+mail+" n'existe pas !",ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public ClientDto findClientBytele(String tele) {
        if(!StringUtils.hasLength(tele)){
            log.error("Ce numéro de télèphone :  "+tele+" n'existe pas !");
            return null;
        }
        Optional<Client> client = clientRepository.findClientBytele(tele);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() -> new EntityNotFoundException
                ("Le client ayant le numéro de télèphone : "+tele+" n'existe pas !",ErrorCodes.CLIENT_NOT_FOUND));    }

    @Override
    public void delete(Integer id) {
        if( id == null){
            log.error("L'ID n'existe pas !");
        }
        clientRepository.deleteById(id);
    }

}
