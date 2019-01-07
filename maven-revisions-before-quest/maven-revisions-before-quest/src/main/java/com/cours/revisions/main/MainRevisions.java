/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.main;

import com.cours.revisions.singletons.AbstractStatisticSingleton;
import com.cours.revisions.singletons.CsvStatisticSingleton;
import com.cours.revisions.singletons.JsonStatisticSingleton;
import com.cours.revisions.singletons.XmlStatisticSingleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class MainRevisions {

    private static final Log log = LogFactory.getLog(MainRevisions.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AbstractStatisticSingleton mySingleton = CsvStatisticSingleton.getInstance();
 
        System.out.println("CSV => \n" );  
        
        System.out.println("moyenne poids : " + mySingleton.getMoyennePoids());
        System.out.println("ecartType poids : " + mySingleton.getEcartTypePoids());
        

        System.out.println("moyenne taille : " + mySingleton.getMoyenneTaille());
        System.out.println("ecartType taille : " + mySingleton.getEcartTypeTaille() + "\n");
        
        
        mySingleton = JsonStatisticSingleton.getInstance();
       
        System.out.println("JSON => \n" );  
        
        System.out.println("moyenne poids : " + mySingleton.getMoyennePoids());
        System.out.println("ecartType poids : " + mySingleton.getEcartTypePoids());
        

        System.out.println("moyenne taille : " + mySingleton.getMoyenneTaille());
        System.out.println("ecartType taille : " + mySingleton.getEcartTypeTaille());
        
        mySingleton = XmlStatisticSingleton.getInstance();
        
        System.out.println("XML => \n" );  
        
        System.out.println("moyenne poids : " + mySingleton.getMoyennePoids());
        System.out.println("ecartType poids : " + mySingleton.getEcartTypePoids());
        

        System.out.println("moyenne taille : " + mySingleton.getMoyenneTaille());
        System.out.println("ecartType taille : " + mySingleton.getEcartTypeTaille());
    }
}
