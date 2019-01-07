/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.array.impl;

import com.cours.allo.docteur.dao.DataSource;
import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.exception.CustomException;
import com.cours.allo.docteur.factory.AbstractDaoFactory;
import com.cours.allo.docteur.factory.ManualArrayDaoFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualArrayAdresseDao extends AbstractArrayDao<Adresse> implements IAdresseDao {

    private static final Log log = LogFactory.getLog(ManualArrayAdresseDao.class);
    private Adresse[] lst_adresse = DataSource.getInstance().getAdressesArrayDataSource();

    private ManualArrayAdresseDao() {
        super(Adresse.class, DataSource.getInstance().getAdressesArrayDataSource());
    }

    private static class SingletonHolder {

        private final static ManualArrayAdresseDao instance = new ManualArrayAdresseDao();
    }

    public static ManualArrayAdresseDao getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public List<Adresse> findAllAdresses() {
        log.debug("findAllAdresses");
        return Arrays.asList(lst_adresse);
    }

    @Override
    public Adresse findAdresseById(int idAdresse) throws CustomException{
      Adresse result = null;

		for (int i = 0; i < lst_adresse.length; i++) {
			if (lst_adresse[i].getIdAdresse().equals(idAdresse)) {
				result = lst_adresse[i];
			}
		}

		if (result == null)
			throw new CustomException("Aucune adresse a l'" + idAdresse, 1);

		return result;
    }

    @Override
    public List<Adresse> findAdressesByVille(String ville) {
        List<Adresse> lst = findAllAdresses();
        List<Adresse> result = new ArrayList<Adresse>();

        for (Adresse u : lst) {
            if (u.getVille().equals(ville)) {
                result.add(u);
            }
        }
        return result;
    }

    @Override
    public List<Adresse> findAdressesByCodePostal(String codePostal) {
        List<Adresse> lst = findAllAdresses();
        List<Adresse> result = new ArrayList<Adresse>();

        for (Adresse u : lst) {
            if (u.getCodePostal().equals(codePostal)) {
                result.add(u);
            }
        }
        return result;
    }

    @Override
    public Adresse createAdresse(Adresse adresse) {
        Adresse[] adresses = new Adresse[lst_adresse.length + 1];

		System.arraycopy(lst_adresse, 0, adresses, 0, lst_adresse.length);
		int lastId;

		lastId = lst_adresse[lst_adresse.length - 1].getIdAdresse();

		adresse.setIdAdresse(lastId + 1);

		adresses[lst_adresse.length] = adresse;

		lst_adresse = adresses.clone();

		return adresse;
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
        try {

            for (int i = 0; i < lst_adresse.length; i++) {
                if (lst_adresse[i].getIdAdresse() == adresse.getIdAdresse()) {
                    lst_adresse[i].setRue(adresse.getRue());
                    lst_adresse[i].setCodePostal(adresse.getCodePostal());
                    lst_adresse[i].setVille(adresse.getVille());
                    lst_adresse[i].setPays(adresse.getPays());
                    lst_adresse[i].setVersion(lst_adresse[i].getVersion() + 1);
                    lst_adresse[i].setIdUtilisateur(adresse.getIdUtilisateur());
                    break;
                }
            }

            return adresse;
        } catch (Exception ex) {

            log.error("(Fonction Array updateAdresse)" + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteAdresse(Adresse adresse) {
        Adresse[] adresses = new Adresse[lst_adresse.length - 1];

		boolean find = false;

		int j = 0;

		for (int i = 0; i < lst_adresse.length; i++) {
			if (lst_adresse[i].getIdAdresse().equals(adresse.getIdAdresse())) {
				find = true;
			} else {
				adresses[j] = lst_adresse[i];
				j++;
			}
		}

		lst_adresse = adresses.clone();

		return find;
    }
}
