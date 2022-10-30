/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers;

import com.app.gestiondestock.controllers.api.VenteAPI;
import com.app.gestiondestock.dto.VenteDto;
import com.app.gestiondestock.services.IVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class VenteController implements VenteAPI {

    private IVenteService venteService;

    @Autowired
    public VenteController(IVenteService venteService){
        this.venteService = venteService;
    }

    @Override
    public VenteDto save(VenteDto venteDto) {
        return venteService.save(venteDto);
    }

    @Override
    public VenteDto findById(Integer id) {
        return venteService.findById(id);
    }

    @Override
    public VenteDto findByCode(String code) {
        return venteService.findByCode(code);
    }

    @Override
    public List<VenteDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        venteService.delete(id);
    }
}
