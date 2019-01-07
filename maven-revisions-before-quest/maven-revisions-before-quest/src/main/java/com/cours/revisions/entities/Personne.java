package com.cours.revisions.entities;


/**
 *
 * @author ElHadji
 */
public class Personne {

    private Integer idPersonne;
    private String prenom;
    private String nom;
    private Double poids;
    private Double taille;
    private String rue;
    private String ville;
    private String codePostal;

    public Personne() {

    }

    public Personne(String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
        this.prenom = prenom;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Personne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
        this.idPersonne = idPersonne;
        this.prenom = prenom;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
