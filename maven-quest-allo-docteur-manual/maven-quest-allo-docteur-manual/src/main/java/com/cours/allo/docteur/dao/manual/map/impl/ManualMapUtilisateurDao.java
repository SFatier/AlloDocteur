/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.manual.map.impl;

import com.cours.allo.docteur.dao.DataSource;
import com.cours.allo.docteur.dao.IUtilisateurDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;
import com.cours.allo.docteur.exception.CustomException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class ManualMapUtilisateurDao extends AbstractMapDao<Utilisateur> implements IUtilisateurDao {

    private static final Log log = LogFactory.getLog(ManualMapUtilisateurDao.class);
    private Map<Integer, Utilisateur> lst_utilisateur = DataSource.getInstance().getUtilisateursMapDataSource();

    private ManualMapUtilisateurDao() {
        super(Utilisateur.class, DataSource.getInstance().getUtilisateursMapDataSource());
    }

    private static class SingletonHolder {

        private final static ManualMapUtilisateurDao instance = new ManualMapUtilisateurDao();
    }

    public static ManualMapUtilisateurDao getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return new ArrayList<Utilisateur>(lst_utilisateur.values());
    }

    @Override
    public Utilisateur findUtilisateurById(int idUtilisateur) {
        for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
            if (entry.getValue().getIdUtilisateur().equals(idUtilisateur)) {
                return entry.getValue();
            }
        }

        throw new CustomException(
                "L'utilisateur qui a comme idUtilisateur " + idUtilisateur + " n'existe pas",
                1);
    }

    @Override
    public List<Utilisateur> findUtilisateurByIdentifiant(String identifiant) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
            if (entry.getValue().getIdentifiant().equals(identifiant)) {
                utilisateurs.add(entry.getValue());
            }
            return utilisateurs;
        }

        throw new CustomException(
                "L'utilisateur qui a  comme l'identifiant " + identifiant + " n'existe pas", 1);
    }

    @Override
    public List<Utilisateur> findUtilisateursByPrenom(String prenom) {
        List<Utilisateur> utilisateurs = new ArrayList<>();

        for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
            if (entry.getValue().getPrenom().equals(prenom)) {
                utilisateurs.add(entry.getValue());
            }
        }

        if (utilisateurs.size() == 0) {
            throw new CustomException(
                    "Les utilisateurs qui ont comme prenom " + prenom + " sont introuvable", 1);
        }

        return utilisateurs;
    }

    @Override
    public List<Utilisateur> findUtilisateursByNom(String nom) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
            if (entry.getValue().getNom().equals(nom)) {
                utilisateurs.add(entry.getValue());
            }
        }

        if (utilisateurs.size() == 0) {
            throw new CustomException(
                    "Les utilisateurs qui ont comme nom " + nom + " sont introuvable", 1);
        }

        return utilisateurs;
    }

    @Override
    public List<Utilisateur> findUtilisateursByCodePostal(String codePostal) {
       List<Utilisateur> utilisateurs = new ArrayList<>();
       Iterator<Adresse> iteratorAdresse;
       for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
			iteratorAdresse = entry.getValue().getAdresses().iterator();

			while (iteratorAdresse.hasNext()) {
				if (iteratorAdresse.next().getCodePostal().equals(codePostal)) {
					utilisateurs.add(entry.getValue());
					break;
				}
			}
		}

		if (utilisateurs.size() == 0)
			throw new CustomException(
					  "Les utilisateurs qui ont comme codePostal " + codePostal + " sont introuvable",1);
                return utilisateurs;
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur user) {
      	int Id=0;
		for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
			if (entry.getValue().getIdUtilisateur() > Id)
				Id = entry.getValue().getIdUtilisateur();
		}

		user.setDateCreation(new Date());
		user.setDateModification(new Date());
		user.setIdUtilisateur(Id + 1);

		lst_utilisateur.put(Id + 1, user);

		return user;
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur user) {
        Utilisateur utilisateur = null;
       for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
			if (entry.getValue().getIdUtilisateur().equals(user.getIdUtilisateur())) {
				user.setVersion(user.getVersion() + 1);
				user.setDateModification(new Date());

				entry.setValue(user);
				utilisateur = user;
				break;
			}
		}
		if (utilisateur == null) {
			throw new CustomException(
					  "L'utilisateur portant l'identifiant " + user.getIdentifiant() + " n'existe pas",1);
		}

		return utilisateur;
    }

    @Override
    public boolean deleteUtilisateur(Utilisateur user) {
        boolean b = false;

		for (Map.Entry<Integer, Utilisateur> entry : lst_utilisateur.entrySet()) {
			if (entry.getValue().equals(user)) {
				lst_utilisateur.remove(entry.getKey(), entry.getValue());
				b = true;
				break;
			}
		}

		if (b == false) {
			throw new CustomException(
					  "L'utilisateur portant l'identifiant " + user.getIdentifiant() + " n'existe pas",1);
		}

		return b;
       
    }
}
