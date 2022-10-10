/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.dto;

import com.app.gestiondestock.model.Adresse;
import com.app.gestiondestock.model.Category;
import com.app.gestiondestock.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String tele;

    @JsonIgnore
    private List<CommandeClientDto> commandesClient;


    public static ClientDto fromEntity(Client client){

        if(client == null) {
            return null;
            //TODO throw on exception || erreur metier
        }
        // Mapping de  Category vers CategoryDto
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .tele(client.getTele())
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {

        if(clientDto == null){
            return null;
            //Throw Exception
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setPhoto(client.getPhoto());
        client.setTele(client.getTele());

        return client;
    }


}
