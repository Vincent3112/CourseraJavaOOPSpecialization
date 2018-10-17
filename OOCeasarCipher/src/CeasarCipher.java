public class CeasarCipher {

	private String alphabet;
	private String shiftedAlphabet;
	private String lowerAlphabet;
	private String shiftedLowerAlphabet;
	private int mainKey;
	
	CeasarCipher(int key){
		this.alphabet = "ABCDEFGKIJKLMNOPQRSTUVWXYZ";
		this.shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
		this.lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		this.shiftedLowerAlphabet = lowerAlphabet.substring(key) + lowerAlphabet.substring(0, key);
		mainKey = key;
	}
	
	public String encrypt(String input) {
		
		StringBuilder encrypted = new StringBuilder(input);	
		
		for (int i = 0; i < encrypted.length(); i++) {
			char currChar = encrypted.charAt(i);
			if (Character.isLowerCase(currChar)) {
				int idxl = lowerAlphabet.indexOf(currChar);
				if (idxl != -1) {
					char newChar = shiftedLowerAlphabet.charAt(idxl);
					encrypted.setCharAt(i,  newChar);
				}
			}
			else {
				int idx = alphabet.indexOf(currChar);
				if (idx != -1) {
					char newChar = shiftedAlphabet.charAt(idx);
					encrypted.setCharAt(i,  newChar);
				}
			}
		}
		return encrypted.toString();
	}
	
	public String decrypt(String input) {
		CeasarCipher cc = new CeasarCipher(26 - mainKey);
		return cc.encrypt(input);
	}
	
	public static void main(String args[]) {
		
		CeasarCipher cesar = new CeasarCipher(15);
		//System.out.println(cesar.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15)); // 'o' is the character that occurs the most in this sentence so if you wanna break you will have to replace the 4 with a 14 in the decrypt programm !
		//System.out.println(cesar.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
		System.out.println(cesar.decrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!"));
	}
}