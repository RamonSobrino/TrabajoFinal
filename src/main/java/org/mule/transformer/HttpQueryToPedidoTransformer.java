package org.mule.transformer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.model.Pedido;
import org.mule.transformer.types.DataTypeFactory;

public class HttpQueryToPedidoTransformer extends AbstractMessageTransformer {

	public HttpQueryToPedidoTransformer() {
		this.setReturnDataType(DataTypeFactory.create(Pedido.class));
	}

	@Override
	public Object transformMessage(MuleMessage message, String arg1) throws TransformerException {
		Map<String, String> queryParams = message.getInboundProperty("http.query.params");

		Pedido pedido = new Pedido();

		if (queryParams.containsKey("cif")) {
			pedido.setNIF(queryParams.get("cif"));
		}

		if (queryParams.containsKey("nombre") || queryParams.containsKey("apellidos")) {
			String corte = queryParams.get("apellidos").replace("%20", " ");
			pedido.setNombreCompleto(queryParams.get("nombre")+corte);
		}
		
		if (queryParams.containsKey("financia")) {
			pedido.setFinancia(queryParams.get("financia").equals("on")?true:false);
		}
		

		Properties relacion = new Properties();
		
		try {
			relacion.load(new FileInputStream("src/main/resources/relacionProductosISBN.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, String> productos = new HashMap<>();
		for (int i = 1; i <= 10; i++) {
			if (queryParams.containsKey("producto" + i)) {
				int cantidad = Integer.valueOf( queryParams.get("producto" + i));
				if(cantidad>0) {
					productos.put(relacion.getProperty("producto" + i), queryParams.get("producto" + i));
				}
			}
		}

		pedido.setProductos(productos);

		System.out.println("Transformado  a " + pedido.toString());
		return pedido;
	}

}
