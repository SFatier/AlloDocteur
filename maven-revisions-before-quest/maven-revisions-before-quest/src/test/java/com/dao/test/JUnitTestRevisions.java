package com.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.cours.revisions.entities.Personne;
import com.cours.revisions.helper.PersonneHelper;
import com.cours.revisions.singletons.AbstractStatisticSingleton;
import com.cours.revisions.singletons.CsvStatisticSingleton;
import com.cours.revisions.singletons.JsonStatisticSingleton;
import com.cours.revisions.singletons.XmlStatisticSingleton;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTestRevisions {

    private static final Log log = LogFactory.getLog(JUnitTestRevisions.class);
    private static AbstractStatisticSingleton singletonCsv = null;
    private static AbstractStatisticSingleton singletonXml = null;
    private static AbstractStatisticSingleton singletonJson = null;
    private static PersonneHelper personneHelper = null;

    @BeforeClass
    public static void init() throws Exception {
    	   singletonCsv = CsvStatisticSingleton.getInstance();
    	   singletonXml = XmlStatisticSingleton.getInstance();
    	   singletonJson = JsonStatisticSingleton.getInstance();
    }

    @Test
    public void testJUnitAllCalculMoyenneEcartType() {
        log.debug("Entree de la methode");
        testJUnitCalculMoyenneEcartType(singletonCsv);
        testJUnitCalculMoyenneEcartType(singletonXml);
        testJUnitCalculMoyenneEcartType(singletonJson);
        log.debug("Sortie de la methode");
    }
    
    public void testJUnitCalculMoyenneEcartType(AbstractStatisticSingleton singleton) {
    	log.debug("Entree de la methode");
        log.debug("difference moyenne poids : " + Math.abs(68.6500 - singleton.getMoyennePoids()));
        log.debug("difference ecartType poids : " + Math.abs(17.4707 - singleton.getEcartTypePoids()));
        Assert.assertTrue(Math.abs(68.6500 - singleton.getMoyennePoids()) < 1e-4);
        Assert.assertTrue(Math.abs(17.4707 - singleton.getEcartTypePoids()) < 1e-4);
        log.debug("difference moyenne taille : " + Math.abs(166.0500 - singleton.getMoyenneTaille()));
        log.debug("difference ecartType taille : " + Math.abs(17.6138 - singleton.getEcartTypeTaille()));
        Assert.assertTrue(Math.abs(166.0500 - singleton.getMoyenneTaille()) < 1e-4);
        Assert.assertTrue(Math.abs(17.6138 - singleton.getEcartTypeTaille()) < 1e-4);
        log.debug("Sortie de la methode");
    }

    @Test
    public void testCreatePersonnes() {
        List<Personne> personnes = personneHelper.createListPersonnes();
        personneHelper.addPersonne(1, "Maurice", "Dupont", 100.0, 170.0, "rue du paradis", "Rouen", "76000");
        personneHelper.addPersonne(2, "Martin", "Marshall", 55.0, 150.0, "rue de Nantes", "Laval", "53000");
        personneHelper.addPersonne(3, "Claire", "Chazal", 65.0, 175.0, "rue de Rennes", "Laval", "53000");
        personneHelper.addPersonne(4, "Celine", "Dia", 87.0, 170.0, "rue Diderot", "Paris", "75000");
        personneHelper.addPersonne(5, "Remy", "Cheval", 63.0, 140.0, "rue du paradis", "Nantes", "44000");
        Assert.assertEquals(5, personnes.size());
    }

    @Test
    public void testCreatePersonnesReflexive() {
        List<Personne> personnes = personneHelper.createListPersonnesReflexive();
        personneHelper.addPersonneReflexive(1, "Maurice", "Dupont", 100.0, 170.0, "rue du paradis", "Rouen", "76000");
        personneHelper.addPersonneReflexive(2, "Martin", "Marshall", 55.0, 150.0, "rue de Nantes", "Laval", "53000");
        personneHelper.addPersonneReflexive(3, "Claire", "Chazal", 65.0, 175.0, "rue de Rennes", "Laval", "53000");
        personneHelper.addPersonneReflexive(4, "Celine", "Dia", 87.0, 170.0, "rue Diderot", "Paris", "75000");
        personneHelper.addPersonneReflexive(5, "Remy", "Cheval", 63.0, 140.0, "rue du paradis", "Nantes", "44000");
        log.debug("personnes : " + personnes);
        Assert.assertEquals(5, personnes.size());
    }

    @AfterClass
    public static void terminate() throws Exception {
        log.debug("Entree de la methode");
        singletonCsv = null;
        singletonXml = null;
        singletonJson = null;
        personneHelper = null;
        log.debug("Sortie de la methode");
    }
}
