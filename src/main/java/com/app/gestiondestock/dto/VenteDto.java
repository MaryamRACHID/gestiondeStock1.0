/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.dto;

import com.app.gestiondestock.model.LigneVente;
import com.app.gestiondestock.model.Vente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VenteDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    @JsonIgnore
    private List<LigneVente> venteList;


    public static VenteDto fromEntity(Vente vente){
        if(vente == null){
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Vente toEntity(VenteDto venteDto){
        if (venteDto == null){
            return null;
        }
        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}
