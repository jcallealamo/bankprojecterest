package com.example.bankprojectexample.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.example.bankprojectexample.entity.Banco;
import com.example.bankprojectexample.entity.OrdenesPago;
import com.example.bankprojectexample.entity.PaymentsOrdersCoin;
import com.example.bankprojectexample.entity.Sucursal;
import com.example.bankprojectexample.jpa.BancoJpa;
import com.example.bankprojectexample.jpa.OrdenesPagoJpa;
import com.example.bankprojectexample.jpa.PaymentsOrdersCoinJpa;
import com.example.bankprojectexample.jpa.SucursalJpa;

@Path("/bank")
public class BankService {
	private BancoJpa bancoJpa = new BancoJpa();
	private SucursalJpa sucursalJpa = new SucursalJpa();
	private OrdenesPagoJpa ordenesPagoJpa = new OrdenesPagoJpa();
	private PaymentsOrdersCoinJpa paymentsOrdersCoinJpa = new PaymentsOrdersCoinJpa();

//1. 
	// agregar Bancos
	@POST
	@Path("saveBanks")
	@Consumes("application/json")
	public Response saveBanks(Banco banco) {
		return bancoJpa.saveBanks(banco);
	}

	// agregar sucursales
	@POST
	@Path("saveSubsidiary")
	@Consumes("application/json")
	public Response saveSubsidiary(Sucursal sucursal) {
		return sucursalJpa.saveSubsidiary(sucursal);
	}

	// agregar ordenes de pago
	@POST
	@Consumes("application/json")
	public Response savePaymentsOrders(OrdenesPago ordenes) {
		return ordenesPagoJpa.savePaymentsOrders(ordenes);
	}

	// eliminar Bancos
	@POST
	@Path("deleteBanks")
	@Consumes("application/json")
	public Response deleteBanks(String idBank) {
		return bancoJpa.deleteBanks(idBank);
	}

	// eliminar suscursales
	@POST
	@Path("deleteSubsidiary")
	@Consumes("application/json")
	public Response deleteSubsidiary(String idubsidiary) {
		return sucursalJpa.deleteSubsidiary(idubsidiary);
	}

	// eliminar ordenes de pago
	@POST
	@Path("deletePaymentsOrders")
	@Consumes("application/json")
	public Response deletePaymentsOrders(String idOrder) {
		return ordenesPagoJpa.deletePaymentsOrders(idOrder);
	}

	// listar Bancos
	@GET
	@Path("getAllBanks")
	@Produces(value = "application/json")
	public List<Banco> getAllBanks() {

		return bancoJpa.getAllBanks();
	}

	// listar sucursales
	@GET
	@Path("getAllSubsidiary")
	@Produces(value = "application/json")
	public List<Sucursal> getAllSubsidiary() {
		return sucursalJpa.getAllSubsidiary();
	}

	// listar ordenes de pago
	@GET
	@Path("getAllPaymentsOrders")
	@Produces(value = "application/json")
	public List<OrdenesPago> getAllPaymentsOrders() {
		return ordenesPagoJpa.getAllPaymentsOrders();
	}

//2. 
	// listar todas las órdenes de pago de una sucursal contemplando el filtrado por
	// tipo de moneda,
	@GET
	@Path("getPaymentsOrdersByCoin")
	@Produces(value = "application/json")
	public List<PaymentsOrdersCoin> getPaymentsOrdersByCoin(@QueryParam("moneda") @DefaultValue("") String moneda) {
		return paymentsOrdersCoinJpa.getPaymentsOrdersByCoin(moneda);
	}	
}
