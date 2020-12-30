package com.example.bankprojectexample.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class PaymentsOrdersCoin {
	private String nombre;
	private String montopago;
	private String moneda;
	private String fecharegistro;
}
