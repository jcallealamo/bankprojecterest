package com.example.bankprojectexample.jpa;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import com.example.bankprojectexample.entity.OrdenesPago;
import com.example.bankprojectexample.utils.JpaRepository;

public class OrdenesPagoJpa extends JpaRepository {

	public List<OrdenesPago> getAllPaymentsOrders() {
		JpaRepository.setupStatic();
		this.setup();
		TypedQuery<OrdenesPago> query = em.createQuery("SELECT e FROM OrdenesPago e", OrdenesPago.class);
		List<OrdenesPago> resultado = query.getResultList();
		return resultado;
	}

	public Response savePaymentsOrders(OrdenesPago ordenesPago) {
		JpaRepository.setupStatic();
		this.setup();
		em.getTransaction().begin();
		em.persist(ordenesPago);
		em.getTransaction().commit();
		this.tearDown();
		JpaRepository.tearDownStatic();
		return Response.ok().build();
	}
	
	public Response deletePaymentsOrders(String idOrder) {
		JpaRepository.setupStatic();
		this.setup();
		OrdenesPago ordenesPago = em.find(OrdenesPago.class, idOrder);
		if (ordenesPago != null) {
			em.getTransaction().begin();
			em.remove(ordenesPago);
			em.getTransaction().commit();
		}
		this.tearDown();
		JpaRepository.tearDownStatic();
		return Response.ok().build();
	}

}
