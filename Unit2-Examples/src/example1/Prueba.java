package example1;

import java.util.Scanner;

public class Prueba extends Thread {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int edad;
		System.out.println("Dime la edad");
		edad = sc.nextInt();
		System.out.println("Su edad es: " + edad);
	}

}
