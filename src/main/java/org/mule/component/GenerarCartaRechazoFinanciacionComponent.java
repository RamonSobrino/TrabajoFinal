package org.mule.component;

import org.mule.model.LineaPedido;

public class GenerarCartaRechazoFinanciacionComponent {

	public String generarCartaRechazoFinanciacion(Object objeto) {
		LineaPedido linea = (LineaPedido)objeto;
		StringBuffer buff = new StringBuffer();
		
		buff.append("********  CARTA DE RECHAZO DE FINANCION  ************ \n");
		buff.append("Se le ha rechazado la financiación\n");
		buff.append("Nombre Cliente: "+linea.getNombreCompleto()+"\n");
		buff.append("NIF Cliente: "+linea.getNifCliente()+"\n");
		buff.append("\n");
	
		
		return buff.toString();
		
	}

}
