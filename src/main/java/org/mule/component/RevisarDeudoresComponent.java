package org.mule.component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.model.LineaPedido;

public class RevisarDeudoresComponent {

	public Object comprobarDeudores(Object origen) {
		LineaPedido linea = (LineaPedido) origen;

		linea.setFinanciable(this.comprobarDeudores(linea.getNifCliente()));
		return linea;
	}

	private boolean comprobarDeudores(String key) {

		Properties relacion = new Properties();

		try {
			relacion.load(new FileInputStream("src/main/resources/deudores.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String valorProp = relacion.getProperty(key);

		return Integer.valueOf(valorProp) < 2000;
	}
}
