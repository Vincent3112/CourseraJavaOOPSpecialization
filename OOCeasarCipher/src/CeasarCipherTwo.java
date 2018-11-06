public class CeasarCipherTwo {

	private String alphabet = "ABCDEFGKIJKLMNOPQRSTUVWXYZ";
	private String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	private String shiftedAlphabetKey1;
	private String shiftedLowerAlphabetKey1;
	private String shiftedAlphabetKey2;
	private String shiftedLowerAlphabetKey2;
	private int mainKey1;
	private int mainKey2;
	
	CeasarCipherTwo(int key1, int key2){
		
		shiftedAlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0, key1);
		shiftedLowerAlphabetKey1 = lowerAlphabet.substring(key1) + lowerAlphabet.substring(0, key1);
		shiftedAlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0, key2);
		shiftedLowerAlphabetKey2 = lowerAlphabet.substring(key2) + lowerAlphabet.substring(0, key2);
		mainKey1 = key1;
		mainKey2 = key2;
	}
	
	public String encryptTwoKeys(String input) {
		
		StringBuilder encrypted = new StringBuilder(input);
		
		for (int i = 0; i < encrypted.length(); i+=2) {
			char currChar = encrypted.charAt(i);
			if (Character.isLowerCase(currChar)) {
				int idxl = lowerAlphabet.indexOf(currChar);
				if (idxl != -1) {
					char newChar = shiftedLowerAlphabetKey1.charAt(idxl);
					encrypted.setCharAt(i,  newChar);
				}
			}
			else {
				int idx = alphabet.indexOf(currChar);
				if (idx != -1) {
					char newChar = shiftedAlphabetKey1.charAt(idx);
					encrypted.setCharAt(i,  newChar);
				}
			}
		}
		for (int i = 1; i < encrypted.length(); i+=2) {
			char currChar = encrypted.charAt(i);
			if (Character.isLowerCase(currChar)) {
				int idxl = lowerAlphabet.indexOf(currChar);
				if (idxl != -1) {
					char newChar = shiftedLowerAlphabetKey2.charAt(idxl);
					encrypted.setCharAt(i,  newChar);
				}
			}
			else {
				int idx = alphabet.indexOf(currChar);
				if (idx != -1) {
					char newChar = shiftedAlphabetKey2.charAt(idx);
					encrypted.setCharAt(i,  newChar);
				}
			}
		}
		return encrypted.toString();
	}
	
	public String decryptTwoKeys(String input) {
		CeasarCipherTwo cc = new CeasarCipherTwo(26 - mainKey1, 26 - mainKey2);
		return cc.encryptTwoKeys(input);
	}
	
public static void main(String args[]) {
		
		CeasarCipherTwo cesar = new CeasarCipherTwo(21, 8);
		System.out.println(cesar.encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
		System.out.println(cesar.decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx"));
	}
}