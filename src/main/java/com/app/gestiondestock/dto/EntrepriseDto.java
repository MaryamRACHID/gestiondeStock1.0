/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.dto;


import com.app.gestiondestock.model.Entreprise;
import com.app.gestiondestock.model.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String tele;

    private String webSite;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise){

        if(entreprise == null) {
            return null;
            //TODO throw on exception || erreur metier
        }
        // Mapping de  Category vers CategoryDto
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .tele(entreprise.getTele())
                .webSite(entreprise.getWebSite())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {

        if(entrepriseDto == null){
            return null;
            //Throw Exception
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entreprise.getPhoto());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setTele(entreprise.getTele());
        entreprise.setWebSite(entrepriseDto.getWebSite());

        return entreprise;
    }
}
