package com.supinfo.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogBox extends JFrame implements ActionListener{
	

	private JPanel pan = new JPanel();
	private String[] messageInt = {"Easy", "Medium", "Hard"};
	private JComboBox<String> cmbIntList = new JComboBox<String>(messageInt);
	private JButton buttonYes = new JButton("Yes");
	private JButton buttonNo = new JButton("No");
	private JLabel enterNumber = new JLabel("Enter a number");

	public DialogBox(){
		this.setSize(480, 600);
		this.setVisible(true);
		
		this.generateGraphic();
		
		
	}
	public void generateGraphic(){
		 
		pan.setLayout(null);
		
		
		cmbIntList.setBounds(220, 20, 100, 25);	  
		buttonNo.setBounds(350, 20, 100, 25);
		buttonYes.setBounds(350, 20, 100, 25);	
		enterNumber.setBounds(100, 50, 60, 30);
		
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
