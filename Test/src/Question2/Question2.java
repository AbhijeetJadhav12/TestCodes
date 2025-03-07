package Question2;

import java.io.*;
import java.util.*;

public class Question2 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println();
			System.out.println("1 duplicate words");
			System.out.println("2 Count digit, char and wovel, consonant");
			System.out.println("3 Extract digit sum");
			System.out.println("Enter choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				File f = new File("D://practise//abc.txt");
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				int length = (int) f.length();

				String line = br.readLine();

				String[] words = line.toLowerCase().split(" ");
				int count[] = new int[words.length];
				for (int i = 0; i < words.length; i++) {
					if (count[i] == -1) {
						continue;
					}
					count[i] = 1;
					for (int j = i + 1; j < words.length; j++) {
						if (words[i].equals(words[j])) {
							count[i]++;
							count[j] = -1;
						}
					}
				}

				System.out.println("\nDuplicate words in the string:");
				for (int i = 0; i < words.length; i++) {
					if (count[i] > 1) {
						System.out.println(words[i] + " : " + count[i]);
					}
				}
				System.out.println("Words Count Case 4: "+words.length);
				br.close();
				fr.close();
				break;
			case 2:
				int vowels = 0, consonants = 0, digits = 0;
				File f1 = new File("D://practise//abc.txt");
				FileReader fr1 = new FileReader(f1);
				BufferedReader br1 = new BufferedReader(fr1);
				String line1 = br1.readLine();

				int charCount = 0;
				for (int i = 0; i < line1.length(); i++) {
					char ch = line1.charAt(i);
					if (ch >= '0' && ch <= '9') {
						digits++;
					} else if (ch >= 'a' && ch <= 'z') {
						if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
							vowels++;
							charCount++;
						} else {
							consonants++;
							charCount++;
						}
					}
				}
				System.out.println("Char count:(Case 4) " + charCount);
				System.out.println("\nVowel Count: " + vowels);
				System.out.println("Consonant Count: " + consonants);
				System.out.println("Digit Count: " + digits);
				break;

			case 3:
				f = new File("D://practise//abc.txt");
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				line = br.readLine();
				int sum = 0;
				for (int i = 0; i < line.length(); i++) {
					char ch = line.charAt(i);
					if (ch >= '0' && ch <= '9') {
						sum += (ch - '0');
					}
				}

				System.out.println("\nSum of Digits: " + sum);
				break;

			case 4:
				System.exit(0);
			default:
				System.out.println("wrong choice");
			}
		} while (true);
	}
}