/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers;

import com.app.gestiondestock.controllers.api.ClientAPI;
import com.app.gestiondestock.dto.ClientDto;
import com.app.gestiondestock.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ClientController implements ClientAPI {

    private IClientService clientService;

    @Autowired
    public ClientController(IClientService clientService){
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto findClientBymail(String mail) {
        return clientService.findClientBymail(mail);
    }

    @Override
    public ClientDto findClientBytele(String tele) { return clientService.findClientBytele(tele);}

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
