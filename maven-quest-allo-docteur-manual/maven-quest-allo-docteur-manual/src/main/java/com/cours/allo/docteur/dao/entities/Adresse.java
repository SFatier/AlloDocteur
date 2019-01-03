/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.entities;

/**
 *
 * @author elhad
 */
public class Adresse {

    private static final long serialVersionUID = 1L;
    private Integer idAdresse;
    private String rue;
    private String codePostal;
    private String ville;
    private String pays;
    private Boolean principale = false;
    private Integer version = 0;
    private Integer idUtilisateur;

    public Adresse() {
    }

    public Adresse(Integer idAdresse, String rue, String codePostal, String ville, String pays, Boolean principale, Integer version, Integer idUtilisateur) {
        this.idAdresse = idAdresse;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.principale = principale;
        this.version = version;
        this.idUtilisateur = idUtilisateur;
    }

    public Adresse(Integer idAdresse, String rue, String codePostal, String ville, String pays, Boolean principale, Integer idUtilisateur) {
        this(idAdresse, rue, codePostal, ville, pays, principale, 0, idUtilisateur);
    }

    public Adresse(Integer idAdresse, String rue, String codePostal, String ville, String pays, Integer idUtilisateur) {
        this(idAdresse, rue, codePostal, ville, pays, false, 0, idUtilisateur);
    }

    public Adresse(String rue, String codePostal, String ville, String pays, Integer idUtilisateur) {
        this(null, rue, codePostal, ville, pays, false, 0, idUtilisateur);
    }

    public Adresse(Integer idAdresse, String rue, String codePostal, String ville, String pays) {
        this(idAdresse, rue, codePostal, ville, pays, false, 0, null);
    }

    public Adresse(Integer idAdresse) {
        this(idAdresse, null, null, null, null, false, 0, null);
    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Boolean isPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }
    
    public String toString() {
    	return "Rue: "+ rue + ", Code postal: " + codePostal + ", ville: " + ville + ", pays: "+ pays +", principale" + principale + ",version: " + version + ",idUtilisateur: " + idUtilisateur;
 
   }
    
    //Que sur idUtilisateur et idAdresse
    @Override
     public boolean equals(Object obj) {
     	if (this == obj)
     		return true;
     	
     	if (obj == null)
     		return false;
     
     	if (getClass() != obj.getClass())
     		return false;

     Adresse other = (Adresse) obj;
     
     if (idAdresse != other.idAdresse)
     	return false;
     
     if (idUtilisateur != other.idUtilisateur)
      	return false;
     
     return false;
    }

    //Que sur idUtilisateur et idAdresse
    @Override    
     public int hashCode() { 
 	   int hash = 1;
       hash = hash * 17 + idUtilisateur;
       hash = hash * 17 + idAdresse;
 	   return hash;
     } 
}
