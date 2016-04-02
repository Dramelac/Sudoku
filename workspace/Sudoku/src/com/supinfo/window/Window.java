package com.supinfo.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame {
	
	private JPanel pan = new JPanel();
	private JButton button = new JButton("Generate");
	private JLabel lvl = new JLabel("Choose your level");
	private String[] messageStrings = {"facile", "normal", "difficile"};
	private JComboBox<String> cmbMessageList = new JComboBox<String>(messageStrings);
	private JLabel lblText = new JLabel();

	public Window(String arg) {
		// TODO Auto-generated constructor stub
		this.setTitle(arg);
		this.setSize(640, 480);
		this.setVisible(true);
		this.generate();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void generate(){
		 
		pan.setLayout(null);

		cmbMessageList.setBounds(220, 20, 100, 25);	  
		button.setBounds(350, 20, 100, 25);
		lvl.setBounds(100, 20, 100, 30);
		  
		pan.add(cmbMessageList);
		pan.add(lvl);
		pan.add(button);

		  
		this.setContentPane(pan);
	}
	/*	 
	@Override
		public void actionPerformed(ActionEvent e){
			 Object source = e.getSource();
			 	if (source == button){
			 		if (inputUser.getText().equals("admin") && String.valueOf(inputPwd.getPassword()).equals("admin")){
			 			hiddentext.setText("Welcome");
			 			success.active(inputUser.getText(), this);
			 			success.setVisible(true);
			 			this.setVisible(false);
			 			//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			 			//JOptionPane.showMessageDialog(this, "Correct  password.");
			 		} else {
			 			hiddentext.setText("Bad password");
			 			//JOptionPane.showMessageDialog(this, "Incorrect  password.");
			 	}
			 }
		 }		 		 
	*/

}

