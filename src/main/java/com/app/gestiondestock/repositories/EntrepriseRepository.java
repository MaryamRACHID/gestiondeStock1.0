/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.repositories;

import com.app.gestiondestock.dto.EntrepriseDto;
import com.app.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {


    Optional<Entreprise> findEntrepriseByNom(String nom);

    Optional<Entreprise> findEntrepriseByMail(String mail);

    Optional<Entreprise> findEntrepriseBytele(String tele);

    Optional<Entreprise> findEntrepriseBycodeFiscal(String codeFiscal);

}
