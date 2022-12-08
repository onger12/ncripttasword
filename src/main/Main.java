package main;

import interfaz.Menu;
import usuario.Usuario;

public class Main {
	Menu menu;
	public Main(){

		
		menu = new Menu();
		Encriptador enc = new Encriptador();
		Usuario user = new Usuario();
		String ramdonPass = enc.generateRandomPass(12);

		try {
			//Add encripted random password to user
			user.addPassword( enc.encrypt( ramdonPass ));
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		System.out.println("El sistema le asignó la contraseña: " + ramdonPass);

		menu.output("Esta contraseña es temporal, por favor a contuniación le pediremos que la cambie.");
		String newPass = menu.input("Ingrese la contraseña actual: ");

		if("hola" != "") {

		}
		
		
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
	
	private boolean validarPass(String pass) {
		boolean response = false;
		
		if(pass.length() < 8) return false;
		
		for (int i = 0; i < pass.length(); i++)
		{
		   if (Character.isUpperCase( pass.charAt( i ))) return false;
		}
		
		System.out.println("pasó");
		return response;
	}
}
