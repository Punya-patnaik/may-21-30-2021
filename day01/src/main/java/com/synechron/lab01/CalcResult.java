package com.synechron.lab01;

import java.util.List;

public class CalcResult {
	private String operation;
	private List<Integer> numbers;
	private int result;
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public List<Integer> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
