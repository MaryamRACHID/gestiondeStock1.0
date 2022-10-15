/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers.api;

import com.app.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.app.gestiondestock.utils.Constants.APP_ROOT;

public interface UtilisateurAPI {

    @PostMapping(value = APP_ROOT + "/utilisateur/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value = APP_ROOT + "/utilisateur/{idutilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idutilisateur") Integer id);

    @GetMapping(value = APP_ROOT + "/utilisateur/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findUtilisateurBymail(@PathVariable("mail") String codeArticle);

    @GetMapping(value = APP_ROOT + "/utilisateur/{tele}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findUtilisateurBytele(@PathVariable("tele") String codeArticle);

    @GetMapping(value = APP_ROOT + "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/utilisateur/delete/{idutilisateur}")
    void delete(@PathVariable("idutilisateur") Integer id);


}
