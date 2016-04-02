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
	
	public void generate(int x, int y, JPanel pan){
		button.setBounds(x*25 + 15, y*25 + 100, 20, 20);
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
