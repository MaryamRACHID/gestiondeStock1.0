/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.services;

import com.app.gestiondestock.dto.VenteDto;

import java.util.List;

public interface IVenteService {

    VenteDto save(VenteDto venteDto);

    VenteDto findById(Integer id);

    VenteDto findByCode(String code);

    List<VenteDto> findAll();

    void delete(Integer id);
}
