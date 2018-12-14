/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import org.w3c.dom.Element;

/**
 *
 * @author elhad
 */
public class XmlStatisticSingleton extends AbstractStatisticSingleton {

    final String personnesXmlPathFile = "personnesXml.xml";

    private XmlStatisticSingleton() {
    }

    public Personne createPersonneWithFileObject(Element elementPersonne) {
        return null;
    }

    @Override
    protected void extractPersonnesDatas() {

    }

}
