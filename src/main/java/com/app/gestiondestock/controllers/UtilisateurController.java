/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.controllers;

import com.app.gestiondestock.controllers.api.ArticleAPI;
import com.app.gestiondestock.controllers.api.UtilisateurAPI;
import com.app.gestiondestock.dto.ArticleDto;
import com.app.gestiondestock.dto.UtilisateurDto;
import com.app.gestiondestock.services.IArticleService;
import com.app.gestiondestock.services.IUtlisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UtilisateurController implements UtilisateurAPI {

    private IUtlisateurService utlisateurService;

    @Autowired
    public UtilisateurController(IUtlisateurService utlisateurService){
        this.utlisateurService = utlisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return utlisateurService.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utlisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findUtilisateurBymail(String mail) {return utlisateurService.findUtilisateurBymail(mail);}


    public UtilisateurDto findUtilisateurBytele(String tele) {return utlisateurService.findUtilisateurBytele(tele);}

    @Override
    public List<UtilisateurDto> findAll() {
        return utlisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utlisateurService.delete(id);
    }
}
