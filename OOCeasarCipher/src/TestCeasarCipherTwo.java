public class TestCeasarCipherTwo {

	public String halfOfString(String input, int start) {
		
		StringBuilder string = new StringBuilder();
		for (int k = start; k < input.length(); k+=2) {
			string.append(input.charAt(k));					
		}
		return String.valueOf(string);
	}
	
	public int[] countLetters(String message) {
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] counters = new int[26];
		for (int k = 0; k < message.length(); k++) {
			char ch = message.charAt(k);
			int index = alphabet.indexOf(Character.toLowerCase(ch));
			if (index != -1) {
				counters[index]+=1;
			}
		}
		return counters;
	}
	
	public int maxIndex(int[] freqs) {
		int theMaxIndex = 0;
		for (int i = 0; i < freqs.length; i++) {
			if(freqs[i] > freqs[theMaxIndex]) {
				theMaxIndex = i;
			}
		}
		return theMaxIndex;
	}
	
public void simpleTests() {
		
		CeasarCipherTwo cipher = new CeasarCipherTwo(5, 18);
		String string = "Hi ! This is a test string. I created one because test strings are great and very useful !";
		System.out.println("That is the string we wanna encrypt with a CeasarCipher and the keys 5 and 18 : " + string);
		String encrypted = cipher.encryptTwoKeys(string);
		System.out.println("This is the encrypted string : " + encrypted);
		String decrypted = breakCeasarCipher(encrypted);
		System.out.println("This is the decrypted string : " + decrypted);
		
	}

	public String breakCeasarCipher(String input) {
		
		String string1 = halfOfString(input, 0);
		String string2 = halfOfString(input, 1);
		
		int [] freqs1 = countLetters(string1);
		int [] freqs2 = countLetters(string2);
		
		int maxDex1 = maxIndex(freqs1);
		int maxDex2 = maxIndex(freqs2);
		
		int dkey1 = maxDex1-4;
		int dkey2 = maxDex2-18;

		if (maxDex1 < 4) {
			dkey1 = 26 - (4-maxDex1);
		}
		if (maxDex2 < 18) {
			dkey2 = 26 - (18-maxDex2);
		}
		
		CeasarCipherTwo cc = new CeasarCipherTwo(26-dkey1, 26-dkey2);
		return cc.encryptTwoKeys(input);
	}

	public static void main(String args[]) {
		
		TestCeasarCipherTwo test = new TestCeasarCipherTwo();
		test.simpleTests();
		System.out.println();
	}
}