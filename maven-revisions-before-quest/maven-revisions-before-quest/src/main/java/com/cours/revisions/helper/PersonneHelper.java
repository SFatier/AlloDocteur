/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.helper;

import com.cours.revisions.entities.Personne;
import com.cours.revisions.interfaces.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 *
 * @author elhad
 */
public class PersonneHelper implements ICSV {

    private List<Personne> personnes = new ArrayList<Personne>();
    private String _personnesCsvPathFile;
       

    public PersonneHelper(String personnesCsvPathFile) {
		// TODO Auto-generated constructor stub
    	_personnesCsvPathFile = personnesCsvPathFile;
	}

	public List<Personne> createListPersonnes() {		
        String line = "";       
        BufferedReader br = null;
        try {
        	br= new BufferedReader(new FileReader(_personnesCsvPathFile));

            while ((line = br.readLine()) != null) {

            	Personne personne = new Personne();
            	   String[] p = line.split(";");
            	   if (!line.equals("﻿idPersonne;Prenom;Nom;Poids;Taille;Rue;Ville;Code Postal" )) {      	             
	                //System.out.println("Personne [id= " + p[0] + " , poids=" + p[3] + " , taille=" + p[4] +"]");
	                personne.setIdPersonne(Integer.parseInt(p[0]));
	                personne.setPoids(Double.parseDouble(p[3]));
	                personne.setTaille(Double.parseDouble(p[4]));
	                personnes.add(personne);
            	}
            }

        } catch (IOException e) {
            e.printStackTrace();          
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return personnes;
    }

    public void addPersonne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
       
    }

    public Personne createPersonne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
       return null;
    }

    public List<Personne> createListPersonnesReflexive() {
        return null;
    }

    public Personne addPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
        return null;
    }

    public Personne createPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
       return null;
    }
}
