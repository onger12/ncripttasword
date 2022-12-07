package usuario;

import java.util.ArrayList;

public class Usuario {

	private ArrayList<String> passwords;

	public Usuario() {
		passwords = new ArrayList<String>();
	}

	public ArrayList<String> getPasswords() {
		return passwords;
	}

	public void setPasswords(ArrayList<String> passwords) {
		this.passwords = passwords;
	}

	public void addPassword(String password) {
		this.passwords.add(password);
	}
	
	
	
}
