package com.cours.revisions.interfaces;

import java.util.List;

import com.cours.revisions.entities.Personne;

public interface ICSV {
	public List<Personne> createListPersonnes() ;

    public void addPersonne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal);

    public Personne createPersonne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal);

    public List<Personne> createListPersonnesReflexive();

    public Personne addPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal);

    public Personne createPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal);
}
