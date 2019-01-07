/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.main;

import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;
import com.cours.allo.docteur.exception.CustomException;
import com.cours.allo.docteur.factory.AbstractDaoFactory;
import com.cours.allo.docteur.service.IServiceFacade;
import com.cours.allo.docteur.service.ServiceFacade;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class Main {

    private static final Log log = LogFactory.getLog(Main.class);
    private static IServiceFacade serviceFacade = null;
    private static List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
    private static List<Adresse> listAdresse = new ArrayList<Adresse>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
 //       serviceFacade = new ServiceFacade(AbstractDaoFactory.FactoryDaoType.MANUAL_ARRAY_DAO_FACTORY);
 //       log.debug("___________ARRAY______________");
//        //findAllUtilisateurs
//        log.debug(serviceFacade.getUtilisateurDao().findAllUtilisateurs());
//        //findUtilisateurById
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateurById(1));
//        //findUtilisateurByIdentifiant
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateurByIdentifiant("remy.collard@gmail.com"));
//        //findUtilisateursByPrenom
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByPrenom("Dimitry"));
//        //findUtilisateursByNom
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByNom("Leduc"));
//        // findUtilisateursByCodePostal
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByCodePostal("44000"));
//        //createUtilisateur
//        Utilisateur user = new Utilisateur(125);
//        user = serviceFacade.getUtilisateurDao().createUtilisateur(user);
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateurById(user.getIdUtilisateur()));
//        //updateUtilisateur
//        user.setPrenom("Tanor");
//        user.setNom("BESSANE");
//        user = serviceFacade.getUtilisateurDao().updateUtilisateur(user);
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateurById(user.getIdUtilisateur()));
//        //deleteUtilisateur
//        serviceFacade.getUtilisateurDao().deleteUtilisateur(user);
//        log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByNom("BESSANE"));
//        //find AllAdresses
//        log.debug(serviceFacade.getAdresseDao().findAllAdresses());
//        //findAdresseById
//        log.debug(serviceFacade.getAdresseDao().findAdresseById(1));
//        //findAdressesByVille
//        log.debug(serviceFacade.getAdresseDao().findAdressesByVille("Paris"));
//        //findAdressesByCodePostal
//        log.debug(serviceFacade.getAdresseDao().findAdressesByCodePostal("75000"));
//
//        //createAdresse
//        Adresse adresse = new Adresse();
//        adresse = serviceFacade.getAdresseDao().createAdresse(adresse);
//        log.debug(serviceFacade.getAdresseDao().findAdresseById(adresse.getIdAdresse()));
//        //updateAdresse
//        adresse.setCodePostal("93800");//setPrenom("Tanor");
//        adresse.setRue("8 rue Claude Monet");
//        adresse = serviceFacade.getAdresseDao().updateAdresse(adresse);
//        log.debug(serviceFacade.getAdresseDao().findAdresseById(adresse.getIdAdresse()));
//       //deleteAdresse
//        serviceFacade.getAdresseDao().deleteAdresse(adresse);
//        log.debug(serviceFacade.getAdresseDao().findAdressesByCodePostal("93800"));
//        log.debug("FINISH");
        log.debug("___________LIST______________");
        serviceFacade = new ServiceFacade(AbstractDaoFactory.FactoryDaoType.MANUAL_MAP_DAO_FACTORY);

         //findAllUtilisateurs
        log.debug(serviceFacade.getUtilisateurDao().findAllUtilisateurs());
        //findUtilisateurById
        log.debug(serviceFacade.getUtilisateurDao().findUtilisateurById(1));
        //findUtilisateurByIdentifiant
        log.debug(serviceFacade.getUtilisateurDao().findUtilisateurByIdentifiant("stephanie.job@gmail.com"));
        //findUtilisateursByPrenom
   //     log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByPrenom("Dimitry"));
        //findUtilisateursByNom
    //    log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByNom("Leduc"));
        // findUtilisateursByCodePostal
   //     log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByCodePostal("44000"));
        //createUtilisateur
  //      Utilisateur user = new Utilisateur(125);
 //       user = serviceFacade.getUtilisateurDao().createUtilisateur(user);
  //      log.debug(serviceFacade.getUtilisateurDao().findUtilisateurById(user.getIdUtilisateur()));
        //updateUtilisateur
  //      user.setPrenom("Tanor");
  //     user.setNom("BESSANE");
  //      user = serviceFacade.getUtilisateurDao().updateUtilisateur(user);
  //      log.debug(serviceFacade.getUtilisateurDao().findUtilisateurById(user.getIdUtilisateur()));
        //deleteUtilisateur
 //      serviceFacade.getUtilisateurDao().deleteUtilisateur(user);
   //    log.debug(serviceFacade.getUtilisateurDao().findUtilisateursByNom("BESSANE"));
        //find AllAdresses
     //   log.debug(serviceFacade.getAdresseDao().findAllAdresses());
        //findAdresseById
   //     log.debug(serviceFacade.getAdresseDao().findAdresseById(1));
        //findAdressesByVille
   //     log.debug(serviceFacade.getAdresseDao().findAdressesByVille("Paris"));
        //findAdressesByCodePostal
   //     log.debug(serviceFacade.getAdresseDao().findAdressesByCodePostal("75000"));

        //createAdresse
   //     Adresse adresse = new Adresse();
  //      adresse = serviceFacade.getAdresseDao().createAdresse(adresse);
  //      log.debug(serviceFacade.getAdresseDao().findAdresseById(adresse.getIdAdresse()));
        //updateAdresse
  //      adresse.setCodePostal("93800");//setPrenom("Tanor");
  //      adresse.setRue("8 rue Claude Monet");
  //      adresse = serviceFacade.getAdresseDao().updateAdresse(adresse);
    //    log.debug(serviceFacade.getAdresseDao().findAdresseById(adresse.getIdAdresse()));
       //deleteAdresse
    //    serviceFacade.getAdresseDao().deleteAdresse(adresse);
   //     log.debug(serviceFacade.getAdresseDao().findAdressesByCodePostal("93800"));
        
//        log.debug("___________MAP______________");
//        serviceFacade = new ServiceFacade(AbstractDaoFactory.FactoryDaoType.MANUAL_MAP_DAO_FACTORY);
//        log.debug(serviceFacade.getUtilisateurDao().findAllUtilisateurs());
    }
}
