/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.list.impl;

import com.cours.allo.docteur.dao.DataSource;
import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.exception.CustomException;

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
    public static List<Adresse> listAdresses = DataSource.getInstance().getAdressesListDataSource();
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
    public Adresse findAdresseById(int idAdresse) throws CustomException{
    	for (Adresse adresse : listAdresses) {
            if (adresse.getIdAdresse().equals(idAdresse)) {
                return adresse;
            }
        }
        throw new CustomException("Aucune adresse a l'" + idAdresse, 1);
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
    	int idAdresse = 0;
        log.debug("Entree de la methode");
        idAdresse = listAdresses.get(listAdresses.size() - 1).getIdAdresse();
        adresse.setIdAdresse(idAdresse + 1);
        listAdresses.add(adresse);
        log.debug("Sortie de la methode");
        return adresse; 	       
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
    	            	a.setVersion(a.getVersion() + 1);
    	            	a.setIdUtilisateur(adresse.getIdUtilisateur());
	            	break;
            	 }
         	 }      
    		    		   
	    	return adresse;
    	}catch(Exception ex) {
    		
    		log.error( "(Fonction updateAdresse)" +  ex.getMessage());
    		return null;
    	}
        
    }

    @Override
    public boolean deleteAdresse(Adresse adresse) {
        listAdresses.remove(adresse);
        log.debug("Sortie de la methode");
        return false;
    }
}
