/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers;

import com.app.gestiondestock.controllers.api.FournisseurAPI;
import com.app.gestiondestock.dto.FournisseurDto;
import com.app.gestiondestock.services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class FournisseurController implements FournisseurAPI {

    private IFournisseurService fournisseurService;

    @Autowired
    public FournisseurController(IFournisseurService fournisseurService){
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public FournisseurDto findFournisseurBymail(String mail) {return fournisseurService.findFournisseurBymail(mail);}

    @Override
    public FournisseurDto findFournisseurBytele(String tele) {return fournisseurService.findFournisseurBytele(tele);}

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
