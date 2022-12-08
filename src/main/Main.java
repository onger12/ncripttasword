package main;

import interfaz.Menu;
import usuario.Usuario;

public class Main {
	Menu menu;
	Encriptador enc;
	Usuario user;
	double difference;

	public Main(double difference, boolean bandera){

		menu = new Menu();
		enc = new Encriptador();
		user = new Usuario();
		this.difference = difference;
		
		firstSetPassword(user);
		String currentPass = user.getPasswords().get(user.getPasswords().size() - 1);

		while(bandera){
			String res = menu.menu();
		
			switch( res ) {
				case "1":
					menu.output("\tAsigna contrasena\n");
					menu.resetPassword(currentPass, difference);
					break;
				case "2":
					menu.output("Cambio contrasena");
					break;
				case "3":
					menu.output("Contraseña actual: " + currentPass);
					break;
				case "4":
					try {
						menu.output("Contraseña actual desencriptada: " + enc.decrypt(currentPass));
					} catch ( Exception e ) {	
						e.printStackTrace();
					}
					break;
				case "0" : {
					bandera = false;
					break;
				}
				default:
					menu.output("default");
			}
		}
	}

	private Usuario firstSetPassword(Usuario user) {
		String randomPass = enc.generateRandomPass(12);

		try {
			user.addPassword( enc.encrypt( randomPass ));
		} catch ( Exception e ) {
			
			e.printStackTrace();
		}

		String lastUserPassword = user.getPasswords().get( user.getPasswords().size() - 1 );
		
		menu.output("\tEl sistema le asignó la contraseña: " + lastUserPassword + "\n\n");
		menu.output("Esta contraseña es temporal, por favor a contuniación le pediremos que la cambie.");

		String newPass = menu.resetPassword( lastUserPassword, difference );

		try {
			user.addPassword( enc.encrypt( newPass ));
		} catch ( Exception e ) {
			
			e.printStackTrace();
		}

		return new Usuario();
	}
}
