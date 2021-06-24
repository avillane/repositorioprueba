package com.everis.utils;

public class Utilitario {

	public static int suma(int a, int b) {
		return a + b;
	}
	
	public static int resta(int a, int b) {
		return a - b;
	}
	
	public static int dividir(int a, int b) {
		if(b==0) {
			throw new ArithmeticException("no se puede dividir por cero");
		}
		return a / b;
	}
	
	public void operacionOptima() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
