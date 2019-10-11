package org.mule.component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.mule.model.LineaPedido;

public class RechazarPorFaltaStockComponent {
	
	public void rechazarPorFaltaStock(Object objeto) {
		LineaPedido linea = (LineaPedido)objeto;
		BufferedWriter bw = null;
	    FileWriter fw = null;

        try
        {
        	 File file = new File("tmp/output/faltaStock/"+linea.getIsbn()+".txt");
             // Si el archivo no existe, se crea!
             if (!file.exists()) {
                 file.createNewFile();
             }
             // flag true, indica adjuntar información al archivo.
             fw = new FileWriter(file.getAbsoluteFile(), true);
             bw = new BufferedWriter(fw);
             bw.write("El cliente con nif: "+linea.getNifCliente()+" ha pedido "+linea.getCantidad()+" libros.\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                            //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
	}

}
