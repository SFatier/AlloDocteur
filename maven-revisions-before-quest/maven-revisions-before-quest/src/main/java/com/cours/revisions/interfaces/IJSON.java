package com.cours.revisions.interfaces;

import org.json.simple.JSONObject;

import com.cours.revisions.entities.Personne;

public interface IJSON extends ICSV{
	 
	public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson);
	 
}
