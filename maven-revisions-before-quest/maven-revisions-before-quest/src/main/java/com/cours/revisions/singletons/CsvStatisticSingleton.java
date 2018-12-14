/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import java.util.ArrayList;
import java.util.List;

import com.cours.revisions.entities.Personne;
import com.cours.revisions.helper.PersonneHelper;
import com.cours.revisions.interfaces.ICSV;

/**
 *
 * @author elhad
 */
public class CsvStatisticSingleton  extends AbstractStatisticSingleton {

	
	private ICSV _service; 
	
    final static String personnesCsvPathFile = "C:\\Users\\sigt_sf\\Documents\\GitHub\\AlloDocteur\\maven-revisions-before-quest\\maven-revisions-before-quest\\personnesCsv.csv";    
   
	private List<Double> lstMoyennePoids;
	private List<Double> lstMoyenneTaille;

	
    private CsvStatisticSingleton() 
    {  
    	_service = new PersonneHelper(personnesCsvPathFile, "CSV");
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
    	personnes = _service.createListPersonnes();
    	
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
