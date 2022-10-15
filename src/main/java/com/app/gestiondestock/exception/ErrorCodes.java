/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.exception;

public enum ErrorCodes {

    ARTICLE_NOT_FOUNT(1000),
    ARTICLE_NOT_VALID(1001),

    CATEGORY_NOT_FOUNT(2000),
    CATEGORY_NOT_VALID(2001),

    CLIENT_NOT_FOUNT(3000),
    CLIENT_NOT_VALID(3001),

    COMMANDE_CLIENT_NOT_FOUNT(4000),
    COMMAND_CLIENT_VALID(4001),

    COMMANDE_FOURNISSEUR_NOT_FOUNT(5000),
    ENTREPRISE_NOT_FOUNT(6000),
    ENTREPRISE_NOT_VALID(6001),

    FOURNISSEUR_NOT_FOUNT(7000),
    FOURNISSEUR_NOT_VALID(7001),

    LIGNE_COMMANDECLIENT_NOT_FOUNT(8000),
    LIGNE_COMMANDEFOURNISSEUR_NOT_FOUNT(9000),
    LIGNE_VENTE_NOT_FOUNT(10000),
    MVT_STOCK_NOT_FOUNT(11000),
    ROLES_NOT_FOUNT(12000),
    UTILISATEUR_NOT_FOUNT(13000),
    UTILISATEUR_NOT_VALID(13001),

    VENTE_NOT_FOUNT(14000),
    VENTE_NOT_VALID(14001),
    ;

    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public void setCode(int code){
        this.code = code;
    }

}
