/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.map.impl;

import com.cours.allo.docteur.dao.DataSource;
import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;
import com.cours.allo.docteur.factory.AbstractDaoFactory;
import com.cours.allo.docteur.factory.ManualArrayDaoFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualMapAdresseDao extends AbstractMapDao<Adresse> implements IAdresseDao {

    private static final Log log = LogFactory.getLog(ManualMapAdresseDao.class);
   // private  AbstractDaoFactory abstractArrayDao =  ManualArrayDaoFactory.getInstance();
    private  Map<Integer, Adresse> lst_adresse =  DataSource.getInstance().getAdressesMapDataSource() ;
    
    private ManualMapAdresseDao() {
        super(Adresse.class, DataSource.getInstance().getAdressesMapDataSource());
    }
    
    private static class SingletonHolder
    {       
        private final static ManualMapAdresseDao instance = new ManualMapAdresseDao();
    }
 
    public static ManualMapAdresseDao getInstance()
    {
        return SingletonHolder.instance;
    }

    @Override
    public List<Adresse> findAllAdresses() {
    	List<Adresse> list = new ArrayList<Adresse>();
    	Adresse[] array_utilisateur = (Adresse[]) lst_adresse.values().toArray();
    	list = Arrays.asList(array_utilisateur);    	
    	return list;
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
    		int index = lst_adresse.size() + 1;    	
    		adresse.setVersion(1);     	
    		lst_adresse.put(index, adresse);    	
    		return adresse;
    	}catch(Exception ex) {
    		log.error("(Fonction Map createAdresse) " + ex.getMessage());
    		return null;
    	}
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
    	try {    		
           lst_adresse.put(adresse.getIdAdresse(), adresse);    		
	       return adresse;
    	}catch(Exception ex) {
    		
    		log.error( "(Fonction updateAdresse)" +  ex.getMessage());
    		return null;
    	}
    }

    @Override
    public boolean deleteAdresse(Adresse adresse) {
    	try {
    		List<Adresse> lst =  findAllAdresses();        	
    		for(int i =0; i < lst.size(); i++){
    			Adresse a = lst.get(i);
            	 if (a.getIdAdresse() == adresse.getIdAdresse())
         	    	lst_adresse.remove(i);
            	 	break;
         	 }      	
        	
    		return true;
    	}catch(Exception ex) {
    		log.error( "(Fonction Map deleteAdresse) " +  ex.getMessage());
    		return false;
    	}    
    }
}
