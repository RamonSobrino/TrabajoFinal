package org.mule.transformer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mule.api.transformer.TransformerException;
import org.mule.model.LineaPedido;
import org.mule.model.Pedido;

public class PedidoToLineaPedido extends AbstractTransformer {
	
	@Override
	protected Object doTransform(Object arg0, String arg1) throws TransformerException {
		
		Pedido pedido =  (Pedido)arg0;
		
		List<LineaPedido> lista = new ArrayList<>();
		
		pedido.getProductos().forEach((key,value)->{
			lista.add(new LineaPedido(key,this.comprobarDisponibilidad(key, value),pedido.isFinancia(), pedido.getNIF(),value ));
		});
		
		return lista;
	}
	
	
	private boolean comprobarDisponibilidad(String key, String value) {
		
			Properties relacion = new Properties();
		
		try {
			relacion.load(new FileInputStream("src/main/resources/stock.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String valorProp = relacion.getProperty(key);
		
		
		return Integer.valueOf(valorProp)>=Integer.valueOf(value);
	}
}
