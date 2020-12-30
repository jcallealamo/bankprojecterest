package com.example.bankprojectexample.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaRepository {
	public static final String BD = "bd_banco";
	public static EntityManagerFactory emf;
	protected EntityManager em;

	public static void setupStatic() {
		Persistence.generateSchema(BD, null);
		emf = Persistence.createEntityManagerFactory(BD);
	}

	public void setup() {
		em = emf.createEntityManager();
	}

	public void tearDown() {
		em.clear();
		em.close();
	}

	public static void tearDownStatic() {
		emf.close();
	}
}
