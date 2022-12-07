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
		
		String badPass = "123aaaaaaaaaaaaaaaa";
		boolean passValue = validarPass(badPass);
		System.out.print(passValue);
		
		
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
