/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.main;

import com.cours.allo.docteur.dao.DataSourceSingleton;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;
import com.cours.allo.docteur.factory.AbstractDaoFactory;
import com.cours.allo.docteur.service.IServiceFacade;
import com.cours.allo.docteur.service.ServiceFacade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class Main {

    private static final Log log = LogFactory.getLog(Main.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IServiceFacade serviceFacade = null;
     //    Connection connection = null;

      //  PreparedStatement statement = null;

       // ResultSet resultSet = null;

 
            serviceFacade = new ServiceFacade(AbstractDaoFactory.FactoryDaoType.JDBC_DAO_FACTORY);
            Date d = new Date(System.currentTimeMillis());
            //DataSource bds = DataSourceSingleton.getInstance().getDataSource();
           // log.debug(serviceFacade.getAdresseDao().findAllAdresses());
           // log.debug(serviceFacade.getAdresseDao().findAdresseById(1));
           // log.debug(serviceFacade.getAdresseDao().findAdressesByCodePostal("75000"));
           // log.debug(serviceFacade.getAdresseDao().findAdressesByVille("Paris"));
             Utilisateur userCRUD = new Utilisateur("Mr", "Jean", "Ass", "jean.ass@gmail.com", "passw0rd" ,"01020102", d);
             userCRUD = serviceFacade.getUtilisateurDao().createUtilisateur(userCRUD);
            Adresse adresseCRUD = new Adresse("8 rue Claude Monet", "75000", "Paris", "France", userCRUD.getIdUtilisateur());
             adresseCRUD = serviceFacade.getAdresseDao().createAdresse(adresseCRUD);
            
            

     



   
        }

 

    }

 



    

