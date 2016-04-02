package com.supinfo.classes;

import javax.swing.JPanel;

public class Block {
	
	private Digit[] digits = new Digit[9];

	public Block() {
		super();
		
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new Digit();
		}
	}
	
	public void generate(int x, int y, JPanel pan){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				digits[3*i + j].generate(i, j, x * 120, y * 120, pan);
			}
		}
	}

}