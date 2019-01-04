/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.array.impl;

import com.cours.allo.docteur.dao.DataSource;
import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.factory.AbstractDaoFactory;
import com.cours.allo.docteur.factory.ManualArrayDaoFactory;

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
public class ManualArrayAdresseDao extends AbstractArrayDao<Adresse> implements IAdresseDao {

    private static final Log log = LogFactory.getLog(ManualArrayAdresseDao.class);
    private  AbstractDaoFactory abstractArrayDao =  ManualArrayDaoFactory.getInstance();
    private  Adresse[] lst_adresse =  DataSource.getInstance().getAdressesArrayDataSource() ;
    
    
    private ManualArrayAdresseDao() {
        super(Adresse.class, DataSource.getInstance().getAdressesArrayDataSource());
    }

    private static class SingletonHolder
    {       
        private final static ManualArrayAdresseDao instance = new ManualArrayAdresseDao();
    }
 
    public static ManualArrayAdresseDao getInstance()
    {
        return SingletonHolder.instance;
    }
    
    @Override
    public List<Adresse> findAllAdresses() {
    	List<Adresse> lst_adresse_result = new ArrayList<Adresse>();
    	
    	lst_adresse_result = Arrays.asList(lst_adresse);
    	
        return lst_adresse_result;
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
    		adresse.setVersion(1);     				
    		lst_adresse[lst_adresse.length + 1 ] = adresse;     				;
    		return adresse;
    	}catch(Exception ex) {
    		log.error( "(Fonction Array createAdresse)" +  ex.getMessage());
    		return null;
    	}    
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
    	try {
 		   
    		for(int i =0; i < lst_adresse.length; i++){
    			 if (lst_adresse[i].getIdAdresse() == adresse.getIdAdresse()) {
    				 lst_adresse[i].setRue(adresse.getRue()) ;           	 
    				 lst_adresse[i].setCodePostal(adresse.getCodePostal());
    				 lst_adresse[i].setVille(adresse.getVille());
    				 lst_adresse[i].setPays(adresse.getPays());
    				 lst_adresse[i].setVersion(lst_adresse[i].getVersion() + 1);
    				 lst_adresse[i].setIdUtilisateur(adresse.getIdUtilisateur());
	            	break;
            	 }
         	 }      
    		    		   
	    	return adresse;
    	}catch(Exception ex) {
    		
    		log.error( "(Fonction Array updateAdresse)" +  ex.getMessage());
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
         	    	lst.remove(i);
            	 	break;
         	 }      	
    		 lst_adresse = (Adresse[]) lst.toArray();
    		return true;
    	}catch(Exception ex) {
    		log.error( "(Fonction deleteAdresse)" +  ex.getMessage());
    		return false;
    	}   
    }
}
