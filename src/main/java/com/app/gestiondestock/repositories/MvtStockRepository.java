/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.repositories;

import com.app.gestiondestock.model.MvtStock;
import com.app.gestiondestock.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MvtStockRepository extends JpaRepository<MvtStock, Integer> {

    Optional<MvtStock> findByCode(String code);
}
