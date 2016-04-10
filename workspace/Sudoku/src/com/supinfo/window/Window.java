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
	private JButton surrende = new JButton("Surrender");
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

		cmbMessageList.setBounds(200, 20, 85, 25);	  
		button.setBounds(320, 20, 125, 25);	  
		surrende.setBounds(20, 510, 120, 25);
		lvl.setBounds(60, 20, 150, 30);
		lblText.setBounds(200, 70, 300, 30);;
		
		button.addActionListener(this);
		surrende.addActionListener(this);
		surrende.setVisible(false);
		
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
		pan.add(surrende);

		  
		this.setContentPane(pan);
	}
	
	private void createGameBoard(int level){
		// start grid generation
		while (true) {
			try {
				for (int blockLine = 0; blockLine < 3; blockLine++) {
					for (int line = 0; line < 3; line++) {
						for (int blockColone = 0; blockColone < 3; blockColone++) {
								blocks[3*blockLine + blockColone].setupLine(line);
						}
					}
				}
				// grid success
				break;
			} catch (Exception e) {
				// fail ... retry :
				reset();
			}
		}
		
		lblText.setText("Good luck !");
		// apply difficult
		chooseOffer(level);
	}
	
	public void chooseOffer(int level){
		
		for (Block block : blocks) {
			block.chooseStartDigits(level);
		}
	}
	
	public void surrende(){
		lblText.setText("Nice Try ...");
		for (Block block : blocks) {
			block.surrende();
		}
	}
	
	public boolean checkWin(){
		for (int blockX = 0; blockX < 3; blockX++) {
			for (int blockY = 0; blockY < 3; blockY++) {
				for (int digitX = 0; digitX < 3; digitX++) {
					for (int digitY = 0; digitY < 3; digitY++) {
						if (!checkValid(blockX, blockY, digitX, digitY)){
							return false;
						}
					}
				}
			}
		}
		this.lblText.setText("YOU WIN !!");
		return true;
	}
	
	public boolean checkValid(int BlockX, int BlockY, int DigitX, int DigitY){
		ArrayList<Integer> blockArray = blocks[BlockX*3 + BlockY].getMyNumbersAvailableInBlock();
		ArrayList<Integer> lineArray = this.getMyLineArray(3*BlockX, DigitX);
		ArrayList<Integer> coloneArray = this.getMyColoneArray(BlockY, DigitY);
		
		if (blockArray.size() + lineArray.size() + coloneArray.size() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Integer> getAvailableAt(int BlockX, int BlockY, int DigitX, int DigitY){
		
		// all list all parameter
		ArrayList<Integer> blockArray = blocks[BlockX*3 + BlockY].getNumbersAvailableInBlock();
		ArrayList<Integer> lineArray = this.getLineArray(3*BlockX, DigitX);
		ArrayList<Integer> coloneArray = this.getColoneArray(BlockY, DigitY);
		
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
	
	private ArrayList<Integer> getMyLineArray(int Blockline, int digitLine){
		ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> temp = blocks[Blockline + i].getMyLine(digitLine);
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
	
	private ArrayList<Integer> getMyColoneArray(int BlockColone, int digitColone){
		ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> temp = blocks[BlockColone + 3*i].getMyColone(digitColone);
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
			surrende.setVisible(true);
	 	} else if (source == surrende) {
			surrende();
		}
	}
	 	

}

