package org.mule.component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.mule.model.LineaPedido;

public class RevisarVipComponent {

	public Object comprobarDeudores(Object origen) {
		LineaPedido linea = (LineaPedido) origen;

		linea.setClienteVip(this.comprobarVIP(linea.getNifCliente()));
		return linea;
	}

	private boolean comprobarVIP(String key) {

		Properties relacion = new Properties();

		try {
			relacion.load(new FileInputStream("src/main/resources/vip.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String valorProp = relacion.getProperty(key);
		
		if(valorProp!=null) {
			return Double.valueOf(valorProp) >= 2000;
		}else {
			return false;
		}
	}

}
