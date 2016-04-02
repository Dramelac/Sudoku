package com.supinfo.window;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogBox extends JFrame implements ActionListener{
	

	private JPanel pan = new JPanel();
	private String[] messageInt = {"1","2","3","4","5","6","7","8","9"};
	private JComboBox<String> cmbIntList = new JComboBox<String>(messageInt);
	private JButton buttonYes = new JButton("Yes");
	private JButton buttonNo = new JButton("No");
	private JLabel enterNumber = new JLabel("Enter a number");
	

	public DialogBox(){
		this.setSize(200, 138);
		this.setVisible(true);
		this.setLocation(140,231);
		this.generateGraphic();
		
		
		
	}
	public void generateGraphic(){
		 
		pan.setLayout(null);
		
		
		cmbIntList.setBounds(75, 35, 50, 25);	  
		buttonNo.setBounds(92, 75, 92, 25);
		buttonYes.setBounds(0, 75, 92, 25);	
		enterNumber.setBounds(50, 0, 180, 30);
		
		pan.add(cmbIntList);
		pan.add(buttonNo);
		pan.add(buttonYes);
		pan.add(enterNumber);
		
		this.setContentPane(pan);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
