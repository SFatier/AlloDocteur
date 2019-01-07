package com.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class JUnitDao {

    private static final Log log = LogFactory.getLog(JUnitDao.class);

    @BeforeClass
    public static void init() throws Exception {
        JUnitQuestAlloDocteurArray junitArray = new JUnitQuestAlloDocteurArray();
        JUnitQuestAlloDocteurMap junitMap = new JUnitQuestAlloDocteurMap();
        JUnitQuestAlloDocteurList junitList = new JUnitQuestAlloDocteurList();

        junitArray.testFindAllAdresses();
        junitArray.testFindAllUtilisateurs();
        junitArray.testFindByCriteria();
        junitArray.testCreateUpdateDeleteAdresse();
        junitArray.testCreateUpdateDeleteUtilisateur();

        junitMap.testFindAllAdresses();
        junitMap.testFindAllUtilisateurs();
        junitMap.testFindByCriteria();
        junitMap.testCreateUpdateDeleteAdresse();
        junitMap.testCreateUpdateDeleteUtilisateur();

        junitList.testFindAllAdresses();
        junitList.testFindAllUtilisateurs();
        junitList.testFindByCriteria();
        junitList.testCreateUpdateDeleteAdresse();
        junitList.testCreateUpdateDeleteUtilisateur();
    }

    @AfterClass
    public static void terminate() throws Exception {
         log.debug("Terminate");
    }
}
