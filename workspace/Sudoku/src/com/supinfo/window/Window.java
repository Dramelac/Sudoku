package com.supinfo.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.supinfo.classes.Block;

public class Window extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pan = new JPanel();
	private JButton button = new JButton("Generate");
	private JLabel lvl = new JLabel("Choose your level");
	private String[] messageStrings = {"Easy", "Medium", "Hard"};
	private JComboBox<String> cmbMessageList = new JComboBox<String>(messageStrings);
	private JLabel lblText = new JLabel();
	
	private Block[] blocks = new Block [9];

	public Window(String arg) {
		this.setTitle(arg);
		this.setSize(480, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Build all objects
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = new Block();
		}

		this.generateGraphic();
		
	}
	
	public void generateGraphic(){
		 
		pan.setLayout(null);

		cmbMessageList.setBounds(220, 20, 100, 25);	  
		button.setBounds(350, 20, 100, 25);
		lvl.setBounds(100, 20, 100, 30);
		lblText.setBounds(200, 70, 60, 30);
		
		button.addActionListener(this);
		
		// Setup Blocks //
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				blocks[3*i + j].generateGraphic(i, j, pan);
			}
		}
		
		// End Stup Blocks
		  
		pan.add(cmbMessageList);
		pan.add(lvl);
		pan.add(lblText);
		pan.add(button);

		  
		this.setContentPane(pan);
	}
	
	private void createGameBoard(int level){
		
		for (int blockLine = 0; blockLine < 3; blockLine++) {
			for (int line = 0; line < 3; line++) {
				for (int blockColone = 0; blockColone < 3; blockColone++) {
					blocks[3*blockLine + blockColone].setupLine(line);
				}
			}
		}
		
		
		lblText.setText("Let's go " + level);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
	 	if (source == button){
	 		createGameBoard(cmbMessageList.getSelectedIndex());
	 	}
	}
	 	

}

