/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers.api;

import com.app.gestiondestock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.gestiondestock.utils.Constants.APP_ROOT;

public interface ClientAPI {

    @PostMapping(value = APP_ROOT + "/client/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);

    @GetMapping(value = APP_ROOT + "/client/{idclient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/client/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findClientBymail(@PathVariable("mail") String codeArticle);

    @GetMapping(value = APP_ROOT + "/article/{tele}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findClientBytele(@PathVariable("tele") String codeArticle);

    @GetMapping(value = APP_ROOT + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/client/delete/{idclient}")
    void delete(@PathVariable("idclient") Integer id);


}
