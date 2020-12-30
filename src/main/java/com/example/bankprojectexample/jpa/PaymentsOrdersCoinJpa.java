package com.example.bankprojectexample.jpa;

import java.util.List;

import javax.persistence.Query;

import com.example.bankprojectexample.entity.PaymentsOrdersCoin;
import com.example.bankprojectexample.utils.JpaRepository;

public class PaymentsOrdersCoinJpa extends JpaRepository {
	public List<PaymentsOrdersCoin> getPaymentsOrdersByCoin(String moneda) {
		JpaRepository.setupStatic();
		this.setup();
		Query nativeQuery = em.createNativeQuery(
				"SELECT s.nombre,o.montopago,o.moneda,o.fecharegistro FROM Sucursal s, OrdenesPago o "
				+ "WHERE s.idordenespago = o.idordenespago "
				+ "AND moneda = ?");
		nativeQuery.setParameter(1, moneda);  
		List<PaymentsOrdersCoin> resultado = nativeQuery.getResultList();
		return resultado;
	}
}
