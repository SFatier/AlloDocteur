/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao.impl;

import com.cours.allo.docteur.dao.ConnectionHelper;
import com.cours.allo.docteur.dao.DataSourceSingleton;
import com.cours.allo.docteur.dao.IAdresseDao;
import com.cours.allo.docteur.dao.entities.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class AdresseDao extends AbstractDao<Adresse> implements IAdresseDao {

    private static final Log log = LogFactory.getLog(AdresseDao.class);
    DataSource dataSource = DataSourceSingleton.getInstance().getDataSource();
    private final static String className = AdresseDao.class.getSimpleName();
    private final static String SQL_SELECT_ALL = "SELECT * FROM adresse";
    private final static String SQL_SELECT_BY_ID = "SELECT * FROM adresse WHERE idAdresse = ?";
    private final static String SQL_SELECT_BY_VILLE = "SELECT * FROM adresse WHERE ville=?";
    private final static String SQL_SELECT_BY_CODEPOSTAM = "SELECT * FROM adresse WHERE codePostal=?";
    private final static String SQL_INSERT = "INSERT INTO Adresse(idUtilisateur, rue, codePostal, ville, pays, principale) VALUES (?,?,?,?,?,?)";
    private final static String SQL_SELECT_ORDER = "SELECT * FROM adresse ORDER BY idAdresse DESC LIMIT 1";
    private final static String SQL_UPDATE = "UPDATE Adresse SET rue = ?, codePostal = ?, ville = ?, pays = ?, principale = ?, version = ? WHERE idAdresse = ?";
    private final static String SQL_DELETE = "DELETE FROM adresse WHERE idAdresse=?";
    private AdresseDao() {
        super(Adresse.class);
        log.debug("--> ************ Initialisation de " + className + " ************");
    }

    /**
     * Holder
     */
    private static class MySingletonHolder {

        /**
         * Instance unique non préinitialisée
         */
        private final static AdresseDao instance = new AdresseDao();
    }

    /**
     * Point d'accès pour l'instance unique du singleton
     *
     * @return
     */
    public static AdresseDao getInstance() {
        if (AdresseDao.MySingletonHolder.instance == null) {
            log.debug("--> Nouvelle Instance de " + className);
        } else {
            log.debug("--> Re-Utilisation de l'instance " + className + " dejà existante");
        }
        return AdresseDao.MySingletonHolder.instance;
    }

    @Override
    public List<Adresse> findAllAdresses() {
         List<Adresse> adresses = new ArrayList<>();
        Connection connection;
        try {
            connection = dataSource.getConnection();
            ResultSet result = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    adresses.add(ResulSetAdresse(result));
                }
            } finally {
                ConnectionHelper.closeSqlResources(connection, preparedStatement, result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adresses;
    }

    @Override
    public Adresse findAdresseById(int idAdresse) {
        Adresse adresse = null;
        Connection connection;
        try {
            connection = dataSource.getConnection();
            ResultSet result = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
                preparedStatement.setString(1, String.valueOf(idAdresse));
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    adresse = ResulSetAdresse(result);
                }
            } finally {
                ConnectionHelper.closeSqlResources(connection, preparedStatement, result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adresse;
    }

    @Override
    public List<Adresse> findAdressesByVille(String ville) {
        List<Adresse> adresses = new ArrayList<>();
        Adresse adresse;
        Connection connection;
        try {
            connection = dataSource.getConnection();
            ResultSet result = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(SQL_SELECT_BY_VILLE);
                preparedStatement.setString(1, ville);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    adresses.add(ResulSetAdresse(result));
                }
            } finally {
                ConnectionHelper.closeSqlResources(connection, preparedStatement, result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adresses;
    }

    @Override
    public List<Adresse> findAdressesByCodePostal(String codePostal) {
       List<Adresse> adresses = new ArrayList<>();
        Connection connection;
        try {
            connection = dataSource.getConnection();
            ResultSet result = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(SQL_SELECT_BY_CODEPOSTAM);
                preparedStatement.setString(1, codePostal);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    adresses.add(ResulSetAdresse(result));
                }
            } finally {
                ConnectionHelper.closeSqlResources(connection, preparedStatement, result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adresses;
    }

    @Override
    public Adresse createAdresse(Adresse adresse) {
         Connection connection;
        try {
            connection = dataSource.getConnection();
            ResultSet result = null;
            PreparedStatement preparedStatement = null;
            try {
			preparedStatement = connection.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, adresse.getIdUtilisateur());
			preparedStatement.setString(2, adresse.getRue());
			preparedStatement.setString(3, adresse.getCodePostal());
			preparedStatement.setString(4, adresse.getVille());
			preparedStatement.setString(5, adresse.getPays());
			preparedStatement.setBoolean(6, adresse.isPrincipale());

			preparedStatement.executeUpdate();

			result = preparedStatement.getGeneratedKeys();

			result.next();

			adresse.setIdAdresse(result.getInt(1));
            } finally {
                ConnectionHelper.closeSqlResources(connection, preparedStatement, result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adresse;
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
       Connection connection = null;
     PreparedStatement preparedStatement = null;

		adresse.setVersion(adresse.getVersion() + 1);

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, adresse.getRue());
			preparedStatement.setString(2, adresse.getCodePostal());
			preparedStatement.setString(3, adresse.getVille());
			preparedStatement.setString(4, adresse.getPays());
			preparedStatement.setBoolean(5, adresse.isPrincipale());
			preparedStatement.setInt(6, adresse.getVersion());
			preparedStatement.setInt(7, adresse.getIdAdresse());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			return null;
		} finally {
			ConnectionHelper.closeSqlResources(connection, preparedStatement, null);
		}

		log.debug(adresse.getCodePostal());
		return adresse;
    }

    @Override
    public boolean deleteAdresse(Adresse adresse) {
        Connection connection;
        boolean ret = false;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(SQL_DELETE);
                preparedStatement.setString(1, String.valueOf(adresse.getIdAdresse()));
                int result = preparedStatement.executeUpdate();
                if (result == 1)
                    ret = true;
            } finally {
                ConnectionHelper.closeSqlResources(connection, preparedStatement, null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
        private Adresse ResulSetAdresse(ResultSet result) {
        Adresse adresse = new Adresse();
        try {
            adresse.setIdAdresse(result.getInt("idAdresse"));
            adresse.setRue(result.getString("rue"));
            adresse.setCodePostal(result.getString("codePostal"));
            adresse.setVille(result.getString("ville"));
            adresse.setPays(result.getString("pays"));
            adresse.setPrincipale(result.getBoolean("principale"));
            adresse.setVersion(result.getInt("version"));
            adresse.setIdUtilisateur(result.getInt("idUtilisateur"));
            
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adresse;
}
}
