/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.EntrepriseDto;
import com.app.gestiondestock.model.Entreprise;

import java.util.List;

public interface IEntrepriseService {

    EntrepriseDto save(EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    EntrepriseDto findEntrepriseByNom(String nom);

    EntrepriseDto findEntrepriseByMail(String mail);

    EntrepriseDto findEntrepriseBytele(String tele);

    EntrepriseDto findEntrepriseBycodeFiscal(String codeFiscal);

    List<EntrepriseDto> findAll();

    void delete(Integer id);

}
