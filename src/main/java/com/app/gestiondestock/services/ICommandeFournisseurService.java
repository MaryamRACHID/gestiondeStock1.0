/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.CommandeFournisseurDto;

import java.util.List;

public interface ICommandeFournisseurService {
    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    CommandeFournisseurDto findById(Integer id);

    CommandeFournisseurDto findByCode(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer id);
}
