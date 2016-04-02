package com.supinfo.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.supinfo.classes.Digit;

public class DialogBox extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pan = new JPanel();
	private String[] messageInt = {"1","2","3","4","5","6","7","8","9"};
	private JComboBox<String> cmbIntList = new JComboBox<String>(messageInt);
	private JButton buttonYes = new JButton("Yes");
	private JButton buttonNo = new JButton("No");
	private JLabel enterNumber = new JLabel("Enter a number");
	
	private Digit digit;
	

	public DialogBox(Digit digit){
		this.setSize(200, 138);
		this.setVisible(true);
		this.setLocation(140,231);
		this.generateGraphic();
		
		this.digit = digit;
		
		
	}
	public void generateGraphic(){
		 
		pan.setLayout(null);
		
		
		cmbIntList.setBounds(75, 35, 50, 25);	  
		buttonNo.setBounds(0, 75, 92, 25);
		buttonYes.setBounds(92, 75, 92, 25);	
		enterNumber.setBounds(50, 0, 180, 30);
		
		buttonNo.addActionListener(this);
		buttonYes.addActionListener(this);
		
		pan.add(cmbIntList);
		pan.add(buttonNo);
		pan.add(buttonYes);
		pan.add(enterNumber);
		
		this.setContentPane(pan);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == buttonNo){			
			this.setVisible(false);
			
		} else if (source == buttonYes) {
			digit.setValue(cmbIntList.getSelectedIndex()+1);
			this.setVisible(false);
		}
		
	}

}
