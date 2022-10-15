/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers.api;

import com.app.gestiondestock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.app.gestiondestock.utils.Constants.APP_ROOT;


public interface FournisseurAPI {

    @PostMapping(value = APP_ROOT + "/fournisseur/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);

    @GetMapping(value = APP_ROOT + "/fournisseur/{idfournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idfournisseur") Integer id);

    @GetMapping(value = APP_ROOT + "/fournisseur/{mail}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findFournisseurBymail(@PathVariable("mail") String codeArticle);

    @GetMapping(value = APP_ROOT + "/fournisseur/{tele}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findFournisseurBytele(@PathVariable("tele") String codeArticle);

    @GetMapping(value = APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/fournisseur/delete/{idfournisseur}")
    void delete(@PathVariable("idfournisseur") Integer id);


}
