/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.list.impl;

import com.cours.allo.docteur.dao.DataSource;
import com.cours.allo.docteur.dao.IUtilisateurDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;
import com.cours.allo.docteur.factory.AbstractDaoFactory;
import com.cours.allo.docteur.factory.ManualListDaoFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualListUtilisateurDao extends AbstractListDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(ManualListUtilisateurDao.class);
    private  AbstractDaoFactory abstractListDao =  ManualListDaoFactory.getInstance();
    
    
    private ManualListUtilisateurDao() {
        super(Utilisateur.class, DataSource.getInstance().getUtilisateursListDataSource());
    }

    private static class SingletonHolder
    {       
        private final static ManualListUtilisateurDao instance = new ManualListUtilisateurDao();
    }
 
    public static ManualListUtilisateurDao getInstance()
    {
        return SingletonHolder.instance;
    }
    
    @Override
    public List<Utilisateur> findAllUtilisateurs() {
    	
    	List<Utilisateur> lst_utilisateur = new ArrayList<Utilisateur>();
    	
    	lst_utilisateur = DataSource.getInstance().getUtilisateursListDataSource();
    	
        return lst_utilisateur;
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
    		List<Adresse> lst_adresse = abstractListDao.getAdresseDao().findAllAdresses();    		
    		user.setDateCreation(new Date());	            
     		user.setDateModification(new Date());
     		user.setVersion(1);
     		for (int j = 0; j < user.getAdresses().size(); j++) {            			 
     			Adresse a = lst_adresse.get(j);
     			abstractListDao.getAdresseDao().createAdresse(a); 
     		}     		
    		DataSource.getInstance().getUtilisateursListDataSource().add(user);
    		return user;
    	}catch(Exception ex) {
    		log.error( "(Fonction createUtilisateur)" +  ex.getMessage());
    		return null;
    	}    
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
    	
    	try {
    		List<Adresse> lst_adresse = abstractListDao.getAdresseDao().findAllAdresses();    		
    		
    		for(int i =0; i < DataSource.getInstance().getUtilisateursListDataSource().size(); i++){
            	Utilisateur u = DataSource.getInstance().getUtilisateursListDataSource().get(i);
            	 if (u.getIdUtilisateur() == user.getIdUtilisateur()) {
            		u.setCivilite(user.getCivilite()) ;           	 
	            	u.setPrenom(user.getPrenom());
	            	u.setNom(user.getNom());
	            	u.setIdentifiant(user.getMotPasse());
	            	u.setNumeroTelephone(user.getNumeroTelephone());
	            	u.setDateNaissance(user.getDateNaissance());
	            	u.setDateCreation(user.getDateCreation());	            
		     		u.setDateModification(new Date());
		     		u.setActif(user.isActif());
		     		u.setMarquerEffacer(user.isMarquerEffacer());
		     		u.setVersion(u.getVersion() + 1);
		     		for (int j = 0; j < user.getAdresses().size(); j++) {            			 
		     			Adresse a = lst_adresse.get(j);
		     			abstractListDao.getAdresseDao().updateAdresse(a); 
		     		}   
	            	break;
            	 }
         	 }      
    		    		   
	    	return user;
    	}catch(Exception ex) {
    		log.error( "(Fonction updateUtilisateur)" +  ex.getMessage());
    		return null;
    	}
    }

    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
    	try {    	
    		
    		for(int i =0; i < DataSource.getInstance().getUtilisateursListDataSource().size(); i++){
                	Utilisateur u = DataSource.getInstance().getUtilisateursListDataSource().get(i);
            	 if (u.getIdUtilisateur() == user.getIdUtilisateur())
            		 for (int j = 0; j < u.getAdresses().size(); j++) {            			 
            			 Adresse a = u.getAdresses().get(j);
            			 abstractListDao.getAdresseDao().deleteAdresse(a); 
            		 }
            		 DataSource.getInstance().getUtilisateursListDataSource().remove(i);
            	 	break;
         	 }      	
        	
    		return true;
    	}catch(Exception ex) {
    		log.error( "(Fonction deleteUtilisateur)" +  ex.getMessage());
    		return false;
    	}    
    }
}
