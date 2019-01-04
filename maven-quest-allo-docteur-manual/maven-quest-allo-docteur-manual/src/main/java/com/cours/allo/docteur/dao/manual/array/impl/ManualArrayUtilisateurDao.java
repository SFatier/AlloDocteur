/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.array.impl;

import com.cours.allo.docteur.dao.IUtilisateurDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;
import com.cours.allo.docteur.factory.AbstractDaoFactory;
import com.cours.allo.docteur.factory.ManualArrayDaoFactory;
import com.cours.allo.docteur.dao.DataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualArrayUtilisateurDao extends AbstractArrayDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(ManualArrayUtilisateurDao.class);
    private  AbstractDaoFactory abstractArrayDao =  ManualArrayDaoFactory.getInstance();
    private  Utilisateur[] lst_utilisateur =  DataSource.getInstance().getUtilisateursArrayDataSource() ;
    
    
    private ManualArrayUtilisateurDao() {
        super(Utilisateur.class, DataSource.getInstance().getUtilisateursArrayDataSource());
    }

    private static class SingletonHolder
    {       
        private final static ManualArrayUtilisateurDao instance = new ManualArrayUtilisateurDao();
    }
 
    public static ManualArrayUtilisateurDao getInstance()
    {
        return SingletonHolder.instance;
    }
    
    @Override
    public List<Utilisateur> findAllUtilisateurs() {
    	List<Utilisateur> lst_utilisateur_resultat = new ArrayList<Utilisateur>();
    	lst_utilisateur_resultat = Arrays.asList(lst_utilisateur);
        return lst_utilisateur_resultat;
    }

    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
    	List<Utilisateur> lst =  findAllUtilisateurs();
    	Utilisateur result = new Utilisateur();
    	
        for(Utilisateur u : lst){
    		if (u.getIdUtilisateur().equals(idUtilisateur)) {
    			result = u;
    			break;
    		}
    	}
    	
        return result;
    }

    @Override
    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant) {
    	List<Utilisateur> lst =  findAllUtilisateurs();
    	List<Utilisateur> result = new ArrayList<Utilisateur>();
    	
        for(Utilisateur u : lst){
    		if (u.getIdentifiant().equals(identifiant)) {
    			result.add(u);
    		}
    	}
    	return result;
    }

    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
    	List<Utilisateur> lst =  findAllUtilisateurs();
    	List<Utilisateur> result = new ArrayList<Utilisateur>();
    	
        for(Utilisateur u : lst){
    		if (u.getPrenom().equals(prenom)) {
    			result.add(u);
    		}
    	}
    	return result;
    }

    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
    	List<Utilisateur> lst =  findAllUtilisateurs();
    	List<Utilisateur> result = new ArrayList<Utilisateur>();
    	
        for(Utilisateur u : lst){
    		if (u.getNom().equals(nom)) {
    			result.add(u);
    		}
    	}
    	return result;
    }

    @Override
    public List<Utilisateur> findUtilisateursByCodePostal(String codePostal) {
    	List<Utilisateur> lst =  findAllUtilisateurs();
    	List<Utilisateur> result = new ArrayList<Utilisateur>();
    	
        for(Utilisateur u : lst){
        	for (Adresse a : u.getAdresses()) {
	    		if (a.getCodePostal().equals(codePostal)) {
	    			result.add(u);
	    			break;
	    		}
        	}
    	}
    	return result;
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {
    	try {
    		List<Adresse> lst_adresse = abstractArrayDao.getAdresseDao().findAllAdresses();    		
    		user.setDateCreation(new Date());	            
     		user.setDateModification(new Date());
     		user.setVersion(1);
     		for (int j = 0; j < user.getAdresses().size(); j++) {            			 
     			Adresse a = lst_adresse.get(j);
     			abstractArrayDao.getAdresseDao().createAdresse(a); 
     		}     		
     		lst_utilisateur[lst_utilisateur.length + 1 ] = user;     				;
    		return user;
    	}catch(Exception ex) {
    		log.error( "(Fonction Array createUtilisateur)" +  ex.getMessage());
    		return null;
    	}    
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
       	try {
    		List<Adresse> lst_adresse = abstractArrayDao.getAdresseDao().findAllAdresses();    		
    		Utilisateur[] lst = lst_utilisateur;
    		for(int i =0; i < lst.length; i++){
            	 if (lst[i].getIdUtilisateur() == user.getIdUtilisateur()) {
            		 lst[i].setCivilite(user.getCivilite()) ;           	 
            		 lst[i].setPrenom(user.getPrenom());
            		 lst[i].setNom(user.getNom());
            		 lst[i].setIdentifiant(user.getMotPasse());
            		 lst[i].setNumeroTelephone(user.getNumeroTelephone());
            		 lst[i].setDateNaissance(user.getDateNaissance());
            		 lst[i].setDateCreation(new Date());	            
            		 lst[i].setDateModification(new Date());
            		 lst[i].setActif(user.isActif());
            		 lst[i].setMarquerEffacer(user.isMarquerEffacer());
            		 lst[i].setVersion(lst[i].getVersion() + 1);
		     		for (int j = 0; j < user.getAdresses().size(); j++) {            			 
		     			Adresse a = lst_adresse.get(j);
		     			abstractArrayDao.getAdresseDao().updateAdresse(a); 
		     		}   
	            	break;
            	 }
         	 }      
    		    		   
	    	return user;
    	}catch(Exception ex) {
    		log.error( "(Fonction Array updateUtilisateur)" +  ex.getMessage());
    		return null;
    	}
    }

    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
    	try {    	
    		List<Utilisateur> lst_result =  findAllUtilisateurs();
    		for(int i =0; i < lst_utilisateur.length; i++){                	
            	 if (lst_utilisateur[i].getIdUtilisateur() == user.getIdUtilisateur())
            		 for (int j = 0; j < lst_utilisateur[i].getAdresses().size(); j++) { 
            			 Adresse a = (Adresse) lst_utilisateur[i].getAdresses().toArray()[j];
            			 abstractArrayDao.getAdresseDao().deleteAdresse(a); 
            		 }
            	 lst_result.remove(i);
            	 break;
         	 }     
    		lst_utilisateur = (Utilisateur[]) lst_result.toArray();
    		return true;
    	}catch(Exception ex) {
    		log.error( "(Fonction deleteUtilisateur)" +  ex.getMessage());
    		return false;
    	}    
    }
}
