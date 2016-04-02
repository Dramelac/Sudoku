package com.supinfo.classes;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.supinfo.window.DialogBox;

public class Digit implements ActionListener{
	
	private int value = 0;
	private JButton button = new JButton();
	
	
	public Digit() {
		super();
		Border thickBorder = new LineBorder(Color.gray, 1);
		button.setBorder(thickBorder);
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
			DialogBox choose = new DialogBox(this);
			choose.setVisible(true);
		}
	}

	public int getValue() {
		return value;
	}

	
	public void setValue(int value) {
		this.value = value;
		button.setText(Integer.toString(this.value));
		
	}
	
	
}
