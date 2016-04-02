package com.supinfo.window;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.supinfo.classes.Block;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pan = new JPanel();
	private JButton button = new JButton("Generate");
	private JLabel lvl = new JLabel("Choose your level");
	private String[] messageStrings = {"facile", "normal", "difficile"};
	private JComboBox<String> cmbMessageList = new JComboBox<String>(messageStrings);
	//private JLabel lblText = new JLabel();
	
	private Block[] blocks = new Block [9];

	public Window(String arg) {
		this.setTitle(arg);
		this.setSize(480, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = new Block();
		}
		

		this.generate();
		
	}
	
	public void generate(){
		 
		pan.setLayout(null);

		cmbMessageList.setBounds(220, 20, 100, 25);	  
		button.setBounds(350, 20, 100, 25);
		lvl.setBounds(100, 20, 100, 30);
		
		// Setup Blocks //
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				blocks[3*i + j].generate(i, j, pan);
			}
		}
		
		// End Stup Blocks
		  
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

