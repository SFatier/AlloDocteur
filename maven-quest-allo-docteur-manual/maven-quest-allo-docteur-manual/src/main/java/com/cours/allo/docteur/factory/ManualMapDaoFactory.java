/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.factory;

import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.IUtilisateurDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualMapDaoFactory extends AbstractDaoFactory {

    private static final Log log = LogFactory.getLog(ManualMapDaoFactory.class);
    private IUtilisateurDao utilisateurDao = null;
    private IAdresseDao adresseDao = null;

    private ManualMapDaoFactory() {
        log.debug("--> ************ Initialisation de " + ManualMapDaoFactory.class.getSimpleName() + " ************");
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
