package br.com.guilherme.math;

public class SimpleMath {

	
	public Double sum(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	public Double sub(Double firstNumber, Double secondNumber) {
		return firstNumber - secondNumber;
	}
	
	public Double mul(Double firstNumber, Double secondNumber) {
		return firstNumber * secondNumber;
	}
	
	public Double div(Double firstNumber, Double secondNumber) {
		return firstNumber / secondNumber;
	}
	
	public Double mean(Double firstNumber, Double secondNumber) {
		return (firstNumber + secondNumber) /2;
	}
	
	public Double squ(Double number) {
		return (Double) Math.sqrt(number);
	}
}
