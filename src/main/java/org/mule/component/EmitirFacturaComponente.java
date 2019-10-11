package org.mule.component;

import java.util.List;

import org.mule.model.LineaPedido;

public class EmitirFacturaComponente {
	public String generarPedidoOrdinario(Object objeto) {
		List<LineaPedido> lineas = (List<LineaPedido>)objeto;
		StringBuffer buff = new StringBuffer();
		LineaPedido linea = lineas.get(0);
		
		
		buff.append("********  FACTURA  ************ \n");
		buff.append("Nombre Cliente: "+linea.getNombreCompleto()+"\n");
		buff.append("NIF Cliente: "+linea.getNifCliente()+"\n");
		if(linea.isFinanciacion()&&linea.isFinanciable()) {
			buff.append("Es un pedido financiado\n");
		}else {
			buff.append("Es un pedido en efectivo\n");
		}
		buff.append("Pedido: \n");
		for (LineaPedido lineaPedido : lineas) {
			buff.append("ISBN: "+lineaPedido.getIsbn()+" Cantidad: "+lineaPedido.getCantidad()+"\n");
		}
		
		buff.append("\n");		
		return buff.toString();
		
	}

}
