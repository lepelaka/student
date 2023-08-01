package student.util;

import java.util.Scanner;

import student.exception.RangeException;

public class StudentUtils {
	private static Scanner scanner = new Scanner(System.in);

	public static String nextLine(String msg) {
		System.out.print(msg);
		return scanner.nextLine(); // °¡
	}

	public static int nextInt(String msg) {
		return Integer.parseInt(nextLine(msg));
	}

	public static boolean chkHangle(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '°¡' || str.charAt(i) > 'ÆR') {
				return false;
			}
		}
		return true;
	}

	public static int chkRange(int value) {
		return chkRange(0, 100, value);
	}

	public static int chkRange(int start, int end, int value) {
		if (value < start || value > end) {
			throw new RangeException();
		}
		return value;
	}

}
