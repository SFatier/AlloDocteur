/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose DaoHelper | Templates
 * and open the template in the editor.
 */
package com.cours.allo.docteur.dao;

import com.cours.allo.docteur.dao.entities.Adresse;
import com.cours.allo.docteur.dao.entities.Utilisateur;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ElHadji
 */
public class DataSource {

    private static final Log log = LogFactory.getLog(DataSource.class);
    private List<Adresse> adressesListDataSource = null;
    private List<Utilisateur> utilisateursListDataSource = null;
    private Adresse[] adressesArrayDataSource = null;
    private Utilisateur[] utilisateursArrayDataSource = null;
    private Map<Integer, Adresse> adressesMapDataSource = null;
    private Map<Integer, Utilisateur> utilisateursMapDataSource = null;

    private DataSource() {
        log.debug("--> ************ Initialisation de " + DataSource.class.getSimpleName() + " ************");
        adressesListDataSource = initAdressesListDataSource();
        utilisateursListDataSource = initUtilisateursListDataSource();
        adressesArrayDataSource = initAdressesArrayDataSource();
        utilisateursArrayDataSource = initUtilisateursArrayDataSource();
        adressesMapDataSource = initAdressesMapDataSource();
        utilisateursMapDataSource = initUtilisateursMapDataSource();
    }

    /**
     * Holder
     */
    private static class MySingletonHolder {

        /**
         * Instance unique non préinitialisée
         */
        private final static DataSource instance = new DataSource();
    }

    /**
     * Point d'accès pour l'instance unique du singleton
     *
     * @return
     */
    public static DataSource getInstance() {
        String methodName = "getInstance";
        if (DataSource.MySingletonHolder.instance == null) {
            log.debug("--> Nouvelle Instance de " + DataSource.class.getSimpleName());
        } else {
            log.debug("--> Re-Utilisation de l'instance " + DataSource.class.getSimpleName() + " dejà existante ");
        }
        return DataSource.MySingletonHolder.instance;
    }

    private List<Adresse> initAdressesListDataSource() {
        return new ArrayList<Adresse>(Arrays.asList(
                new Adresse(1, "5 rue du Paradis", "75000", "Paris", "France"),
                new Adresse(2, "60 rue des faveurs", "44000", "Nantes", "France"),
                new Adresse(3, "66 rue des deportés", "35000", "Rennes", "France"),
                new Adresse(4, "9 rue de la liberté", "75000", "Paris", "France"),
                new Adresse(5, "55 rue de la mer", "87000", "Limoges", "France"),
                new Adresse(6, "44 rue du Paradis ", "76000", "Rouen", "France"),
                new Adresse(7, "5 rue de maupassant", "75000", "Paris", "France"),
                new Adresse(8, "33 rue des fauves", "76000", "Rouen", "France"),
                new Adresse(9, "66 rue des Saint", "35000", "Rennes", "France"),
                new Adresse(10, "44 rue du General Patton", "75000", "Paris", "France"),
                new Adresse(11, "5 rue de la paix", "44000", "Nantes", "France"),
                new Adresse(12, "7 rue des Sages", "75000", "Paris", "France"),
                new Adresse(13, "15 rue des heureux", "35000", "Rennes", "France"),
                new Adresse(14, "66 rue des ingenieurs", "69000", "Lyon", "France"),
                new Adresse(15, "7 rue des peurs", "35000", "Rennes", "France"),
                new Adresse(16, "39 rue du Lion", "44000", "Nantes", "France"),
                new Adresse(17, "5 rue de Maupassant", "75000", "Paris", "France"),
                new Adresse(18, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(19, "66 rue des deportés", "35000", "Rennes", "France"),
                new Adresse(20, "5 rue de Maupassant", "44000", "Nantes", "France"),
                new Adresse(21, "7 rue du Christ", "76000", "Rouen", "France"),
                new Adresse(22, "6 rue de la chance", "75000", "Paris", "France"),
                new Adresse(23, "5 rue du pouvoir", "44000", "Nantes", "France"),
                new Adresse(24, "7 rue des reveurs", "35000", "Rennes", "France"),
                new Adresse(25, "7 rue des artisans", "53000", "Laval", "France"),
                new Adresse(26, "5 rue du Maroc", "75000", "Paris", "France"),
                new Adresse(27, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(28, "7 rue de Napoleon", "87000", "Limoges", "France"),
                new Adresse(29, "66 rue de Pologne", "75000", "Paris", "France"),
                new Adresse(30, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(31, "50 rue du General Patton", "76000", "Rouen", "France"),
                new Adresse(32, "5 rue de Saint George", "75000", "Paris", "France"),
                new Adresse(33, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(34, "6 rue des enseignants", "44000", "Nantes", "France"),
                new Adresse(35, "5 rue de Dagobert", "75000", "Paris", "France"),
                new Adresse(36, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(37, "9 rue de la liberté", "44000", "Nantes", "France"),
                new Adresse(38, "35 rue du coeur", "75000", "Paris", "France"),
                new Adresse(39, "32 rue de la mer", "87000", "Limoges", "France"),
                new Adresse(40, "5 rue de la misericorde", "75000", "Paris", "France"),
                new Adresse(41, "17 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(42, "44 rue de la charité", "53000", "Laval", "France"),
                new Adresse(43, "5 rue du General Patton", "75000", "Paris", "France"),
                new Adresse(44, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(45, "44 rue du General Patton", "53000", "Laval", "France"),
                new Adresse(46, "5 rue des enseignants", "75000", "Paris", "France"),
                new Adresse(47, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(48, "10 rue des heureux", "72000", "Le Mans", "France"),
                new Adresse(49, "5 rue de Saint Sens", "44000", "Nantes", "France"),
                new Adresse(50, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(51, "10 rue de Saint Christophe", "72000", "Le Mans", "France"),
                new Adresse(52, "5 rue de Maupassant", "75000", "Paris", "France"),
                new Adresse(53, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(54, "55 rue du desert", "35000", "Rennes", "France"),
                new Adresse(55, "5 rue de Maupassant", "75000", "Paris", "France"),
                new Adresse(56, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(57, "15 rue de la paix", "53000", "Laval", "France"),
                new Adresse(58, "57 rue du desert", "75000", "Paris", "France"),
                new Adresse(59, "5 rue de Maupassant", "35000", "Rennes", "France"),
                new Adresse(60, "50 rue du passant ", "75000", "Paris", "France"),
                new Adresse(61, "5 rue de la Tasse", "75000", "Paris", "France"),
                new Adresse(62, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(63, "10 rue de la misericorde", "72000", "Le Mans", "France"),
                new Adresse(64, "5 rue des etranges", "75000", "Paris", "France"),
                new Adresse(65, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(66, "5 rue de Maupassant", "75000", "Paris", "France"),
                new Adresse(67, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(68, "50 rue du bien", "69000", "Lyon", "France"),
                new Adresse(69, "5 rue de Maurice", "75000", "Paris", "France"),
                new Adresse(70, "7 rue des Belges", "35000", "Rennes", "France"),
                new Adresse(71, "33 rue des passeurs", "75000", "Paris", "France"),
                new Adresse(72, "5 rue de Gaubert", "75000", "Paris", "France"),
                new Adresse(73, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(74, "46 rue du Général De Gaule", "44000", "Nantes", "France"),
                new Adresse(75, "5 rue de Jacques Lambert", "76000", "Rouen", "France"),
                new Adresse(76, "7 rue des passeurs", "35000", "Rennes", "France"),
                new Adresse(77, "46 rue du Général De Gaule", "35000", "Rennes", "France"),
                new Adresse(78, "5 rue de Nicolas Gaz", "75000", "Paris", "France"),
                new Adresse(79, "54 rue des passeurs", "69000", "Lyon", "France"),
                new Adresse(80, "10 rue des etrangers", "35000", "Rennes", "France"),
                new Adresse(81, "5 rue des Maux", "75000", "Paris", "France"),
                new Adresse(82, "7 rue des passeurs", "35000", "Rennes", "France")));
    }

    private List<Utilisateur> initUtilisateursListDataSource() {
        return new ArrayList<Utilisateur>(Arrays.asList(
                new Utilisateur(1, "Mr", "Jerome", "Cantin", "admin@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(1, "5 rue du Paradis", "75000", "Paris", "France", true, 1),
                                        new Adresse(2, "60 rue des faveurs", "44000", "Nantes", "France", 1),
                                        new Adresse(3, "66 rue des deportés", "35000", "Rennes", "France", 1)))),
                new Utilisateur(2, "Mr", "Nicolas", "Petit", "nicolas.petit@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(4, "9 rue de la liberté", "75000", "Paris", "France", true, 2),
                                        new Adresse(5, "55 rue de la mer", "87000", "Limoges", "France", 2),
                                        new Adresse(6, "44 rue du Paradis ", "76000", "Rouen", "France", 2)))),
                new Utilisateur(3, "Mr", "Jerome", "Leduc", "jerome@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(7, "5 rue de maupassant", "75000", "Paris", "France", true, 3),
                                        new Adresse(8, "33 rue des fauves", "76000", "Rouen", "France", 3),
                                        new Adresse(9, "66 rue des Saint", "35000", "Rennes", "France", 3)))),
                new Utilisateur(4, "Mr", "Dimitry", "Gozin", "dimitry.gozin@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(10, "44 rue du General Patton", "75000", "Paris", "France", true, 4),
                                        new Adresse(11, "5 rue de la paix", "44000", "Nantes", "France", 4),
                                        new Adresse(12, "7 rue des Sages", "75000", "Paris", "France", 4)))),
                new Utilisateur(5, "Mme", "Louise", "Correa", "luise@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(13, "15 rue des heureux", "35000", "Rennes", "France", true, 5),
                                        new Adresse(14, "66 rue des ingenieurs", "69000", "Lyon", "France", 5),
                                        new Adresse(15, "7 rue des peurs", "35000", "Rennes", "France", 5)))),
                new Utilisateur(6, "Mr", "Nicolas", "Gerard", "nicolas.gerard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(16, "39 rue du Lion", "44000", "Nantes", "France", true, 6),
                                        new Adresse(17, "5 rue de Maupassant", "75000", "Paris", "France", 6),
                                        new Adresse(18, "7 rue des passeurs", "35000", "Rennes", "France", 6)))),
                new Utilisateur(7, "Mr", "Remy", "Collard", "remy.collard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(19, "66 rue des deportés", "35000", "Rennes", "France", true, 7),
                                        new Adresse(20, "5 rue de Maupassant", "44000", "Nantes", "France", 7),
                                        new Adresse(21, "7 rue du Christ", "76000", "Rouen", "France", 7)))),
                new Utilisateur(8, "Mr", "Vincent", "Ducan", "vincent.ducamp@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(22, "6 rue de la chance", "75000", "Paris", "France", true, 8),
                                        new Adresse(23, "5 rue du pouvoir", "44000", "Nantes", "France", 8),
                                        new Adresse(24, "7 rue des reveurs", "35000", "Rennes", "France", 8)))),
                new Utilisateur(9, "Mme", "Claire", "Dupond", "claire.dupond@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(25, "7 rue des artisans", "53000", "Laval", "France", true, 9),
                                        new Adresse(26, "5 rue du Maroc", "75000", "Paris", "France", 9),
                                        new Adresse(27, "7 rue des passeurs", "35000", "Rennes", "France", 9)))),
                new Utilisateur(10, "Mme", "Stephanie", "Job", "stephanie.job@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(28, "7 rue de Napoleon", "87000", "Limoges", "France", true, 10),
                                        new Adresse(29, "66 rue de Pologne", "75000", "Paris", "France", 10),
                                        new Adresse(30, "7 rue des passeurs", "35000", "Rennes", "France", 10)))),
                new Utilisateur(11, "Mme", "Celine", "Premier", "celine.premier@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(31, "50 rue du General Patton", "76000", "Rouen", "France", true, 11),
                                        new Adresse(32, "5 rue de Saint George", "75000", "Paris", "France", 11),
                                        new Adresse(33, "7 rue des passeurs", "35000", "Rennes", "France", 11)))),
                new Utilisateur(12, "Mr", "Jean", "Marchand", "jean.marchand@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(34, "6 rue des enseignants", "44000", "Nantes", "France", true, 12),
                                        new Adresse(35, "5 rue de Dagobert", "75000", "Paris", "France", 12),
                                        new Adresse(36, "7 rue des passeurs", "35000", "Rennes", "France", 12)))),
                new Utilisateur(13, "Mr", "Nicolas", "Petit", "nicolas.petit@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(37, "9 rue de la liberté", "44000", "Nantes", "France", true, 13),
                                        new Adresse(38, "35 rue du coeur", "75000", "Paris", "France", 13)))),
                new Utilisateur(14, "Mr", "Patrick", "Leduc", "patric.leduc@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(39, "32 rue de la mer", "87000", "Limoges", "France", true, 14),
                                        new Adresse(40, "5 rue de la misericorde", "75000", "Paris", "France", 14),
                                        new Adresse(41, "17 rue des passeurs", "35000", "Rennes", "France", 14)))),
                new Utilisateur(15, "Mr", "Malick", "Ba", "malick.ba@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(42, "44 rue de la charité", "53000", "Laval", "France", true, 15),
                                        new Adresse(43, "5 rue du General Patton", "75000", "Paris", "France", 15),
                                        new Adresse(44, "7 rue des passeurs", "35000", "Rennes", "France", 15)))),
                new Utilisateur(16, "Mr", "Erwan", "Free", "erwan.free@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(45, "44 rue du General Patton", "53000", "Laval", "France", true, 16),
                                        new Adresse(46, "5 rue des enseignants", "75000", "Paris", "France", 16),
                                        new Adresse(47, "7 rue des passeurs", "35000", "Rennes", "France", 16)))),
                new Utilisateur(17, "Mr", "Marc", "Lambert", "marc.lambert@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(48, "10 rue des heureux", "72000", "Le Mans", "France", true, 17),
                                        new Adresse(49, "5 rue de Saint Sens", "44000", "Nantes", "France", 17),
                                        new Adresse(50, "7 rue des passeurs", "35000", "Rennes", "France", 17)))),
                new Utilisateur(18, "Mme", "France", "Lebon", "france.lebon@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(51, "10 rue de Saint Christophe", "72000", "Le Mans", "France", true, 18),
                                        new Adresse(52, "5 rue de Maupassant", "75000", "Paris", "France", 18),
                                        new Adresse(53, "7 rue des passeurs", "35000", "Rennes", "France", 18)))),
                new Utilisateur(19, "Mr", "Francis", "Garry", "francis.garry@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(54, "55 rue du desert", "35000", "Rennes", "France", true, 19),
                                        new Adresse(55, "5 rue de Maupassant", "75000", "Paris", "France", 19),
                                        new Adresse(56, "7 rue des passeurs", "35000", "Rennes", "France", 19)))),
                new Utilisateur(20, "Mr", "Thierry", "Garon", "thierry.garon@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(57, "15 rue de la paix", "53000", "Laval", "France", true, 20),
                                        new Adresse(58, "57 rue du desert", "75000", "Paris", "France", 20),
                                        new Adresse(59, "5 rue de Maupassant", "35000", "Rennes", "France", 20)))),
                new Utilisateur(21, "Mme", "Fatou", "Diop", "fatou.diop@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(60, "50 rue du passant ", "75000", "Paris", "France", true, 21),
                                        new Adresse(61, "5 rue de la Tasse", "75000", "Paris", "France", 21),
                                        new Adresse(62, "7 rue des passeurs", "35000", "Rennes", "France", 21)))),
                new Utilisateur(22, "Mme", "Fatima", "Salam", "fatima.salam@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(63, "10 rue de la misericorde", "72000", "Le Mans", "France", true, 22),
                                        new Adresse(64, "5 rue des etranges", "75000", "Paris", "France", 22),
                                        new Adresse(65, "7 rue des passeurs", "35000", "Rennes", "France", 22)))),
                new Utilisateur(23, "Mr", "Jean", "Dasilva", "jean.dasilva@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(
                                        new Adresse(66, "5 rue de Maupassant", "75000", "Paris", "France", 23),
                                        new Adresse(67, "7 rue des passeurs", "35000", "Rennes", "France", 23)))),
                new Utilisateur(24, "Mr", "Kemi", "Bazare", "kemi.bazare@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(68, "50 rue du bien", "69000", "Lyon", "France", true, 24),
                                        new Adresse(69, "5 rue de Maurice", "75000", "Paris", "France", 24),
                                        new Adresse(70, "7 rue des Belges", "35000", "Rennes", "France", 24)))),
                new Utilisateur(25, "Mr", "Thibault", "Levrard", "thibault.levrard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(71, "33 rue des passeurs", "75000", "Paris", "France", true, 25),
                                        new Adresse(72, "5 rue de Gaubert", "75000", "Paris", "France", 25),
                                        new Adresse(73, "7 rue des passeurs", "35000", "Rennes", "France", 25)))),
                new Utilisateur(26, "Mr", "Michael", "Joo", "michael.joo@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(74, "46 rue du Général De Gaule", "44000", "Nantes", "France", true, 26),
                                        new Adresse(75, "5 rue de Jacques Lambert", "76000", "Rouen", "France", 26),
                                        new Adresse(76, "7 rue des passeurs", "35000", "Rennes", "France", 26)))),
                new Utilisateur(27, "Mr", "Lionnel", "Richie", "lionnel.richie@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(77, "46 rue du Général De Gaule", "35000", "Rennes", "France", true, 27),
                                        new Adresse(78, "5 rue de Nicolas Gaz", "75000", "Paris", "France", 27),
                                        new Adresse(79, "54 rue des passeurs", "69000", "Lyon", "France", 27)))),
                new Utilisateur(28, "Mr", "Maurice", "Green", "maurice.green@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(80, "10 rue des etrangers", "35000", "Rennes", "France", true, 28),
                                        new Adresse(81, "5 rue des Maux", "75000", "Paris", "France", 28),
                                        new Adresse(82, "7 rue des passeurs", "35000", "Rennes", "France", 28))))));
    }

    private Map<Integer, Adresse> initAdressesMapDataSource() {
        Map<Integer, Adresse> mapAdressesDataSource = new HashMap<Integer, Adresse>();
        mapAdressesDataSource.put(1, new Adresse(1, "5 rue du Paradis", "75000", "Paris", "France"));
        mapAdressesDataSource.put(2, new Adresse(2, "60 rue des faveurs", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(3, new Adresse(3, "66 rue des deportés", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(4, new Adresse(4, "9 rue de la liberté", "75000", "Paris", "France"));
        mapAdressesDataSource.put(5, new Adresse(5, "55 rue de la mer", "87000", "Limoges", "France"));

        mapAdressesDataSource.put(6, new Adresse(6, "44 rue du Paradis ", "76000", "Rouen", "France"));
        mapAdressesDataSource.put(7, new Adresse(7, "5 rue de maupassant", "75000", "Paris", "France"));
        mapAdressesDataSource.put(8, new Adresse(8, "33 rue des fauves", "76000", "Rouen", "France"));
        mapAdressesDataSource.put(9, new Adresse(9, "66 rue des Saint", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(10, new Adresse(10, "44 rue du General Patton", "75000", "Paris", "France"));

        mapAdressesDataSource.put(11, new Adresse(11, "5 rue de la paix", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(12, new Adresse(12, "7 rue des Sages", "75000", "Paris", "France"));
        mapAdressesDataSource.put(13, new Adresse(13, "15 rue des heureux", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(14, new Adresse(14, "66 rue des ingenieurs", "69000", "Lyon", "France"));
        mapAdressesDataSource.put(15, new Adresse(15, "7 rue des peurs", "35000", "Rennes", "France"));

        mapAdressesDataSource.put(16, new Adresse(16, "39 rue du Lion", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(17, new Adresse(17, "5 rue de Maupassant", "75000", "Paris", "France"));
        mapAdressesDataSource.put(18, new Adresse(18, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(19, new Adresse(19, "66 rue des deportés", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(20, new Adresse(20, "5 rue de Maupassant", "44000", "Nantes", "France"));

        mapAdressesDataSource.put(21, new Adresse(21, "7 rue du Christ", "76000", "Rouen", "France"));
        mapAdressesDataSource.put(22, new Adresse(22, "6 rue de la chance", "75000", "Paris", "France"));
        mapAdressesDataSource.put(23, new Adresse(23, "5 rue du pouvoir", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(24, new Adresse(24, "7 rue des reveurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(25, new Adresse(25, "7 rue des artisans", "53000", "Laval", "France"));

        mapAdressesDataSource.put(26, new Adresse(26, "5 rue du Maroc", "75000", "Paris", "France"));
        mapAdressesDataSource.put(27, new Adresse(27, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(28, new Adresse(28, "7 rue de Napoleon", "87000", "Limoges", "France"));
        mapAdressesDataSource.put(29, new Adresse(29, "66 rue de Pologne", "75000", "Paris", "France"));
        mapAdressesDataSource.put(30, new Adresse(30, "7 rue des passeurs", "35000", "Rennes", "France"));

        mapAdressesDataSource.put(31, new Adresse(31, "50 rue du General Patton", "76000", "Rouen", "France"));
        mapAdressesDataSource.put(32, new Adresse(32, "5 rue de Saint George", "75000", "Paris", "France"));
        mapAdressesDataSource.put(33, new Adresse(33, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(34, new Adresse(34, "6 rue des enseignants", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(35, new Adresse(35, "5 rue de Dagobert", "75000", "Paris", "France"));

        mapAdressesDataSource.put(36, new Adresse(36, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(37, new Adresse(37, "9 rue de la liberté", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(38, new Adresse(38, "35 rue du coeur", "75000", "Paris", "France"));
        mapAdressesDataSource.put(39, new Adresse(39, "32 rue de la mer", "87000", "Limoges", "France"));
        mapAdressesDataSource.put(40, new Adresse(40, "5 rue de la misericorde", "75000", "Paris", "France"));

        mapAdressesDataSource.put(41, new Adresse(41, "17 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(42, new Adresse(42, "44 rue de la charité", "53000", "Laval", "France"));
        mapAdressesDataSource.put(43, new Adresse(43, "5 rue du General Patton", "75000", "Paris", "France"));
        mapAdressesDataSource.put(44, new Adresse(44, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(45, new Adresse(45, "44 rue du General Patton", "53000", "Laval", "France"));

        mapAdressesDataSource.put(46, new Adresse(46, "5 rue des enseignants", "75000", "Paris", "France"));
        mapAdressesDataSource.put(47, new Adresse(47, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(48, new Adresse(48, "10 rue des heureux", "72000", "Le Mans", "France"));
        mapAdressesDataSource.put(49, new Adresse(49, "5 rue de Saint Sens", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(50, new Adresse(50, "7 rue des passeurs", "35000", "Rennes", "France"));

        mapAdressesDataSource.put(51, new Adresse(51, "10 rue de Saint Christophe", "72000", "Le Mans", "France"));
        mapAdressesDataSource.put(52, new Adresse(52, "5 rue de Maupassant", "75000", "Paris", "France"));
        mapAdressesDataSource.put(53, new Adresse(53, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(54, new Adresse(54, "55 rue du desert", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(55, new Adresse(55, "5 rue de Maupassant", "75000", "Paris", "France"));

        mapAdressesDataSource.put(56, new Adresse(56, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(57, new Adresse(57, "15 rue de la paix", "53000", "Laval", "France"));
        mapAdressesDataSource.put(58, new Adresse(58, "57 rue du desert", "75000", "Paris", "France"));
        mapAdressesDataSource.put(59, new Adresse(59, "5 rue de Maupassant", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(60, new Adresse(60, "50 rue du passant ", "75000", "Paris", "France"));

        mapAdressesDataSource.put(61, new Adresse(61, "5 rue de la Tasse", "75000", "Paris", "France"));
        mapAdressesDataSource.put(62, new Adresse(62, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(63, new Adresse(63, "10 rue de la misericorde", "72000", "Le Mans", "France"));
        mapAdressesDataSource.put(64, new Adresse(64, "5 rue des etranges", "75000", "Paris", "France"));
        mapAdressesDataSource.put(65, new Adresse(65, "7 rue des passeurs", "35000", "Rennes", "France"));

        mapAdressesDataSource.put(66, new Adresse(66, "5 rue de Maupassant", "75000", "Paris", "France"));
        mapAdressesDataSource.put(67, new Adresse(67, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(68, new Adresse(68, "50 rue du bien", "69000", "Lyon", "France"));
        mapAdressesDataSource.put(69, new Adresse(69, "5 rue de Maurice", "75000", "Paris", "France"));
        mapAdressesDataSource.put(70, new Adresse(70, "7 rue des Belges", "35000", "Rennes", "France"));

        mapAdressesDataSource.put(71, new Adresse(71, "33 rue des passeurs", "75000", "Paris", "France"));
        mapAdressesDataSource.put(72, new Adresse(72, "5 rue de Gaubert", "75000", "Paris", "France"));
        mapAdressesDataSource.put(73, new Adresse(73, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(74, new Adresse(74, "46 rue du Général De Gaule", "44000", "Nantes", "France"));
        mapAdressesDataSource.put(75, new Adresse(75, "5 rue de Jacques Lambert", "76000", "Rouen", "France"));

        mapAdressesDataSource.put(76, new Adresse(76, "7 rue des passeurs", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(77, new Adresse(77, "46 rue du Général De Gaule", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(78, new Adresse(78, "5 rue de Nicolas Gaz", "75000", "Paris", "France"));
        mapAdressesDataSource.put(79, new Adresse(79, "54 rue des passeurs", "69000", "Lyon", "France"));
        mapAdressesDataSource.put(80, new Adresse(80, "10 rue des etrangers", "35000", "Rennes", "France"));
        mapAdressesDataSource.put(81, new Adresse(81, "5 rue des Maux", "75000", "Paris", "France"));
        mapAdressesDataSource.put(82, new Adresse(82, "7 rue des passeurs", "35000", "Rennes", "France"));

        return mapAdressesDataSource;
    }

    private Map<Integer, Utilisateur> initUtilisateursMapDataSource() {
        Map<Integer, Utilisateur> mapDataSourceUtilisateurs = new HashMap<Integer, Utilisateur>();
        mapDataSourceUtilisateurs.put(1, new Utilisateur(1, "Mr", "Jerome", "Cantin", "admin@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(1, "5 rue du Paradis", "75000", "Paris", "France", true, 1),
                new Adresse(2, "60 rue des faveurs", "44000", "Nantes", "France", 1),
                new Adresse(3, "66 rue des deportés", "35000", "Rennes", "France", 1)))));
        mapDataSourceUtilisateurs.put(2, new Utilisateur(2, "Mr", "Nicolas", "Petit", "nicolas.petit@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(4, "9 rue de la liberté", "75000", "Paris", "France", true, 2),
                new Adresse(5, "55 rue de la mer", "87000", "Limoges", "France", 2),
                new Adresse(6, "44 rue du Paradis ", "76000", "Rouen", "France", 2)))));
        mapDataSourceUtilisateurs.put(3, new Utilisateur(3, "Mr", "Jerome", "Leduc", "jerome@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(7, "5 rue de maupassant", "75000", "Paris", "France", true, 3),
                new Adresse(8, "33 rue des fauves", "76000", "Rouen", "France", 3),
                new Adresse(9, "66 rue des Saint", "35000", "Rennes", "France", 3)))));
        mapDataSourceUtilisateurs.put(4, new Utilisateur(4, "Mr", "Dimitry", "Gozin", "dimitry.gozin@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(10, "44 rue du General Patton", "75000", "Paris", "France", true, 4),
                new Adresse(11, "5 rue de la paix", "44000", "Nantes", "France", 4),
                new Adresse(12, "7 rue des Sages", "75000", "Paris", "France", 4)))));
        mapDataSourceUtilisateurs.put(5, new Utilisateur(5, "Mme", "Louise", "Correa", "luise@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(13, "15 rue des heureux", "35000", "Rennes", "France", true, 5),
                new Adresse(14, "66 rue des ingenieurs", "69000", "Lyon", "France", 5),
                new Adresse(15, "7 rue des peurs", "35000", "Rennes", "France", 5)))));
        mapDataSourceUtilisateurs.put(6, new Utilisateur(6, "Mr", "Nicolas", "Gerard", "nicolas.gerard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(16, "39 rue du Lion", "44000", "Nantes", "France", true, 6),
                new Adresse(17, "5 rue de Maupassant", "75000", "Paris", "France", 6),
                new Adresse(18, "7 rue des passeurs", "35000", "Rennes", "France", 6)))));
        mapDataSourceUtilisateurs.put(7, new Utilisateur(7, "Mr", "Remy", "Collard", "remy.collard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(19, "66 rue des deportés", "35000", "Rennes", "France", true, 7),
                new Adresse(20, "5 rue de Maupassant", "44000", "Nantes", "France", 7),
                new Adresse(21, "7 rue du Christ", "76000", "Rouen", "France", 7)))));
        mapDataSourceUtilisateurs.put(8, new Utilisateur(8, "Mr", "Vincent", "Ducan", "vincent.ducamp@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(22, "6 rue de la chance", "75000", "Paris", "France", true, 8),
                new Adresse(23, "5 rue du pouvoir", "44000", "Nantes", "France", 8),
                new Adresse(24, "7 rue des reveurs", "35000", "Rennes", "France", 8)))));
        mapDataSourceUtilisateurs.put(9, new Utilisateur(9, "Mme", "Claire", "Dupond", "claire.dupond@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(25, "7 rue des artisans", "53000", "Laval", "France", true, 9),
                new Adresse(26, "5 rue du Maroc", "75000", "Paris", "France", 9),
                new Adresse(27, "7 rue des passeurs", "35000", "Rennes", "France", 9)))));
        mapDataSourceUtilisateurs.put(10, new Utilisateur(10, "Mme", "Stephanie", "Job", "stephanie.job@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(28, "7 rue de Napoleon", "87000", "Limoges", "France", true, 10),
                new Adresse(29, "66 rue de Pologne", "75000", "Paris", "France", 10),
                new Adresse(30, "7 rue des passeurs", "35000", "Rennes", "France", 10)))));
        mapDataSourceUtilisateurs.put(11, new Utilisateur(11, "Mme", "Celine", "Premier", "celine.premier@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(31, "50 rue du General Patton", "76000", "Rouen", "France", true, 11),
                new Adresse(32, "5 rue de Saint George", "75000", "Paris", "France", 11),
                new Adresse(33, "7 rue des passeurs", "35000", "Rennes", "France", 11)))));
        mapDataSourceUtilisateurs.put(12, new Utilisateur(12, "Mr", "Jean", "Marchand", "jean.marchand@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(34, "6 rue des enseignants", "44000", "Nantes", "France", true, 12),
                new Adresse(35, "5 rue de Dagobert", "75000", "Paris", "France", 12),
                new Adresse(36, "7 rue des passeurs", "35000", "Rennes", "France", 12)))));
        mapDataSourceUtilisateurs.put(13, new Utilisateur(13, "Mr", "Nicolas", "Petit", "nicolas.petit@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(37, "9 rue de la liberté", "44000", "Nantes", "France", true, 13),
                new Adresse(38, "35 rue du coeur", "75000", "Paris", "France", 13)))));
        mapDataSourceUtilisateurs.put(14, new Utilisateur(14, "Mr", "Patrick", "Leduc", "patric.leduc@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(39, "32 rue de la mer", "87000", "Limoges", "France", true, 14),
                new Adresse(40, "5 rue de la misericorde", "75000", "Paris", "France", 14),
                new Adresse(41, "17 rue des passeurs", "35000", "Rennes", "France", 14)))));
        mapDataSourceUtilisateurs.put(15, new Utilisateur(15, "Mr", "Malick", "Ba", "malick.ba@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(42, "44 rue de la charité", "53000", "Laval", "France", true, 15),
                new Adresse(43, "5 rue du General Patton", "75000", "Paris", "France", 15),
                new Adresse(44, "7 rue des passeurs", "35000", "Rennes", "France", 15)))));
        mapDataSourceUtilisateurs.put(16, new Utilisateur(16, "Mr", "Erwan", "Free", "erwan.free@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(45, "44 rue du General Patton", "53000", "Laval", "France", true, 16),
                new Adresse(46, "5 rue des enseignants", "75000", "Paris", "France", 16),
                new Adresse(47, "7 rue des passeurs", "35000", "Rennes", "France", 16)))));
        mapDataSourceUtilisateurs.put(17, new Utilisateur(17, "Mr", "Marc", "Lambert", "marc.lambert@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(48, "10 rue des heureux", "72000", "Le Mans", "France", true, 17),
                new Adresse(49, "5 rue de Saint Sens", "44000", "Nantes", "France", 17),
                new Adresse(50, "7 rue des passeurs", "35000", "Rennes", "France", 17)))));
        mapDataSourceUtilisateurs.put(18, new Utilisateur(18, "Mme", "France", "Lebon", "france.lebon@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(51, "10 rue de Saint Christophe", "72000", "Le Mans", "France", true, 18),
                new Adresse(52, "5 rue de Maupassant", "75000", "Paris", "France", 18),
                new Adresse(53, "7 rue des passeurs", "35000", "Rennes", "France", 18)))));
        mapDataSourceUtilisateurs.put(19, new Utilisateur(19, "Mr", "Francis", "Garry", "francis.garry@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(54, "55 rue du desert", "35000", "Rennes", "France", true, 19),
                new Adresse(55, "5 rue de Maupassant", "75000", "Paris", "France", 19),
                new Adresse(56, "7 rue des passeurs", "35000", "Rennes", "France", 19)))));
        mapDataSourceUtilisateurs.put(20, new Utilisateur(20, "Mr", "Thierry", "Garon", "thierry.garon@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(57, "15 rue de la paix", "53000", "Laval", "France", true, 20),
                new Adresse(58, "57 rue du desert", "75000", "Paris", "France", 20),
                new Adresse(59, "5 rue de Maupassant", "35000", "Rennes", "France", 20)))));
        mapDataSourceUtilisateurs.put(21, new Utilisateur(21, "Mme", "Fatou", "Diop", "fatou.diop@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(60, "50 rue du passant ", "75000", "Paris", "France", true, 21),
                new Adresse(61, "5 rue de la Tasse", "75000", "Paris", "France", 21),
                new Adresse(62, "7 rue des passeurs", "35000", "Rennes", "France", 21)))));
        mapDataSourceUtilisateurs.put(22, new Utilisateur(22, "Mme", "Fatima", "Salam", "fatima.salam@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(63, "10 rue de la misericorde", "72000", "Le Mans", "France", true, 22),
                new Adresse(64, "5 rue des etranges", "75000", "Paris", "France", 22),
                new Adresse(65, "7 rue des passeurs", "35000", "Rennes", "France", 22)))));
        mapDataSourceUtilisateurs.put(23, new Utilisateur(23, "Mr", "Jean", "Dasilva", "jean.dasilva@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(
                new Adresse(66, "5 rue de Maupassant", "75000", "Paris", "France", 23),
                new Adresse(67, "7 rue des passeurs", "35000", "Rennes", "France", 23)))));
        mapDataSourceUtilisateurs.put(24, new Utilisateur(24, "Mr", "Kemi", "Bazare", "kemi.bazare@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(68, "50 rue du bien", "69000", "Lyon", "France", true, 24),
                new Adresse(69, "5 rue de Maurice", "75000", "Paris", "France", 24),
                new Adresse(70, "7 rue des Belges", "35000", "Rennes", "France", 24)))));
        mapDataSourceUtilisateurs.put(25, new Utilisateur(25, "Mr", "Thibault", "Levrard", "thibault.levrard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(71, "33 rue des passeurs", "75000", "Paris", "France", true, 25),
                new Adresse(72, "5 rue de Gaubert", "75000", "Paris", "France", 25),
                new Adresse(73, "7 rue des passeurs", "35000", "Rennes", "France", 25)))));
        mapDataSourceUtilisateurs.put(26, new Utilisateur(26, "Mr", "Michael", "Joo", "michael.joo@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(74, "46 rue du Général De Gaule", "44000", "Nantes", "France", true, 26),
                new Adresse(75, "5 rue de Jacques Lambert", "76000", "Rouen", "France", 26),
                new Adresse(76, "7 rue des passeurs", "35000", "Rennes", "France", 26)))));
        mapDataSourceUtilisateurs.put(27, new Utilisateur(27, "Mr", "Lionnel", "Richie", "lionnel.richie@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(77, "46 rue du Général De Gaule", "35000", "Rennes", "France", true, 27),
                new Adresse(78, "5 rue de Nicolas Gaz", "75000", "Paris", "France", 27),
                new Adresse(79, "54 rue des passeurs", "69000", "Lyon", "France", 27)))));
        mapDataSourceUtilisateurs.put(28, new Utilisateur(28, "Mr", "Maurice", "Green", "maurice.green@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(80, "10 rue des etrangers", "35000", "Rennes", "France", true, 28),
                new Adresse(81, "5 rue des Maux", "75000", "Paris", "France", 28),
                new Adresse(82, "7 rue des passeurs", "35000", "Rennes", "France", 28)))));
        return mapDataSourceUtilisateurs;
    }

    private Utilisateur[] initUtilisateursArrayDataSource() {
        return new Utilisateur[]{
            new Utilisateur(1, "Mr", "Jerome", "Cantin", "admin@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(1, "5 rue du Paradis", "75000", "Paris", "France", true, 1),
            new Adresse(2, "60 rue des faveurs", "44000", "Nantes", "France", 1),
            new Adresse(3, "66 rue des deportés", "35000", "Rennes", "France", 1)))),
            new Utilisateur(2, "Mr", "Nicolas", "Petit", "nicolas.petit@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(4, "9 rue de la liberté", "75000", "Paris", "France", true, 2),
            new Adresse(5, "55 rue de la mer", "87000", "Limoges", "France", 2),
            new Adresse(6, "44 rue du Paradis ", "76000", "Rouen", "France", 2)))),
            new Utilisateur(3, "Mr", "Jerome", "Leduc", "jerome@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(7, "5 rue de maupassant", "75000", "Paris", "France", true, 3),
            new Adresse(8, "33 rue des fauves", "76000", "Rouen", "France", 3),
            new Adresse(9, "66 rue des Saint", "35000", "Rennes", "France", 3)))),
            new Utilisateur(4, "Mr", "Dimitry", "Gozin", "dimitry.gozin@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(10, "44 rue du General Patton", "75000", "Paris", "France", true, 4),
            new Adresse(11, "5 rue de la paix", "44000", "Nantes", "France", 4),
            new Adresse(12, "7 rue des Sages", "75000", "Paris", "France", 4)))),
            new Utilisateur(5, "Mme", "Louise", "Correa", "luise@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(13, "15 rue des heureux", "35000", "Rennes", "France", true, 5),
            new Adresse(14, "66 rue des ingenieurs", "69000", "Lyon", "France", 5),
            new Adresse(15, "7 rue des peurs", "35000", "Rennes", "France", 5)))),
            new Utilisateur(6, "Mr", "Nicolas", "Gerard", "nicolas.gerard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(16, "39 rue du Lion", "44000", "Nantes", "France", true, 6),
            new Adresse(17, "5 rue de Maupassant", "75000", "Paris", "France", 6),
            new Adresse(18, "7 rue des passeurs", "35000", "Rennes", "France", 6)))),
            new Utilisateur(7, "Mr", "Remy", "Collard", "remy.collard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(19, "66 rue des deportés", "35000", "Rennes", "France", true, 7),
            new Adresse(20, "5 rue de Maupassant", "44000", "Nantes", "France", 7),
            new Adresse(21, "7 rue du Christ", "76000", "Rouen", "France", 7)))),
            new Utilisateur(8, "Mr", "Vincent", "Ducan", "vincent.ducamp@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(22, "6 rue de la chance", "75000", "Paris", "France", true, 8),
            new Adresse(23, "5 rue du pouvoir", "44000", "Nantes", "France", 8),
            new Adresse(24, "7 rue des reveurs", "35000", "Rennes", "France", 8)))),
            new Utilisateur(9, "Mme", "Claire", "Dupond", "claire.dupond@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(25, "7 rue des artisans", "53000", "Laval", "France", true, 9),
            new Adresse(26, "5 rue du Maroc", "75000", "Paris", "France", 9),
            new Adresse(27, "7 rue des passeurs", "35000", "Rennes", "France", 9)))),
            new Utilisateur(10, "Mme", "Stephanie", "Job", "stephanie.job@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(28, "7 rue de Napoleon", "87000", "Limoges", "France", true, 10),
            new Adresse(29, "66 rue de Pologne", "75000", "Paris", "France", 10),
            new Adresse(30, "7 rue des passeurs", "35000", "Rennes", "France", 10)))),
            new Utilisateur(11, "Mme", "Celine", "Premier", "celine.premier@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(31, "50 rue du General Patton", "76000", "Rouen", "France", true, 11),
            new Adresse(32, "5 rue de Saint George", "75000", "Paris", "France", 11),
            new Adresse(33, "7 rue des passeurs", "35000", "Rennes", "France", 11)))),
            new Utilisateur(12, "Mr", "Jean", "Marchand", "jean.marchand@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(34, "6 rue des enseignants", "44000", "Nantes", "France", true, 12),
            new Adresse(35, "5 rue de Dagobert", "75000", "Paris", "France", 12),
            new Adresse(36, "7 rue des passeurs", "35000", "Rennes", "France", 12)))),
            new Utilisateur(13, "Mr", "Nicolas", "Petit", "nicolas.petit@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(37, "9 rue de la liberté", "44000", "Nantes", "France", true, 13),
            new Adresse(38, "35 rue du coeur", "75000", "Paris", "France", 13)))),
            new Utilisateur(14, "Mr", "Patrick", "Leduc", "patric.leduc@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(39, "32 rue de la mer", "87000", "Limoges", "France", true, 14),
            new Adresse(40, "5 rue de la misericorde", "75000", "Paris", "France", 14),
            new Adresse(41, "17 rue des passeurs", "35000", "Rennes", "France", 14)))),
            new Utilisateur(15, "Mr", "Malick", "Ba", "malick.ba@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(42, "44 rue de la charité", "53000", "Laval", "France", true, 15),
            new Adresse(43, "5 rue du General Patton", "75000", "Paris", "France", 15),
            new Adresse(44, "7 rue des passeurs", "35000", "Rennes", "France", 15)))),
            new Utilisateur(16, "Mr", "Erwan", "Free", "erwan.free@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(45, "44 rue du General Patton", "53000", "Laval", "France", true, 16),
            new Adresse(46, "5 rue des enseignants", "75000", "Paris", "France", 16),
            new Adresse(47, "7 rue des passeurs", "35000", "Rennes", "France", 16)))),
            new Utilisateur(17, "Mr", "Marc", "Lambert", "marc.lambert@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(48, "10 rue des heureux", "72000", "Le Mans", "France", true, 17),
            new Adresse(49, "5 rue de Saint Sens", "44000", "Nantes", "France", 17),
            new Adresse(50, "7 rue des passeurs", "35000", "Rennes", "France", 17)))),
            new Utilisateur(18, "Mme", "France", "Lebon", "france.lebon@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(51, "10 rue de Saint Christophe", "72000", "Le Mans", "France", true, 18),
            new Adresse(52, "5 rue de Maupassant", "75000", "Paris", "France", 18),
            new Adresse(53, "7 rue des passeurs", "35000", "Rennes", "France", 18)))),
            new Utilisateur(19, "Mr", "Francis", "Garry", "francis.garry@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(54, "55 rue du desert", "35000", "Rennes", "France", true, 19),
            new Adresse(55, "5 rue de Maupassant", "75000", "Paris", "France", 19),
            new Adresse(56, "7 rue des passeurs", "35000", "Rennes", "France", 19)))),
            new Utilisateur(20, "Mr", "Thierry", "Garon", "thierry.garon@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(57, "15 rue de la paix", "53000", "Laval", "France", true, 20),
            new Adresse(58, "57 rue du desert", "75000", "Paris", "France", 20),
            new Adresse(59, "5 rue de Maupassant", "35000", "Rennes", "France", 20)))),
            new Utilisateur(21, "Mme", "Fatou", "Diop", "fatou.diop@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(60, "50 rue du passant ", "75000", "Paris", "France", true, 21),
            new Adresse(61, "5 rue de la Tasse", "75000", "Paris", "France", 21),
            new Adresse(62, "7 rue des passeurs", "35000", "Rennes", "France", 21)))),
            new Utilisateur(22, "Mme", "Fatima", "Salam", "fatima.salam@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(63, "10 rue de la misericorde", "72000", "Le Mans", "France", true, 22),
            new Adresse(64, "5 rue des etranges", "75000", "Paris", "France", 22),
            new Adresse(65, "7 rue des passeurs", "35000", "Rennes", "France", 22)))),
            new Utilisateur(23, "Mr", "Jean", "Dasilva", "jean.dasilva@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(
            new Adresse(66, "5 rue de Maupassant", "75000", "Paris", "France", 23),
            new Adresse(67, "7 rue des passeurs", "35000", "Rennes", "France", 23)))),
            new Utilisateur(24, "Mr", "Kemi", "Bazare", "kemi.bazare@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(68, "50 rue du bien", "69000", "Lyon", "France", true, 24),
            new Adresse(69, "5 rue de Maurice", "75000", "Paris", "France", 24),
            new Adresse(70, "7 rue des Belges", "35000", "Rennes", "France", 24)))),
            new Utilisateur(25, "Mr", "Thibault", "Levrard", "thibault.levrard@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(71, "33 rue des passeurs", "75000", "Paris", "France", true, 25),
            new Adresse(72, "5 rue de Gaubert", "75000", "Paris", "France", 25),
            new Adresse(73, "7 rue des passeurs", "35000", "Rennes", "France", 25)))),
            new Utilisateur(26, "Mr", "Michael", "Joo", "michael.joo@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(74, "46 rue du Général De Gaule", "44000", "Nantes", "France", true, 26),
            new Adresse(75, "5 rue de Jacques Lambert", "76000", "Rouen", "France", 26),
            new Adresse(76, "7 rue des passeurs", "35000", "Rennes", "France", 26)))),
            new Utilisateur(27, "Mr", "Lionnel", "Richie", "lionnel.richie@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(77, "46 rue du Général De Gaule", "35000", "Rennes", "France", true, 27),
            new Adresse(78, "5 rue de Nicolas Gaz", "75000", "Paris", "France", 27),
            new Adresse(79, "54 rue des passeurs", "69000", "Lyon", "France", 27)))),
            new Utilisateur(28, "Mr", "Maurice", "Green", "maurice.green@gmail.com", "passw0rd", new Date(System.currentTimeMillis()), new ArrayList<Adresse>(Arrays.asList(new Adresse(80, "10 rue des etrangers", "35000", "Rennes", "France", true, 28),
            new Adresse(81, "5 rue des Maux", "75000", "Paris", "France", 28),
            new Adresse(82, "7 rue des passeurs", "35000", "Rennes", "France", 28))))
        };
    }

    private Adresse[] initAdressesArrayDataSource() {
        return new Adresse[]{
            new Adresse(1, "5 rue du Paradis", "75000", "Paris", "France"),
            new Adresse(2, "60 rue des faveurs", "44000", "Nantes", "France"),
            new Adresse(3, "66 rue des deportés", "35000", "Rennes", "France"),
            new Adresse(4, "9 rue de la liberté", "75000", "Paris", "France"),
            new Adresse(5, "55 rue de la mer", "87000", "Limoges", "France"),
            new Adresse(6, "44 rue du Paradis ", "76000", "Rouen", "France"),
            new Adresse(7, "5 rue de maupassant", "75000", "Paris", "France"),
            new Adresse(8, "33 rue des fauves", "76000", "Rouen", "France"),
            new Adresse(9, "66 rue des Saint", "35000", "Rennes", "France"),
            new Adresse(10, "44 rue du General Patton", "75000", "Paris", "France"),
            new Adresse(11, "5 rue de la paix", "44000", "Nantes", "France"),
            new Adresse(12, "7 rue des Sages", "75000", "Paris", "France"),
            new Adresse(13, "15 rue des heureux", "35000", "Rennes", "France"),
            new Adresse(14, "66 rue des ingenieurs", "69000", "Lyon", "France"),
            new Adresse(15, "7 rue des peurs", "35000", "Rennes", "France"),
            new Adresse(16, "39 rue du Lion", "44000", "Nantes", "France"),
            new Adresse(17, "5 rue de Maupassant", "75000", "Paris", "France"),
            new Adresse(18, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(19, "66 rue des deportés", "35000", "Rennes", "France"),
            new Adresse(20, "5 rue de Maupassant", "44000", "Nantes", "France"),
            new Adresse(21, "7 rue du Christ", "76000", "Rouen", "France"),
            new Adresse(22, "6 rue de la chance", "75000", "Paris", "France"),
            new Adresse(23, "5 rue du pouvoir", "44000", "Nantes", "France"),
            new Adresse(24, "7 rue des reveurs", "35000", "Rennes", "France"),
            new Adresse(25, "7 rue des artisans", "53000", "Laval", "France"),
            new Adresse(26, "5 rue du Maroc", "75000", "Paris", "France"),
            new Adresse(27, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(28, "7 rue de Napoleon", "87000", "Limoges", "France"),
            new Adresse(29, "66 rue de Pologne", "75000", "Paris", "France"),
            new Adresse(30, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(31, "50 rue du General Patton", "76000", "Rouen", "France"),
            new Adresse(32, "5 rue de Saint George", "75000", "Paris", "France"),
            new Adresse(33, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(34, "6 rue des enseignants", "44000", "Nantes", "France"),
            new Adresse(35, "5 rue de Dagobert", "75000", "Paris", "France"),
            new Adresse(36, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(37, "9 rue de la liberté", "44000", "Nantes", "France"),
            new Adresse(38, "35 rue du coeur", "75000", "Paris", "France"),
            new Adresse(39, "32 rue de la mer", "87000", "Limoges", "France"),
            new Adresse(40, "5 rue de la misericorde", "75000", "Paris", "France"),
            new Adresse(41, "17 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(42, "44 rue de la charité", "53000", "Laval", "France"),
            new Adresse(43, "5 rue du General Patton", "75000", "Paris", "France"),
            new Adresse(44, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(45, "44 rue du General Patton", "53000", "Laval", "France"),
            new Adresse(46, "5 rue des enseignants", "75000", "Paris", "France"),
            new Adresse(47, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(48, "10 rue des heureux", "72000", "Le Mans", "France"),
            new Adresse(49, "5 rue de Saint Sens", "44000", "Nantes", "France"),
            new Adresse(50, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(51, "10 rue de Saint Christophe", "72000", "Le Mans", "France"),
            new Adresse(52, "5 rue de Maupassant", "75000", "Paris", "France"),
            new Adresse(53, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(54, "55 rue du desert", "35000", "Rennes", "France"),
            new Adresse(55, "5 rue de Maupassant", "75000", "Paris", "France"),
            new Adresse(56, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(57, "15 rue de la paix", "53000", "Laval", "France"),
            new Adresse(58, "57 rue du desert", "75000", "Paris", "France"),
            new Adresse(59, "5 rue de Maupassant", "35000", "Rennes", "France"),
            new Adresse(60, "50 rue du passant ", "75000", "Paris", "France"),
            new Adresse(61, "5 rue de la Tasse", "75000", "Paris", "France"),
            new Adresse(62, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(63, "10 rue de la misericorde", "72000", "Le Mans", "France"),
            new Adresse(64, "5 rue des etranges", "75000", "Paris", "France"),
            new Adresse(65, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(66, "5 rue de Maupassant", "75000", "Paris", "France"),
            new Adresse(67, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(68, "50 rue du bien", "69000", "Lyon", "France"),
            new Adresse(69, "5 rue de Maurice", "75000", "Paris", "France"),
            new Adresse(70, "7 rue des Belges", "35000", "Rennes", "France"),
            new Adresse(71, "33 rue des passeurs", "75000", "Paris", "France"),
            new Adresse(72, "5 rue de Gaubert", "75000", "Paris", "France"),
            new Adresse(73, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(74, "46 rue du Général De Gaule", "44000", "Nantes", "France"),
            new Adresse(75, "5 rue de Jacques Lambert", "76000", "Rouen", "France"),
            new Adresse(76, "7 rue des passeurs", "35000", "Rennes", "France"),
            new Adresse(77, "46 rue du Général De Gaule", "35000", "Rennes", "France"),
            new Adresse(78, "5 rue de Nicolas Gaz", "75000", "Paris", "France"),
            new Adresse(79, "54 rue des passeurs", "69000", "Lyon", "France"),
            new Adresse(80, "10 rue des etrangers", "35000", "Rennes", "France"),
            new Adresse(81, "5 rue des Maux", "75000", "Paris", "France"),
            new Adresse(82, "7 rue des passeurs", "35000", "Rennes", "France")
        };
    }

    public List<Adresse> getAdressesListDataSource() {
        return adressesListDataSource;
    }

    public List<Utilisateur> getUtilisateursListDataSource() {
        return utilisateursListDataSource;
    }

    public Map<Integer, Adresse> getAdressesMapDataSource() {
        return adressesMapDataSource;
    }

    public Map<Integer, Utilisateur> getUtilisateursMapDataSource() {
        return utilisateursMapDataSource;
    }

    public Adresse[] getAdressesArrayDataSource() {
        return adressesArrayDataSource;
    }

    public Utilisateur[] getUtilisateursArrayDataSource() {
        return utilisateursArrayDataSource;
    }
}
