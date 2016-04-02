package com.supinfo.classes;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.supinfo.window.DialogBox;

public class Digit implements ActionListener{
	
	private int value = 0;
	private JButton button = new JButton();
	
	
	public Digit() {
		super();
	}
	
	public void generateGraphic(int x, int y, int a, int b, JPanel pan){
		button.setBounds(x*35 + 60 + a, y*35 + 150 + b, 30, 30);
		button.addActionListener(this);
		
		pan.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == button){
			DialogBox choose = new DialogBox();
		}
	}

	public int getValue() {
		return value;
	}

	
	public void setValue(int value) {
		this.value = value;
		String temp = Integer.toString(this.value);
		System.out.println(temp);
		button.setText(temp);
	}
	
	
}
