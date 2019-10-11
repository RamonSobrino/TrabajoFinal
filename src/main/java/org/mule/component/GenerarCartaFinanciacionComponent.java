package org.mule.component;

import org.mule.model.LineaPedido;

public class GenerarCartaFinanciacionComponent {
	
	public String generarCartaFinanciacion(Object objeto) {
		LineaPedido linea = (LineaPedido)objeto;
		StringBuffer buff = new StringBuffer();
		
		buff.append("********  CARTA DE FINANCION  ************ \n");
		buff.append("Se le ha aprobado la financiación\n");
		buff.append("Nombre Cliente: "+linea.getNombreCompleto()+"\n");
		buff.append("NIF Cliente: "+linea.getNifCliente()+"\n");
		buff.append("\n");
	
		
		return buff.toString();
		
	}
}
