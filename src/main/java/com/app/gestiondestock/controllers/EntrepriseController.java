/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers;

import com.app.gestiondestock.controllers.api.ArticleAPI;
import com.app.gestiondestock.controllers.api.EntrepriseAPI;
import com.app.gestiondestock.dto.ArticleDto;
import com.app.gestiondestock.dto.EntrepriseDto;
import com.app.gestiondestock.model.Entreprise;
import com.app.gestiondestock.services.IArticleService;
import com.app.gestiondestock.services.IEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EntrepriseController implements EntrepriseAPI {

    private IEntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(IEntrepriseService entrepriseService){
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDto findEntrepriseByNom(String nom) {return entrepriseService.findEntrepriseByNom(nom);}

    @Override
    public EntrepriseDto findEntrepriseBymail(String mail) {return entrepriseService.findEntrepriseByMail(mail);}

    @Override
    public EntrepriseDto findEntrepriseBytele(String tele) {return entrepriseService.findEntrepriseBytele(tele);}

    @Override
    public EntrepriseDto findEntrepriseBycodeFiscal(String codeFiscal) {return entrepriseService.findEntrepriseBycodeFiscal(codeFiscal);}

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
