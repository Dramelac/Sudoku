package com.supinfo.classes;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Block {

	private Digit[] digits = new Digit[9];
	private int x;
	private int y;

	public Block() {
		super();

		// Build all digits
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new Digit();
		}
	}

	public void generateGraphic(int x, int y, JPanel pan) {
		this.x = x;
		this.y = y;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				digits[3 * i + j].generateGraphic(i, j, x * 120, y * 120, pan);
			}
		}
	}
	
	public void setupLine(int line){
		for (int i = 0; i < 3; i++) {
			selectNumber(3*line + i);
		}
	}
	
	public void selectNumber(int i){
		ArrayList<Integer> mylist = getNumbersAvailableInBlock();
		
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(mylist.size());
        digits[i].setValue(mylist.get(index));
	}
	
	public ArrayList<Integer> getNumbersAvailableInBlock(){
		ArrayList<Integer> listInt = new ArrayList<Integer>(9);
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		listInt.add(5);
		listInt.add(6);
		listInt.add(7);
		listInt.add(8);
		listInt.add(9);
		
		for (Digit digit : digits) {
			int i = digit.getValue();
			listInt.remove((Integer) i);
		}
		System.out.println(listInt);
		return listInt;
	}

}
