/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import com.cours.revisions.helper.PersonneHelper;
import com.cours.revisions.interfaces.IJSON;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/**
 *
 * @author elhad
 */
public class JsonStatisticSingleton extends AbstractStatisticSingleton {

	private IJSON _service; 
	private List<Double> lstMoyennePoids;
	private List<Double> lstMoyenneTaille;

    final String personnesJsonPathFile = "C:\\Users\\sigt_sf\\Documents\\GitHub\\AlloDocteur\\maven-revisions-before-quest\\maven-revisions-before-quest\\personnesJson.json";

    private JsonStatisticSingleton() {
    	_service = new PersonneHelper(personnesJsonPathFile, "JSON");
    	extractPersonnesDatas();
    }
    
    private static class SingletonHolder
    {       
        private final static JsonStatisticSingleton instance = new JsonStatisticSingleton();
    }
 
    public static JsonStatisticSingleton getInstance()
    {
        return SingletonHolder.instance;
    }

    public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson) {
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
