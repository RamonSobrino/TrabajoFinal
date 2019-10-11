package org.mule.component;

import org.mule.model.LineaPedido;

public class GenerarPedidoUrgente {
	
	public String generarPedidoUrgente(Object objeto) {
		LineaPedido linea = (LineaPedido)objeto;
		StringBuffer buff = new StringBuffer();
		
		buff.append("********  PEDIDO URGENTE  ************ \n");
		buff.append("Nombre Cliente: "+linea.getNombreCompleto()+"\n");
		buff.append("NIF Cliente: "+linea.getNifCliente()+"\n");
		buff.append("ISBN: "+linea.getIsbn()+"\n");
		buff.append("Cantidad: "+linea.getCantidad()+"\n");
		if(linea.isFinanciacion()&&linea.isFinanciable()) {
			buff.append("Es un pedido financiado\n");
		}else {
			buff.append("Es un pedido en efectivo\n");
		}
		buff.append("\n");
		
		
		return buff.toString();
		
	}

}
