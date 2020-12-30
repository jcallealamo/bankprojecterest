package com.example.bankprojectexample.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "local", name = "Sucursal")
public class Sucursal {
	@Id
	private String idSucursal;
	private String nombre;
	private String direccion;
	@Column(name = "fecharegistro")
	private String fecha;
	@ManyToOne
	@JoinColumn(name = "idBanco")
	private Banco banco;
	
	@OneToMany(mappedBy = "sucursal")
	private List<OrdenesPago> ordenesPagoList;

}
