/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cours.revisions.entities.Personne;

/**
 *
 * @author elhad
 */
public class CsvStatisticSingleton  extends AbstractStatisticSingleton {
	
	
    final static String personnesCsvPathFile = "C:\\Users\\sigt_sf\\Documents\\GitHub\\AlloDocteur\\maven-revisions-before-quest\\maven-revisions-before-quest\\personnesCsv.csv";    
   
	private List<Double> lstMoyennePoids;
	private List<Double> lstMoyenneTaille;

	
    private CsvStatisticSingleton() 
    {  
    	extractPersonnesDatas();
    }
     
    private static class SingletonHolder
    {       
        private final static CsvStatisticSingleton instance = new CsvStatisticSingleton();
    }
 
    public static CsvStatisticSingleton getInstance()
    {
        return SingletonHolder.instance;
    }
     
    private List<Personne> createListPersonnes(){ 
    	return  null;
    }
    
    private Personne createPersonneWithFileObject(String[] attributs) {
    	 return null;
    }

    @Override
    protected void extractPersonnesDatas() {  
    	String line = "";       
		
        BufferedReader br = null;
        try {
        	br= new BufferedReader(new FileReader(personnesCsvPathFile));

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
    	
    	lstMoyennePoids = new ArrayList<Double>();
    	for ( Personne personne : personnes) { 
    		lstMoyennePoids.add(personne.getPoids());
    	}
    	
    	moyennePoids = (((double) lstMoyennePoids.stream().filter(i -> i != 0).mapToDouble(i -> i).sum()) / personnes.size());
    	
    	Double variancePoids = 0.0;
    	
    	for (int i = 0; i < personnes.size(); i++) {
    		variancePoids += Math.pow(lstMoyennePoids.get(i)- moyennePoids, 2);    	
    	}
    	
    	variancePoids=variancePoids/lstMoyennePoids.size();
    	
    	ecartTypePoids = Math.sqrt(variancePoids);

    	    	
    	lstMoyenneTaille = new ArrayList<Double>();
    	for (int i = 0; i < personnes.size(); i++) {
    		lstMoyenneTaille.add(personnes.get(i).getTaille());
    	}
    	
    	moyenneTaille =  (((double) lstMoyenneTaille.stream().filter(i -> i != 0).mapToDouble(i -> i).sum()) / personnes.size());
    	
    	Double varianceTaille = 0.0;
    	
    	for (int i = 0; i < personnes.size(); i++) {
    		varianceTaille += Math.pow(lstMoyenneTaille.get(i)- moyenneTaille, 2);    	
    	}
    	
    	varianceTaille=varianceTaille/lstMoyenneTaille.size();
    	
    	ecartTypeTaille = Math.sqrt(varianceTaille);
    	
    }
     
}
