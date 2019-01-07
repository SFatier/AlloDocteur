/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;

import java.io.File;
import org.jdom.*;
import org.jdom.input.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author elhad
 */
public class XmlStatisticSingleton extends AbstractStatisticSingleton {

    final String personnesXmlPathFile = "C:\\Users\\sigt_sf\\Documents\\GitHub\\AlloDocteur\\maven-revisions-before-quest\\maven-revisions-before-quest\\personnesXml.xml";
   
    static org.jdom.Document document;
	static Element racine;
	private List<Double> lstMoyennePoids;
	private List<Double> lstMoyenneTaille;
	 
    private XmlStatisticSingleton() {
    	extractPersonnesDatas();
    }

    private static class SingletonHolder
    {       
        private final static XmlStatisticSingleton instance = new XmlStatisticSingleton();
    }
 
    public static XmlStatisticSingleton getInstance()
    {
    	return SingletonHolder.instance;
    }
    
    public Personne createPersonneWithFileObject(Element elementPersonne) {
        return null;
    }

    @Override
    protected void extractPersonnesDatas() {    	
    	 
    	 SAXBuilder sxb = new SAXBuilder();
         try
         {
            document = sxb.build(new File(personnesXmlPathFile));
         }
         catch(Exception e) {
             e.printStackTrace();
         }
         
         racine = document.getRootElement();
         
		List listPersonnes = racine.getChildren("personne");

		Iterator j = listPersonnes.iterator();
        while(j.hasNext())
         {
        	Personne personne = new Personne();
            Element courant = (Element)j.next();
            personne.setIdPersonne(Integer.parseInt(courant.getAttributeValue("id")));
            personne.setTaille(Double.parseDouble(courant.getChild("taille").getText()));
            personne.setPoids(Double.parseDouble(courant.getChild("poids").getText()));
           
            personnes.add(personne);           
            
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
