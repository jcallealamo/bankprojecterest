package com.example.bankprojectexample.jpa;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import com.example.bankprojectexample.entity.Banco;
import com.example.bankprojectexample.utils.JpaRepository;

public class BancoJpa extends JpaRepository {

	public List<Banco> getAllBanks() {
		JpaRepository.setupStatic();
		this.setup();
		TypedQuery<Banco> query = em.createQuery("SELECT e FROM Banco e", Banco.class);
		List<Banco> resultado = query.getResultList();
		return resultado;
	}

	public Response saveBanks(Banco banco) {
		JpaRepository.setupStatic();
		this.setup();
		em.getTransaction().begin();
		em.persist(banco);
		em.getTransaction().commit();
		this.tearDown();
		JpaRepository.tearDownStatic();
		return Response.ok().build();
	}

	public Response deleteBanks(String idBank) {
		JpaRepository.setupStatic();
		this.setup();
		Banco bankDelete = em.find(Banco.class, idBank);
		if (bankDelete != null) {
			em.getTransaction().begin();
			em.remove(bankDelete);
			em.getTransaction().commit();
		}
		this.tearDown();
		JpaRepository.tearDownStatic();
		return Response.ok().build();
	}

}
