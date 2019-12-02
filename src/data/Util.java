package data;

import java.util.Random;

public class Util {
	public static String randomString(int t) {
		Random r = new Random();
		String alpha = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		char[] array = new char[t];
		for (int i = 0; i < array.length; i++) {
			array[i] = alpha.charAt(r.nextInt(62));
		}
		return new StringBuilder().append(array).toString();
	}

	public static int randomBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}