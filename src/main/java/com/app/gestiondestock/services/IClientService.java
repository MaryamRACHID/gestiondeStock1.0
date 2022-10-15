/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.ClientDto;
import java.util.List;

public interface IClientService {

    ClientDto save(ClientDto clientDto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    ClientDto findClientBymail(String mail);

    ClientDto findClientBytele(String tele);

    void delete(Integer id);

}
