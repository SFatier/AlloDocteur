/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao;

import static com.cours.allo.docteur.utils.Constants.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class DataSourceSingleton {

    private static final Log log = LogFactory.getLog(DataSourceSingleton.class);
    public final static String className = DataSourceSingleton.class.getName();
    // Objet DataSource
  //  private DataSource dataSource = ;
    //private BasicDataSource dataSource = null;
    private final BasicDataSource dataSource = new BasicDataSource();

    /**
     * Constructeur privé
     */
    private DataSourceSingleton() {
        String methodName = "MySqlSingleton";
        System.out.println(className + " --> " + methodName + "--> Nouvelle Instance de DataSourceSingleton");
       // dataSource = new BasicDataSource();
        dataSource.setDriverClassName(JDBC_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USER);
        dataSource.setPassword(DATABASE_PASSWORD);
        dataSource.setMaxActive(MAX_CONNEXION);
       
    }

    private static class SingletonHolder {

        private final static DataSourceSingleton instance = new DataSourceSingleton();
    }

    public static DataSourceSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
