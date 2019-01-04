/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.list.impl;

import com.cours.allo.docteur.dao.DataSource;
import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualListAdresseDao extends AbstractListDao<Adresse> implements IAdresseDao {

    private static final Log log = LogFactory.getLog(ManualListAdresseDao.class);

    private ManualListAdresseDao() {
        super(Adresse.class, DataSource.getInstance().getAdressesListDataSource());
    }
    
    private static class SingletonHolder
    {       
        private final static ManualListAdresseDao instance = new ManualListAdresseDao();
    }
 
    public static ManualListAdresseDao getInstance()
    {
        return SingletonHolder.instance;
    }

    @Override
    public List<Adresse> findAllAdresses() {
    	List<Adresse> lst_adresse = new ArrayList<Adresse>();
    	
    	lst_adresse = DataSource.getInstance().getAdressesListDataSource();
    	
        return lst_adresse;
    }

    @Override
    public Adresse findAdresseById(int idAdresse) {
    	List<Adresse> lst =  findAllAdresses();
    	Adresse result = new Adresse();
    	
        for(Adresse u : lst){
    		if (u.getIdUtilisateur().equals(idAdresse)) {
    			result = u;
    			break;
    		}
    	}
    	
        return result;
    }

    @Override
    public List<Adresse> findAdressesByVille(String ville) {
    	List<Adresse> lst =  findAllAdresses();
    	List<Adresse> result = new ArrayList<Adresse>();
    	
        for(Adresse u : lst){
    		if (u.getVille().equals(ville)) {
    			result.add(u);
    		}
    	}
    	return result;
    }

    @Override
    public List<Adresse> findAdressesByCodePostal(String codePostal) {
    	List<Adresse> lst =  findAllAdresses();
    	List<Adresse> result = new ArrayList<Adresse>();
    	
        for(Adresse u : lst){
    		if (u.getCodePostal().equals(codePostal)) {
    			result.add(u);
    		}
    	}
    	return result;
    }

    @Override
    public Adresse createAdresse(Adresse adresse) {
    	try {
    		DataSource.getInstance().getAdressesListDataSource().add(adresse);
    		return adresse;
    	}catch(Exception ex) {
    		return null;
    	}    	       
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {     
    	try {
    		   
    		for(int i =0; i < DataSource.getInstance().getAdressesListDataSource().size(); i++){
    			Adresse a = DataSource.getInstance().getAdressesListDataSource().get(i);
            	 if (a.getIdAdresse() == adresse.getIdAdresse()) {
            			a.setRue(adresse.getRue()) ;           	 
    	            	a.setCodePostal(adresse.getCodePostal());
    	            	a.setVille(adresse.getVille());
    	            	a.setPays(adresse.getPays());
    	            	a.setVersion(adresse.getVersion());
    	            	a.setIdUtilisateur(adresse.getIdUtilisateur());
	            	break;
            	 }
         	 }      
    		    		   
	    	return adresse;
    	}catch(Exception ex) {
    		return null;
    	}
        
    }

    @Override
    public boolean deleteAdresse(Adresse adresse) {
    	try {
    		List<Adresse> lst =  DataSource.getInstance().getAdressesListDataSource();
        	
    		for(int i =0; i < lst.size(); i++){
    			Adresse a = lst.get(i);
            	 if (a.getIdAdresse() == adresse.getIdAdresse())
         	    	lst.remove(i);
            	 	break;
         	 }      	
        	
    		return true;
    	}catch(Exception ex) {
    		return false;
    	}    
    }
}
