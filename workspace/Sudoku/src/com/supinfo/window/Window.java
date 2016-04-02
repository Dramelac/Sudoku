package com.supinfo.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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
		lblText.setBounds(150, 70, 300, 30);;
		
		button.addActionListener(this);
		
		// Setup Blocks //
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				blocks[3*i + j].generateGraphic(i, j, pan, this);
			}
		}
		
		// End Setup Blocks
		  
		pan.add(cmbMessageList);
		pan.add(lvl);
		pan.add(lblText);
		pan.add(button);

		  
		this.setContentPane(pan);
	}
	
	private void createGameBoard(int level){
		int tourn = 0;
		while (true) {
			try {
				for (int blockLine = 0; blockLine < 3; blockLine++) {
					for (int line = 0; line < 3; line++) {
						for (int blockColone = 0; blockColone < 3; blockColone++) {
								blocks[3*blockLine + blockColone].setupLine(line);
						}
					}
				}
				break;
			} catch (Exception e) {
				reset();
				tourn++;
			}
		}
		
		
		lblText.setText("Let's go, Nombre d'essai : " + tourn);
	}
	
	
	public ArrayList<Integer> getAvailableAt(int BlockX, int BlockY, int DigitX, int DigitY){
		
		System.out.println("Block " + BlockX + "/" + BlockY + " || Digit selct : " + DigitX + "/" + DigitY);
		ArrayList<Integer> blockArray = blocks[BlockX*3 + BlockY].getNumbersAvailableInBlock();
		ArrayList<Integer> lineArray = this.getLineArray(3*BlockX, DigitX);
		ArrayList<Integer> coloneArray = this.getColoneArray(BlockY, DigitY);
		//System.out.println(coloneArray);
		
		return intersection(blockArray, intersection(lineArray, coloneArray));
	}
	
	
	private ArrayList<Integer> getLineArray(int Blockline, int digitLine){
		ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> temp = blocks[Blockline + i].getLine(digitLine);
			for (Integer integer : temp) {
				listInt.remove(integer);
			}
		}
		
		return listInt;
	}
	
	private ArrayList<Integer> getColoneArray(int BlockColone, int digitColone){
		ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> temp = blocks[BlockColone + 3*i].getColone(digitColone);
			for (Integer integer : temp) {
				listInt.remove(integer);
			}
		}
		
		return listInt;
	}
	
	
	public ArrayList<Integer> intersection(ArrayList<Integer> listA, ArrayList<Integer> listB){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (Integer number : listA) {
			if (listB.contains(number)) {
				list.add(number);
			}
		}
		
		return list;
	}
	
	public void reset(){
		for (Block block : blocks) {
			block.reset();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
	 	if (source == button){
	 		reset();
	 		createGameBoard(cmbMessageList.getSelectedIndex());
	 	}
	}
	 	

}

