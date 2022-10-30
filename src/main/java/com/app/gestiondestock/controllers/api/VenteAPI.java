/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers.api;

import com.app.gestiondestock.dto.VenteDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.gestiondestock.utils.Constants.APP_ROOT;

public interface VenteAPI {

    @PostMapping(value = APP_ROOT + "/vente/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto save(@RequestBody VenteDto venteDto);

    @GetMapping(value = APP_ROOT + "/vente/{idVente}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findById(@PathVariable("idVente") Integer id);

    @GetMapping(value = APP_ROOT + "/vente/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    VenteDto findByCode(@PathVariable("code") String code);

    @GetMapping(value = APP_ROOT + "/vente/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<VenteDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/vente/delete/{idVente}")
    void delete(@PathVariable("idVente") Integer id);
}
