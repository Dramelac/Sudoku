package com.supinfo.window;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogBox extends JFrame implements ActionListener{
	
	
	private String[] messageInt = {"Easy", "Medium", "Hard"};
	private JComboBox<String> cmbIntList = new JComboBox<String>(messageInt);
	private JButton buttonYes = new JButton("Yes");
	private JButton buttonNo = new JButton("No");
	private JLabel lblText = new JLabel();

	public DialogBox(String arg){
		this.setTitle(arg);
		this.setSize(480, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
