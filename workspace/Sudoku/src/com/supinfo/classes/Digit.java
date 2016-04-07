package com.supinfo.classes;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.supinfo.window.DialogBox;

public class Digit implements ActionListener{
	
	private int value = 0;
	private int myValue = 0;
	private boolean toGuess = true;
	private JButton button = new JButton();
	private Block parent;
	
	
	public Digit() {
		super();
		button.setBorder(new LineBorder(Color.gray, 1));
	}
	
	public void generateGraphic(int x, int y, int a, int b, JPanel pan, Block parent){
		this.toGuess = true;
		this.parent = parent;
		button.setBounds(y*35 + 60 + a, x*35 + 150 + b, 30, 30);
		button.addActionListener(this);

		pan.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == button && toGuess){
			DialogBox choose = new DialogBox(this);
			choose.setVisible(true);
		}
	}
	
	public void askCheck(){
		parent.askCheck();
	}
	
	
	public void reset(){
		this.value = 0;
		button.setBorder(new LineBorder(Color.gray, 1));
		this.toGuess = true;
		button.setText("");
	}
	
	public void offer(){
		this.setMyValue(value);
		this.toGuess = false;
		button.setBorder(new LineBorder(Color.DARK_GRAY, 1));
	}
	

	public int getValue() {
		return value;
	}

	
	public void setValue(int value) {
		this.value = value;
		
	}
	
	public int getMyValue() {
		return this.myValue;
	}

	public void setMyValue(int myValue) {
		this.myValue = myValue;
		button.setText(Integer.toString(this.myValue));
	}

	
	
}
