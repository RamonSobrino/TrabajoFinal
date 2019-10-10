package org.mule.model;

public class LineaPedido {
	
	private String isbn;
	private boolean disponible;
	private boolean financiacion;
	private String nifCliente;
	private String cantidad;
	
	
	public LineaPedido(String isbn,boolean financiacion, boolean disponible, String nifCliente, String cantidad) {
		super();
		this.isbn = isbn;
		this.disponible = disponible;
		this.nifCliente = nifCliente;
		this.cantidad = cantidad;
		this.financiacion =financiacion;
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


	@Override
	public String toString() {
		return "LineaPedido [isbn=" + isbn + ", disponible=" + disponible + ", nifCliente=" + nifCliente + ", cantidad="
				+ cantidad + "]";
	}
	
	
	
	

}
