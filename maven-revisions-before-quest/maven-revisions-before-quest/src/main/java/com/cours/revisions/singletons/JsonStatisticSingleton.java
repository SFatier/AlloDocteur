/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import org.json.simple.JSONObject;

/**
 *
 * @author elhad
 */
public class JsonStatisticSingleton extends AbstractStatisticSingleton {

    final String personnesJsonPathFile = "personnesJson.json";

    private JsonStatisticSingleton() {
    }

    public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson) {
        return null;
    }

    @Override
    protected void extractPersonnesDatas() {

    }

}
