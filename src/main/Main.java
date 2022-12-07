package main;

import interfaz.Menu;
import usuario.Usuario;

public class Main {
	Menu menu;
	public Main(){

		
		menu = new Menu();
		Encriptador enc = new Encriptador();
		Usuario user = new Usuario();
		String pass = enc.generateRandomPass(12);

		try {
			user.addPassword( enc.encrypt( pass ));
		} catch ( Exception e ) {
			
			e.printStackTrace();
		}
		
		String badPass = "123123123123As";
		boolean passValue = enc.validarPass(badPass);
		
		
		String res = menu.menu();
		
		switch( res ) {
			case "1":
				menu.output("Asigna contrasena");
				break;
			case "2":
				menu.output("Cambio contrasena");
				break;
			default:
				menu.output("default");
		}
	}
}
