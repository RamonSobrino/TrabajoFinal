package org.mule.model;

import java.util.Map;

public class Pedido {
	
	private String NIF;
	private String nombreCompleto;
	private boolean financia;
	
	private Map<String,String> productos;

	public Pedido() {}
	public Pedido(String nIF, String nombreCompleto, boolean financia, Map<String, String> productos) {
		NIF = nIF;
		this.nombreCompleto = nombreCompleto;
		this.financia = financia;
		this.productos = productos;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public boolean isFinancia() {
		return financia;
	}
	public void setFinancia(boolean financia) {
		this.financia = financia;
	}
	public Map<String, String> getProductos() {
		return productos;
	}
	public void setProductos(Map<String, String> productos) {
		this.productos = productos;
	}
	@Override
	public String toString() {
		return "Pedido [NIF=" + NIF + ", nombreCompleto=" + nombreCompleto + ", financia=" + financia + ", productos="
				+ productos + "]";
	}
	
	
}
