package com.pack.frame.layout;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pack.frame.layout.ErrorToast;


import com.pack.colours.ColorInput;

public class ColorInputFrame {

	public ColorInputFrame(int dimension,int depth,int numOfColor) throws IOException, InterruptedException {
		JTextField [] textFieldTotal = new JTextField[numOfColor*3];
		int counter = 0;
		ColorInput inputColor = new ColorInput(numOfColor);
		JFrame frame = new JFrame("Input Frame");
		
		frame.setSize(350,180+numOfColor*40);
		frame.setBackground(Color.WHITE);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    JPanel panel = new JPanel(); 
	    panel.setLayout(null);
	    
	    JLabel label = new JLabel("Enter colors values"); 
		label.setBounds(100,0,150, 20);
		
		JLabel label2 = new JLabel("RED"); 
		label2.setBounds(50,40,50, 20);
		label2.setForeground(Color.RED);
		
		JLabel label3 = new JLabel("GREEN"); 
		label3.setBounds(140,40,50, 20);
		label3.setForeground(Color.GREEN);

		JLabel label4 = new JLabel("BLUE"); 
		label4.setBounds(250,40,50, 20);
		label4.setForeground(Color.BLUE);

		JButton enterButton = new JButton("Next");
		enterButton.setBounds(250,100+numOfColor*40, 70, 30);

		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(30, 100+numOfColor*40, 70, 30);

		frame.getContentPane().add(panel);
	   
		
		for(int i =0;i<numOfColor;i++) {
			JLabel label5 = new JLabel(Character.toString ((char) (i+65))+" :"); 
			label5.setBounds(10,70+i*40,30,30);

			for(int j=0;j<3;j++) {
				JTextField textBox1=new JTextField();
				textBox1.setBounds(50+j*100,70+i*40,30,30);
				
				textBox1.addKeyListener(new KeyAdapter() {
				    public void keyTyped(KeyEvent e) { 
						if (textBox1.getText().length() >= 3 ) { // limit textfield to 3 characters
					    	new ErrorToast("Out of bounds");
				        	e.consume(); 
						}
				    }  
				});
				
				textBox1.addKeyListener(new KeyAdapter() {
					  public void keyTyped(KeyEvent e) {
						if(!textBox1.getText().isEmpty()) {
						    if (Integer.parseInt(textBox1.getText()) >255) {
					    }
						}
					  }
				});
				
				textBox1.addKeyListener(new KeyAdapter() {
			         public void keyTyped(KeyEvent e) {
			           char c = e.getKeyChar();
			           if (!(Character.isDigit(c) ||
			              (c == KeyEvent.VK_BACK_SPACE) ||
			              (c == KeyEvent.VK_DELETE))) {
					    	new ErrorToast("Insert valid number");
			                e.consume();
			              }
			         }
				});
				
				
				textFieldTotal[counter] = textBox1;
				panel.add(textBox1);
				counter++;
			}
			panel.add(label5);

		}	
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);

		panel.add(enterButton);
		panel.add(exitButton);
		
		exitButton.addActionListener(new ActionListener()
	    {
		  public void actionPerformed(ActionEvent e)
		  {
			  frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));      
		  }
	    });	
		
		enterButton.addActionListener(new ActionListener()
	    {
		  public void actionPerformed(ActionEvent e)
		  {
			  for(int i = 0;i<numOfColor;i++) {
				  inputColor.ColorInputValue(Integer.parseInt(textFieldTotal[i*3].getText()),Integer.parseInt(textFieldTotal[3*i+1].getText()),Integer.parseInt(textFieldTotal[i*3+2].getText()), i); 			  
			  }  
			  try {
			  		new InputFrame(dimension,depth,numOfColor,inputColor);
				    frame.setVisible(false);
			  } 
			  catch (Exception e1) {
			  	e1.printStackTrace();
			  }
		  }
	    });
	
	}

}
