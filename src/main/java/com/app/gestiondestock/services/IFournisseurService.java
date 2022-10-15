/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.FournisseurDto;

import java.util.List;

public interface IFournisseurService {

    FournisseurDto save(FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    FournisseurDto findFournisseurBymail(String mail);

    FournisseurDto findFournisseurBytele(String tele);

    void delete(Integer id);

}
