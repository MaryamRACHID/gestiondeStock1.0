/*
 * @author Maryam RACHID
 * Software Engineer from the National School Of Applied Science
 */

package com.app.gestiondestock.exception;

public enum ErrorCodes {

    ARTICLE_NOT_FOUNT(1000),
    CATEGORY_NOT_FOUNT(2000),
    CLIENT_NOT_FOUNT(3000),
    COMMANDE_CLIENT_NOT_FOUNT(4000),
    COMMANDE_FOURNISSEUR_NOT_FOUNT(5000),
    ENTREPRISE_NOT_FOUNT(6000),
    FOURNISSEUR_NOT_FOUNT(7000),
    LIGNE_COMMANDECLIENT_NOT_FOUNT(8000),
    LIGNE_COMMANDEFOURNISSEUR_NOT_FOUNT(9000),
    LIGNE_VENTE_NOT_FOUNT(10000),
    MVT_STOCK_NOT_FOUNT(11000),
    ROLES_NOT_FOUNT(12000),
    UTILISATEUR_NOT_FOUNT(13000),
    VENTE_NOT_FOUNT(14000),
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
