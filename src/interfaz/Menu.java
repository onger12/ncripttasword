package interfaz;

import java.util.Scanner;

public class Menu {
	
	Scanner sc;
	String menu_msg;
	
	public Menu () {
		sc = new Scanner(System.in);
		menu_msg = "*** MENU PRINCIPAL ***\n"
				 + "1. Asignacion de contraseña\n"
				 + "2. Cambio de contraseña\n"
				 + "-> ";
	}
	
	public String input(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public void output(String msg) {
		System.out.println(msg);
	}
	
	public String menu() {
		System.out.print( menu_msg );
		return sc.next();
	}
}
