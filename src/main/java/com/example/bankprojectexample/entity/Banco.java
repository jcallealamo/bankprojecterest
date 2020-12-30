package com.example.bankprojectexample.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "local", name = "Banco")
public class Banco {
	@Id
	private String idBanco;
	private String nombre;
	private String direccion;
	@Column(name = "fecharegistro")
	private String fecha;
	@OneToMany(mappedBy = "Banco")
	private List<Sucursal> sucursalList;
}
