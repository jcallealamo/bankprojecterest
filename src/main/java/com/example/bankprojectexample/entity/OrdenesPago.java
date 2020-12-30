package com.example.bankprojectexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "local", name = "OrdenesPago")
public class OrdenesPago {
	@Id
	private String idOrdenesPago;
	private String monto;
	private String moneda;
	private String estado;
	@Column(name = "fecharegistro")
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name = "idSucursal")
	private Sucursal sucursal;
}
