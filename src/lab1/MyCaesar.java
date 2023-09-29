package lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the
//	ALPHABET
	// array
	public char encryptChar(char c) {
		char result = 0;
		int temp = -1;
		for (int i = 0; i < ALPHABET.length; i++) {

			if (c == ALPHABET[i]) {

				temp = i;
				temp = (temp + this.n) % 26;

				result = ALPHABET[temp];
				break;
			}

		}
		return result;
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in
	// the ALPHABET array
	public char decryptChar(char c) {
		char result = 0;
		int temp = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				temp = i;
				temp = (temp - this.n) % 26;
				result = ALPHABET[temp];
				break;
			}

		}
		return result;
	}

	public String encrypt(String text) {
		String result = "";

		for (int i = 0; i < text.length(); i++) {

			char c = text.charAt(i);

			for (int j = 0; j < ALPHABET.length; j++) {
				if (c == ' ') {
					result += ' ';
					break;
				}
				if (c == ALPHABET[j]) {
					int temp = j;
					temp = (temp + this.n) % 26;
					result += ALPHABET[temp];
					break;
				}

			}

		}

		return result;

	}

	public String decrypt(String text) {
		String result = "";

		for (int i = 0; i < text.length(); i++) {

			char c = text.charAt(i);

			for (int j = 0; j < ALPHABET.length; j++) {
				if (c == ' ') {
					result += ' ';
					break;
				} else if (c == ALPHABET[j]) {
					int temp = j;
					temp = (temp - this.n) % 26;
					result += ALPHABET[temp];
					break;
				}

			}

		}
		return result;
	}
	// Encrypt a encrypted the text content in the srcfile and save it into
	// desFile.

	public void encrypt(String srcFile, String desFile) throws IOException {

		StringBuilder stringFile = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(srcFile));
			String line;

			while ((line = reader.readLine()) != null) {
				stringFile.append(line);
				stringFile.append("\n");
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		String input = stringFile.toString();

		String result = "";
		for (int i = 0; i < input.length(); i++) {

			char c = input.charAt(i);

			for (int j = 0; j < ALPHABET.length; j++) {
				if (c == ' ') {
					result += ' ';
					break;
				} else if (c == ALPHABET[j]) {
					int temp = j;
					temp = (temp + this.n) % 26;
					result += ALPHABET[temp];
					break;
				}

			}

		}
		System.out.println(result);
		writeText(desFile, result);
	}
	// Decrypt a encrypted the text content in the srcfile and save it
	// into desFile.

	public void decrypt(String srcFile, String desFile) throws IOException {
		StringBuilder stringFile = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(srcFile));
			String line;

			while ((line = reader.readLine()) != null) {
				stringFile.append(line);
				stringFile.append("\n");
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
		String input = stringFile.toString();

		String result = "";
		for (int i = 0; i < input.length(); i++) {

			char c = input.charAt(i);

			for (int j = 0; j < ALPHABET.length; j++) {
				if (c == ' ') {
					result += ' ';
					break;
				} else if (c == ALPHABET[j]) {
					int temp = j;
					temp = (temp - this.n) % 26;
					result += ALPHABET[temp];
					break;
				}

			}

		}
		System.out.println(result);
		writeText(srcFile, result);
	}

	public static void writeText(String fileName, String data) throws IOException {
		try {

			FileWriter writer = new FileWriter(fileName, true);
			writer.write(data);
			writer.write("\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		MyCaesar myCaesar = new MyCaesar(3);
		System.out.println(myCaesar.encryptChar('Z'));
		System.out.println(myCaesar.encrypt("HELLO"));
		System.out.println(myCaesar.decrypt("KHOOR"));

		myCaesar.encrypt("data", "storage");
		myCaesar.decrypt("data", "storage");

	}

}
