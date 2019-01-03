/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author elhad
 */
public class Utilisateur {

    private static final long serialVersionUID = 1L;
    private Integer idUtilisateur;
    private String civilite;
    private String prenom;
    private String nom;
    private String identifiant;
    private String motPasse;
    private String numeroTelephone;
    private Date dateNaissance;
    private Date dateCreation;
    private Date dateModification;
    private Boolean actif = true;
    private Boolean marquerEffacer = false;
    private Integer version = 0;
    private List<Adresse> adresses;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur, String civilite, String prenom, String nom, String identifiant, String motPasse, String numeroTelephone, Date dateNaissance, Date dateCreation, Date dateModification, Boolean actif, Boolean marquerEffacer, Integer version, List<Adresse> adresses) {
        this.idUtilisateur = idUtilisateur;
        this.civilite = civilite;
        this.prenom = prenom;
        this.nom = nom;
        this.identifiant = identifiant;
        this.motPasse = motPasse;
        this.numeroTelephone = numeroTelephone;
        this.dateNaissance = dateNaissance;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.actif = actif;
        this.marquerEffacer = marquerEffacer;
        this.version = version;
        this.adresses = adresses;
    }

    public Utilisateur(Integer idUtilisateur, String civilite, String prenom, String nom, String identifiant, String motPasse, String numeroTelephone, Date dateNaissance, List<Adresse> adresses) {
        this(idUtilisateur, civilite, prenom, nom, identifiant, motPasse, numeroTelephone, dateNaissance, null, null, true, false, 0, adresses);
    }

    public Utilisateur(Integer idUtilisateur, String civilite, String prenom, String nom, String identifiant, String motPasse, Date dateNaissance, List<Adresse> adresses) {
        this(idUtilisateur, civilite, prenom, nom, identifiant, motPasse, null, dateNaissance, null, null, true, false, 0, adresses);
    }

    public Utilisateur(Integer idUtilisateur, String civilite, String prenom, String nom, String identifiant, String motPasse, String numeroTelephone, Date dateNaissance, Date dateCreation, Date dateModification, Boolean actif, Boolean marquerEffacer, Integer version) {
        this(idUtilisateur, civilite, prenom, nom, identifiant, motPasse, numeroTelephone, dateNaissance, dateCreation, dateModification, true, false, version, null);
    }

    public Utilisateur(String civilite, String prenom, String nom, String identifiant, String motPasse, String numeroTelephone, Date dateNaissance) {
        this(null, civilite, prenom, nom, identifiant, motPasse, numeroTelephone, dateNaissance, null, null, true, false, 0, null);
    }

    public Utilisateur(Integer idUtilisateur) {
        this(idUtilisateur, null, null, null, null, null, null, null, null, null, true, false, 0, null);
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Boolean isActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean isMarquerEffacer() {
        return marquerEffacer;
    }

    public void setMarquerEffacer(Boolean marquerEffacer) {
        this.marquerEffacer = marquerEffacer;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }
    
    public String toString() {
    	    
    	return "idUtilisateur: "+ idUtilisateur + ",civilite: " + civilite + ", prenom: " + prenom + ", nom: "+ nom +", identifiant" + identifiant + ",version: " + version + ",motPasse: " + motPasse
    			+   ", dateNaissance: "+ dateNaissance + ", dateCreation: " + dateCreation + ", dateModification: " + dateModification + ", actif: " + actif + ", marquerEffacer: "+ marquerEffacer ;
 
   }
    /*@Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	
    	if (obj == null)
    		return false;
    
    	if (getClass() != obj.getClass())
    		return false;

    Utilisateur other = (Utilisateur) obj;

    if (adulte != other.adulte)
    31.
    return false;
    32.
    if (dateNaiss == null) {
    33.
    if (other.dateNaiss != null)
    34.
    return false;
    35.
    } else if (!dateNaiss.equals(other.dateNaiss))
    36.
    return false;
    37.
    if (id != other.id)
    38.
    return false;
    39.
    if (nom == null) {
    40.
    if (other.nom != null)
    41.
    return false;
    42.
    } else if (!nom.equals(other.nom))
    43.
    return false;
    44.
    if (prenom == null) {
    45.
    if (other.prenom != null)
    46.
    return false;
    47.
    } else if (!prenom.equals(other.prenom))
    48.
    return false;
    49.
    return true;
    50.
    }*/
    
    /*@Override
    12.
    public int hashCode() {
    13.
    final int prime = 31;
    14.
    int result = 1;
    15.
    result = prime * result + (adulte ? 1231 : 1237);
    16.
    result = prime * result + ((dateNaiss == null) ? 0 : dateNaiss.hashCode());
    17.
    result = prime * result + (int) (id ^ (id >>> 32));
    18.
    result = prime * result + ((nom == null) ? 0 : nom.hashCode());
    19.
    result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
    20.
    return result;
    21.
    } /*
}
