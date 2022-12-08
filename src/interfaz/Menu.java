package interfaz;

import java.util.Scanner;

import main.Encriptador;

public class Menu {
	
	Scanner sc;
	Encriptador enc;
	String menu_msg;
	
	public Menu () {
		sc = new Scanner(System.in);
		enc = new Encriptador();
		menu_msg = "*** MENU PRINCIPAL ***\n"
				 + "1. Asignacion de contraseña\n"
				 + "2. Cambio de contraseña\n"
				 + "3. Consultar contraseña\n"
				 + "4. Desencriptar contraseña\n"
				 + "0. Salir\n"
				 + "-> ";
	}
	
	public String input(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	public void output(String msg) {
		System.out.println(msg);
	}
	
	public String menu() {
		System.out.print( menu_msg );
		return sc.next();
	}

	public String asignarContra(String currentPass, double diffRefernece) {
		while(true){
			String newPass1 = input("Ingrese una nueva contraseña: ");
			String newPass2 = input("Ingresela de nuevo: ");

			if(newPass1.equals(newPass2)){
				if(enc.validarPass(newPass1)){
					double nivelDiferencia = enc.findSimilarity(newPass1, currentPass);
					System.out.println(nivelDiferencia + " " + diffRefernece);
					if(nivelDiferencia < diffRefernece) { //valida si no se parece
						output("Contraseña cambiada correctamente.\n");
						return newPass1;
					}else{
						output("La contraseña debe tener un mayor nivel de diferencia con respecto a la anterior");
					}
				}else {
					output("Formato de contraseña no válido.\nRecuerde que debe tener mas de 8 caracteres y contener al menos un mayuscula, una minuscula y un caracter especial\n\n");
				}
			}else {
				output("Las contraseñas no coinciden, intentelo de nuevo.\n");
			}	
		}
	}

	public String resetPassword(String currentPass, double diffRefernece) {
		while(true){
			String _currentPass = input("Ingrese la contraseña actual: ");

			if(_currentPass.equals(currentPass)) {
				output("Contraseña correcta.\n");
				break;
			}else{
				output("La contraseña ingresada es incorrecta, intentalo de nuevo!\n");
			}
		}
		return asignarContra(currentPass, diffRefernece);
		
	}
}
