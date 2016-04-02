package com.supinfo.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;

import com.supinfo.window.Window;

public class Block {

	private Digit[] digits = new Digit[9];
	private int x;
	private int y;
	private Window parent;

	public Block() {
		super();

		// Build all digits
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new Digit();
		}
	}

	public void generateGraphic(int x, int y, JPanel pan, Window parent) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				digits[3 * i + j].generateGraphic(i, j, y * 120, x * 120, pan);
			}
		}
	}
	
	public void setupLine(int line){
		for (int i = 0; i < 3; i++) {
			
			ArrayList<Integer> mylist = parent.getAvailableAt(this.x, this.y, line, i);
			
			selectRandomNumber(3*line + i, mylist);
		}
	}
	
	public void selectRandomNumber(int i,ArrayList<Integer> mylist){
		if (mylist.size() == 0) {
			System.out.println("Error null size random !");
		}
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(mylist.size());
        digits[i].setValue(mylist.get(index));
	}
	
	public ArrayList<Integer> getNumbersAvailableInBlock(){
		ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		for (Digit digit : digits) {
			int i = digit.getValue();
			listInt.remove((Integer) i);
		}
		
		return listInt;
	}
	
	public ArrayList<Integer> getLine(int line){
		ArrayList<Integer> listInt = new ArrayList<Integer>(3);
		
		for (int i = 0; i < 3; i++) {
			listInt.add(digits[line*3 + i].getValue());
		}
		
		return listInt;
	}
	
	public ArrayList<Integer> getColone(int colone){
		ArrayList<Integer> listInt = new ArrayList<Integer>(3);
		
		for (int i = 0; i < 3; i++) {
			listInt.add(digits[colone + 3*i].getValue());
		}
		
		return listInt;
	}
	
	
	public void reset(){
		for (Digit digit : digits) {
			digit.reset();
		}
	}

}
