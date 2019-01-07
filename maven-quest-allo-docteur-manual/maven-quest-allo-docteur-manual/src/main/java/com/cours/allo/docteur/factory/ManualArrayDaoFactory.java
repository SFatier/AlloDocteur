/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.factory;

import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.IUtilisateurDao;
import com.cours.allo.docteur.dao.manual.array.impl.ManualArrayAdresseDao;
import com.cours.allo.docteur.dao.manual.array.impl.ManualArrayUtilisateurDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualArrayDaoFactory extends AbstractDaoFactory {

    private static final Log log = LogFactory.getLog(ManualArrayDaoFactory.class);
    private IUtilisateurDao utilisateurDao = null;
    private IAdresseDao adresseDao = null;

    private ManualArrayDaoFactory() {
        log.debug("--> ************ Initialisation de " + ManualArrayDaoFactory.class.getSimpleName() + " ************");
        utilisateurDao = ManualArrayUtilisateurDao.getInstance();
        adresseDao = ManualArrayAdresseDao.getInstance();
    }

    private static class SingletonHolder
    {       
        private final static ManualArrayDaoFactory instance = new ManualArrayDaoFactory();
    }
 
    public static ManualArrayDaoFactory getInstance()
    {
        return SingletonHolder.instance;
    }
    
    @Override
    public IUtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }

    @Override
    public IAdresseDao getAdresseDao() {
        return adresseDao;
    }
}
