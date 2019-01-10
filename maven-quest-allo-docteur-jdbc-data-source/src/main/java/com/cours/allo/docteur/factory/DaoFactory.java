/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.factory;

import com.cours.allo.docteur.dao.impl.AdresseDao;
import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.IUtilisateurDao;
import com.cours.allo.docteur.dao.impl.UtilisateurDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class DaoFactory extends AbstractDaoFactory {

    private static final Log log = LogFactory.getLog(DaoFactory.class);
    private final static String className = DaoFactory.class.getSimpleName();
    private IUtilisateurDao utilisateurDao = null;
    private IAdresseDao adresseDao = null;

    private DaoFactory() {
        log.debug("--> ************ Initialisation de " + className + " ************");
        utilisateurDao = UtilisateurDao.getInstance();
        adresseDao = AdresseDao.getInstance();
    }

    /**
     * Holder
     */
    private static class MySingletonHolder {

        /**
         * Instance unique non préinitialisée
         */
        private final static DaoFactory instance = new DaoFactory();
    }

    /**
     * Point d'accès pour l'instance unique du singleton
     *
     * @return
     */
    public static DaoFactory getInstance() {
        if (DaoFactory.MySingletonHolder.instance == null) {
            log.debug("--> Nouvelle Instance de " + className);
        } else {
            log.debug("--> Re-Utilisation de l'instance " + className + " dejà existante ");
        }
        return DaoFactory.MySingletonHolder.instance;
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
