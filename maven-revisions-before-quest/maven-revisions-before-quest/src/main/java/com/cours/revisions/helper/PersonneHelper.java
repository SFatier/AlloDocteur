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
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 *
 * @author elhad
 */
public class PersonneHelper implements ICSV , IJSON {

    private List<Personne> personnes = new ArrayList<Personne>();
    private String _filepath, _fileAbrv;
       
    public PersonneHelper(String filepath, String fileAbrv) {
    	_filepath = filepath;
    	_fileAbrv = fileAbrv;
	}
    

	public List<Personne> createListPersonnes() {	
		System.out.println(_fileAbrv);
		if (_fileAbrv == "CSV") {
			String line = "";       
		
	        BufferedReader br = null;
	        try {
	        	br= new BufferedReader(new FileReader(_filepath));
	
	            while ((line = br.readLine()) != null) {
	
	            	Personne personne = new Personne();
	            	   String[] p = line.split(";");
	            	   if (!line.equals("﻿idPersonne;Prenom;Nom;Poids;Taille;Rue;Ville;Code Postal" )) {      	        
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
		}else if (_fileAbrv == "JSON"){
			JSONParser parser = new JSONParser();
			 
	        try {
	 
	            Object obj = parser.parse(new FileReader(_filepath));
	          	            
	            JSONObject jsonObjectBase = (JSONObject) obj;
	            JSONArray personList = (JSONArray) jsonObjectBase.get("personnes");
	                       
	            
	            for (Object o : personList) {
	            	Personne personne = new Personne();
	                JSONObject jsonLineItem = (JSONObject) o;
	                personne.setIdPersonne(Integer.parseInt(String.valueOf(jsonLineItem.get("id"))));
	                personne.setPoids(Double.parseDouble(String.valueOf(jsonLineItem.get("poids"))));
	                personne.setTaille(Double.parseDouble(String.valueOf( jsonLineItem.get("taille"))));
		            personnes.add(personne);
	            }	            
	            	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

        return personnes;
    }

    public void addPersonne(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
       personnes.add(new Personne(idPersonne, prenom, nom, poids, taille, rue, ville, codePostal));
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

	@Override
	public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson) {
		// TODO Auto-generated method stub
		return null;
	}
}
