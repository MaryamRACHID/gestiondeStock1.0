/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers.api;
import com.app.gestiondestock.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.app.gestiondestock.utils.Constants.APP_ROOT;

public interface EntrepriseAPI {

    @PostMapping(value = APP_ROOT + "/entreprise/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);

    @GetMapping(value = APP_ROOT + "/entreprise/{identreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("identreprise") Integer id);

    @GetMapping(value = APP_ROOT + "/entreprise/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseByNom(@PathVariable("nom") String codeArticle);

    @GetMapping(value = APP_ROOT + "/entreprise/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseBymail(@PathVariable("mail") String codeArticle);

    @GetMapping(value = APP_ROOT + "/entreprise/{tele}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseBytele(@PathVariable("tele") String codeArticle);

    @GetMapping(value = APP_ROOT + "/client/{codeFiscal}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findEntrepriseBycodeFiscal(@PathVariable("codeFiscal") String codeArticle);

    @GetMapping(value = APP_ROOT + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/client/delete/{idclient}")
    void delete(@PathVariable("idclient") Integer id);

}
