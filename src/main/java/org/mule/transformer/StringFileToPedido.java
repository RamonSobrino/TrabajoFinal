package org.mule.transformer;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.transformer.TransformerException;
import org.mule.model.Pedido;

public class StringFileToPedido extends AbstractTransformer {

	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractTransformer#doTransform(java.lang.Object, java.lang.String)
	 */
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		Pedido pedido = new Pedido();
		String [] datos = ((String) src).split("\n");

		String[] info = datos[1].split(";");
		pedido.setNIF(info[0]);
		pedido.setNombreCompleto(info[1]);
		if(info[2].contains("s") || info[2].contains("S")) {
			pedido.setFinancia(true);	
		} else {
			pedido.setFinancia(false);
		}
		
		Map<String, String> listaLibros = new HashMap<String, String>(); 
		for ( int i = 3 ; i < datos.length ; i ++)
		{
			String[] libros = datos[i].split(";");
			listaLibros.put(libros[0], libros[1]);
		}
		
		pedido.setProductos(listaLibros);
	
		return pedido;
	}
}