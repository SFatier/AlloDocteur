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
import com.cours.allo.docteur.exception.CustomException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
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
    public Utilisateur createUtilisateur(Utilisateur user) throws CustomException{
    	Utilisateur[] utilisateurs;
		int lastId;
		lastId =lst_utilisateur[lst_utilisateur.length -1].getIdUtilisateur();

		utilisateurs = new Utilisateur[lst_utilisateur.length + 1];
		System.arraycopy(lst_utilisateur,
						 0,
						 utilisateurs,
						 0,
						 lst_utilisateur.length);

		user.setIdUtilisateur(lastId + 1);
		user.setDateModification(new Date());
		user.setDateCreation(new Date());

		utilisateurs[lst_utilisateur.length] = user;

		lst_utilisateur = utilisateurs.clone();
                
		return user;
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) throws CustomException{
                boolean trouve = false;
    		List<Adresse> lst_adresse = AbstractDaoFactory.getFactory(AbstractDaoFactory.FactoryDaoType.MANUAL_ARRAY_DAO_FACTORY).getAdresseDao().findAllAdresses(); //abstractArrayDao.getAdresseDao().findAllAdresses();    		
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
                         // Adresse à mettre à jour si besoin
                         lst[i].setVersion(lst[i].getVersion() + 1);
		     		for (int j = 0; j < lst_adresse.size(); j++) {            			 
		     			Adresse a = lst_adresse.get(j);
		     			AbstractDaoFactory.getFactory(AbstractDaoFactory.FactoryDaoType.MANUAL_ARRAY_DAO_FACTORY).getAdresseDao().updateAdresse(a); 
		     		} 
                                trouve = true;
	            	break;
                         
            	 }
         	 }      
    		    		   
	    	
               if (trouve == false) {
			throw new CustomException(
					  "L'utilisateur portant l'identifiant " + user.getIdentifiant() + " n'existe pas",2);
                     
		}
               return user;
    	}
    
    

    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
    	
    int idxArray;
		int i = 0;
		int size;
		Utilisateur[] u;
		boolean trouve =false;
		idxArray = 0;
		
		size = lst_utilisateur.length;
		u = new Utilisateur[size - 1];

		while (idxArray < size) {
			if (lst_utilisateur[idxArray].getIdUtilisateur().equals(user.
																				  getIdUtilisateur()))
			{
				trouve = true;
			} else {
				u[i] = lst_utilisateur[idxArray];
				i++;
			}

			idxArray++;
		}

		lst_utilisateur = new Utilisateur[size - 1];
		System.arraycopy(u, 0, lst_utilisateur, 0, size - 1);

		return trouve;
}
}
