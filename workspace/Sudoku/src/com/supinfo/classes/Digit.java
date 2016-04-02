package com.supinfo.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Digit implements ActionListener{
	
	private int value = 0;
	private JButton button = new JButton();
	
	
	public Digit() {
		super();
	}
	
	public void generate(int x, int y, int a, int b, JPanel pan){
		button.setBounds(x*35 + 60 + a, y*35 + 150 + b, 30, 30);
		button.addActionListener(this);
		
		pan.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == button){
			
		}
	}
	
	
}