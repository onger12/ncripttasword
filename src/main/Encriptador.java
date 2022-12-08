package main;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class Encriptador {
	
	private final static String alg = "AES";
	private final static String cI = "AES/CBC/PKCS5Padding";
	String base_mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String base_minus = "abcdefghijklmnopqrstuvwxyz";
	String base_special_chars = "@$%-_.,:;+*}{[]";
	String base_nums  = "0123456789";
	
	String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" 
				+ "abcdefghijklmnopqrstuvwxyz"
				+ "@$%-_.,:;+*}{[]=!'#&/|°"
				+ "0123456789";
	
	String key = "92AE31A79FEEB2A3"; // llave
	String iv = "0123456789ABCDEF"; // vector de inicialización
	
	
	public String generateRandomPass(int i) {
		
		StringBuilder builder = new StringBuilder(i);

        for (int m = 0; m < i; m++) {
            int myindex = (int)(base.length() * Math.random());
            builder.append(base.charAt(myindex)); 
        } 

        return builder.toString(); 
	}
 
    public String encrypt(String text) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            return new String(encodeBase64(encrypted));
    }
    
    public String decrypt(String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
    
    public boolean validarPass(String pass) {
		boolean mayus = false; 
		boolean minus = false; 
		boolean specialChars = false;
		boolean nums = false;
		
		if(pass.length() < 8) return false;
		
		for (int i = 0; i < pass.length(); i++) {
		   if( base_mayus.contains( pass.charAt( i ) + "" )) {
			   mayus = true;
			   break;
		   }
		}
		
		for (int i = 0; i < pass.length(); i++) {
		   if( base_minus.contains( pass.charAt( i ) + "" )) {
			   minus = true;
			   break;
		   }
		}
		
		for (int i = 0; i < pass.length(); i++) {
			if( base_special_chars.contains( pass.charAt( i ) + "" )) {
				specialChars = true;
				break;
			}
		}

		for (int i = 0; i < pass.length(); i++) {
			if( base_nums.contains( pass.charAt( i ) + "" )) {
				nums = true;
				break;
			}
		}
		
		System.out.println("mayus " + mayus);
		System.out.println("mayus " + minus);
		System.out.println("specialChars " + specialChars);
		System.out.println("nums " + nums);

		return (mayus && minus && specialChars && nums);
	}


	public int getLevenshteinDistance(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();
 
        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            T[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            T[0][j] = j;
        }
 
        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cost = X.charAt(i - 1) == Y.charAt(j - 1) ? 0: 1;
                T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                        T[i - 1][j - 1] + cost);
            }
        }
 
        return T[m][n];
    }
 
    public double findSimilarity(String x, String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Los strings no pueden ser nulos");
        }
        
        double maxLength = Double.max(x.length(), y.length());

        if (maxLength > 0) {
            return (maxLength - getLevenshteinDistance(x, y)) / maxLength;
        }

        return 1.0;
    }
}
