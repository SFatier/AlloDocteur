/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elhad
 */
public abstract class AbstractStatisticSingleton {

    protected List<Personne> personnes = new ArrayList<Personne>();
    protected Double moyennePoids = 0.0;
    protected Double ecartTypePoids = 0.0;

    protected Double moyenneTaille = 0.0;
    protected Double ecartTypeTaille = 0.0;

    public Double getMoyennePoids() {
        return moyennePoids;
    }

    public Double getEcartTypePoids() {
        return ecartTypePoids;
    }

    public Double getMoyenneTaille() {
        return moyenneTaille;
    }

    public Double getEcartTypeTaille() {
        return ecartTypeTaille;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    protected abstract void extractPersonnesDatas();
}
