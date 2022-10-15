/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.UtilisateurDto;
import java.util.List;


public interface IUtlisateurService {

    UtilisateurDto save(UtilisateurDto utilisateurDto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    UtilisateurDto findUtilisateurBymail(String mail);

    UtilisateurDto findUtilisateurBytele(String tele);

    void delete(Integer id);

}
