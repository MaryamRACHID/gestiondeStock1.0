/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.dto;


import com.app.gestiondestock.model.Client;
import com.app.gestiondestock.model.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String tele;

    @JsonIgnore
    private List<CommandeFournisseurDto> commandesFournisseur;

    public static FournisseurDto fromEntity(Fournisseur fournisseur){

        if(fournisseur == null) {
            return null;
            //TODO throw on exception || erreur metier
        }
        // Mapping de  Category vers CategoryDto
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .tele(fournisseur.getTele())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {

        if(fournisseurDto == null){
            return null;
            //Throw Exception
        }

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
        fournisseur.setPhoto(fournisseur.getPhoto());
        fournisseur.setTele(fournisseur.getTele());

        return fournisseur;
    }


}
