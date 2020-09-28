package main;

import negocio.PersonaNegocio;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;
import negociolmpl.PersonaNegociolmpl;

public class Principal {
	
	public static void main(String[] args) {
		
		VentanaPrincipal vista = new VentanaPrincipal();
		PersonaNegocio negocio = new PersonaNegociolmpl();
		Controlador controlador = new Controlador(vista, negocio);
		controlador.inicializar();
		
	}

}

