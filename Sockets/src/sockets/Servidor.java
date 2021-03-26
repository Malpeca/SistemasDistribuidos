package sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion 
{
	public Servidor() throws IOException{super("servidor");}
	
	public void startServer()
	{
		try
		{
			System.out.println("Esperando...");
			cs = ss.accept();
			System.out.println("Cliente en línea");
			salidaCliente = new DataOutputStream(cs.getOutputStream());
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			while((mensajeServidor = entrada.readLine()) != null)
			{
				System.out.println("Fin de la conexión");
			}
			System.out.println(mensajeServidor);
			ss.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
