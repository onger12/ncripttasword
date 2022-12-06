package interfaz;

import java.util.Scanner;

public class Menu {
	
	Scanner sc;
	
	public Menu () {
		sc = new Scanner(System.in);
	}
	
	public String input(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
}
