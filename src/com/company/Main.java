package com.company;

import java.util.Scanner;

public class Main {

	public static int k;
	public static int residual;
	public static int radix;
	public static String str;

	public static void main(String[] args) {
		System.out.println("Здравствуйте, программа осуществляет перевод из 10 "
				+ "системы счисления"
				+ " в 3 и 17, либо из 3 и 17 в 10.\n"
				+ "Введите исходную систему счисления:");

		Scanner scanner = new Scanner(System.in);
		String radix = scanner.nextLine();

		int intRadix = Integer.parseInt(radix);

		if (intRadix != 3 && intRadix != 17 && intRadix != 10) {
			System.out.println("Неизвестная программе система счисления!");
			return;
		}

		System.out.println("Введите число:");

		String strNumber = scanner.nextLine();

		if (intRadix == 10) {
			int number = Integer.parseInt(strNumber);

			System.out.println("Введите систему счисления, в которую будет "
					+ "осуществлен перевод:");

			String strRadixForShift = scanner.nextLine();

			int radixForShift = Integer.parseInt(strRadixForShift);

			if (radixForShift == 3) {
				str = desIntoThird(number);

				String CONVERT_2 = new StringBuffer(str).
						reverse().toString();
				System.out.println(CONVERT_2);
			} else if (radixForShift == 17) {
				str = desIntoSev(number);

				String CONVERT_1 = new StringBuffer(str).
						reverse().toString();
				System.out.println(CONVERT_1);
			} else if (radixForShift == 10) {
				System.out.println(number + " - уже является числом в десятичной системе счисления.");
			} else {
				System.out.println("Перевод в эту систему счисления невозможен в "
						+ "рамках этой программы.\n"
						+ "Выберите перевод либо в 3, либо в 17 систему счисления");
			}
		} else {
			System.out.println(toDes(strNumber, intRadix));
		}

	}

	/**
	 * Метод возвращает по переданному ключу конвертированное значение для перевода из 17 системы счисления
	 *
	 * @param key
	 * @return String key
	 */
	public static String convert(String key) {
		if (key.equals("A")) {
			return "10";
		} else if (key.equals("B")) {
			return "11";
		} else if (key.equals("C")) {
			return "12";
		} else if (key.equals("D")) {
			return "13";
		} else if (key.equals("E")) {
			return "14";
		} else if (key.equals("F")) {
			return "15";
		} else if (key.equals("G")) {
			return "16";
		}

		return key;

	}

	/**
	 * Метод выполняет перевод из 10 в 17 систему счисления
	 *
	 * @param number
	 * @return String str
	 */
	public static String desIntoSev(int number) {
		k = 1;
		radix = 17;
		str = "";

		System.out.println(number + " в семнадцатиричной системе:");

		while (k > 0) {
			k = number / radix;
			residual = number % radix;

			if (residual > 9 && residual < 17) {
				switch (residual) {
					case 10:
						str += "A";
						break;
					case 11:
						str += "B";
						break;
					case 12:
						str += "C";
						break;
					case 13:
						str += "D";
						break;
					case 14:
						str += "E";
						break;
					case 15:
						str += "F";
						break;
					case 16:
						str += "G";
						break;
				}
			} else {
				str += residual;
			}
			number = k;
		}

		return str;

	}

	/**
	 * Метод выполняет перевод из 10 в 3 систему счисления
	 *
	 * @param number
	 * @return String str
	 */
	public static String desIntoThird(int number) {
		k = 1;
		radix = 3;
		str = "";

		System.out.println(number + " в троичной системе:");

		while (k > 0) {
			k = number / radix;
			residual = number % radix;
			str += residual;
			number = k;
		}

		return str;

	}

	/**
	 * Метод выполняет перевод в 10 систему из 3 и 17
	 *
	 * @param num
	 * @param radix
	 * @return String result
	 */
	public static String toDes(String num, int radix) {
		String result;

		num = num.toUpperCase();

		String number = new StringBuffer(num).reverse().toString();
		String[] array = number.split("(?<=\\G.{1})");

		if (radix == 17) {
			for (int n = 0; n < array.length; n++) {
				array[n] = convert(array[n]);
			}
		}

		int rez = 0;
		int per;

		for (int n = 0; n < array.length; n++) {
			per = Integer.parseInt(array[n]);
			if (radix == 3 && per > 2) {
				return "Введенное число не является числом троичной системы счисления.";
			} else {
				rez += per * Math.pow(radix, n);
			}

		}

		System.out.println("Число " + num + " в десятичной системе счисления:");

		result = String.valueOf(rez);

		return result;

	}


}
