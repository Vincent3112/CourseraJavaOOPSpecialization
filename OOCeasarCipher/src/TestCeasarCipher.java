public class TestCeasarCipher {

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
//		for(int k = 0; k < counters.length; k++) {
//			System.out.println(alphabet.charAt(k)+"\t"+counters[k]);
//		}
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
		
		CeasarCipher cipher = new CeasarCipher(18);
		String string = "Hi ! This is a test string. I created one because test strings are great and very useful !";
		System.out.println("That is the string we wanna encrypt with a CeasarCipher and the key 18 : " + string);
		String encrypted = cipher.encrypt(string);
		System.out.println("This is the encrypted string : " + encrypted);
		String decrypted = breakCeasarCipher(encrypted);
		System.out.println("This is the decrypted string : " + decrypted);
	}
	
	public String breakCeasarCipher(String input) {
		
		int [] freqs = countLetters(input);
		int maxDex = maxIndex(freqs);
		int dkey = maxDex-4;
		if (maxDex < 4) {
			dkey = 26 - (4-maxDex);
		}
		CeasarCipher cc = new CeasarCipher(26-dkey);
		return cc.encrypt(input);
	}
	
	public static void main(String args[]) {
		
		TestCeasarCipher test = new TestCeasarCipher();
		test.simpleTests();
		System.out.println();
		//System.out.println(test.breakCeasarCipher("Ha ! Lzak s lwkl kljafy. A ujwslwv gfw twusmkw lwkl kljafyk sjw yjwsl sfv nwjq mkwxmd !"));
	}	
}