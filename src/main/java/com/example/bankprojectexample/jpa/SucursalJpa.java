package com.example.bankprojectexample.jpa;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

import com.example.bankprojectexample.entity.Sucursal;
import com.example.bankprojectexample.utils.JpaRepository;

public class SucursalJpa extends JpaRepository {
	public List<Sucursal> getAllSubsidiary() {
		JpaRepository.setupStatic();
		this.setup();
		TypedQuery<Sucursal> query = em.createQuery("SELECT e FROM Sucursal e", Sucursal.class);
		List<Sucursal> resultado = query.getResultList();
		return resultado;
	}
	
	public Response saveSubsidiary(Sucursal sucursal) {
		JpaRepository.setupStatic();
		this.setup();
		em.getTransaction().begin();
		em.persist(sucursal);
		em.getTransaction().commit();
		this.tearDown();
		JpaRepository.tearDownStatic();
		return Response.ok().build();
	}
	
	public Response deleteSubsidiary(String idubsidiary) {
		JpaRepository.setupStatic();
		this.setup();
		Sucursal sucursal = em.find(Sucursal.class, idubsidiary);
		if (sucursal != null) {
			em.getTransaction().begin();
			em.remove(sucursal);
			em.getTransaction().commit();
		}
		this.tearDown();
		JpaRepository.tearDownStatic();
		return Response.ok().build();
	}
}
