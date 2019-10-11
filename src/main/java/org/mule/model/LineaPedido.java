package org.mule.model;

public class LineaPedido {
	
	private String isbn;
	private boolean disponible;
	private boolean financiacion;
	private String nifCliente;
	private String cantidad;
	private boolean financiable;
	private boolean clienteVip;
	private String nombreCompleto;
	
	
	public LineaPedido(String isbn,boolean financiacion, boolean disponible, String nifCliente, String cantidad) {
		super();
		this.isbn = isbn;
		this.disponible = disponible;
		this.nifCliente = nifCliente;
		this.cantidad = cantidad;
		this.financiacion =financiacion;
	}
	
	public LineaPedido(String isbn, boolean disponible, String cantidad, Pedido pedido) {
		super();
		this.isbn = isbn;
		this.disponible = disponible;
		this.cantidad = cantidad;
		this.financiacion = pedido.isFinancia();
		this.nifCliente = pedido.getNIF();
		this.nombreCompleto = pedido.getNombreCompleto();
	}



	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public String getNifCliente() {
		return nifCliente;
	}


	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public boolean isFinanciacion() {
		return financiacion;
	}


	public void setFinanciacion(boolean financiacion) {
		this.financiacion = financiacion;
	}


	public boolean isFinanciable() {
		return financiable;
	}


	public void setFinanciable(boolean financiable) {
		this.financiable = financiable;
	}


	public boolean isClienteVip() {
		return clienteVip;
	}


	public void setClienteVip(boolean clienteVip) {
		this.clienteVip = clienteVip;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	@Override
	public String toString() {
		return "LineaPedido [isbn=" + isbn + ", disponible=" + disponible + ", financiacion=" + financiacion
				+ ", nifCliente=" + nifCliente + ", cantidad=" + cantidad + ", financiable=" + financiable
				+ ", clienteVip=" + clienteVip + "]";
	}

	
}
