package com.pack.frame.layout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ColorSimulator {

	public JFrame frame;

	public ColorSimulator()  {
		initialize();
	}

	private void initialize()  {

		JFrame frame = new JFrame("Color Simulator");
        
		frame.setSize(450, 300);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel(new BorderLayout()); 
	    panel.setLayout(null);
	    
	    frame.getContentPane().add(panel);
	
		JLabel label1 = new JLabel("Enter parameters");
		JLabel label2 = new JLabel("Enter dimension (min:4,max:9)   :");		
		JLabel label3 = new JLabel("Enter depth of tree (max:8)         :"); 
		JLabel label4 = new JLabel("Enter number of colors (max:9)  :"); 
		
		label1.setBounds(150,20,150, 20);
		label2.setBounds(30,70,250, 20);
		label3.setBounds(30,120,250, 20);
		label4.setBounds(30,170,250, 20);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	                new ErrorToast("Insert valid number");
	              }
	           else {
	        	   if( Character.getNumericValue(c) < 4 && Character.getNumericValue(c) >= 0) {
	        		   e.consume();
		               new ErrorToast("Insert number > 4");
	        	   }	        	   
	           }
	         }
		});
		textArea2.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (textArea2.getText().length() >= 1 ) { // limit textfield to 3 characters
		            e.consume(); 
	                new ErrorToast("Out of bounds");
		        }
		    }  
		});
		
		JTextArea textArea3 = new JTextArea();
		textArea3.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	                new ErrorToast("Insert valid number");

	              }
	           else {
	        	   if( Character.getNumericValue(c) > 8 && Character.getNumericValue(c) >= 0) {
	        		   e.consume();
		               new ErrorToast("Insert number < 8");
	        	   }	        	   
	           }
	         }
		});
		textArea3.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (textArea3.getText().length() >= 1 ) { // limit textfield to 3 characters
		            e.consume();
		        	new ErrorToast("Out of bounds");
		        }
		    }  
		});
		
		JTextArea textArea4 = new JTextArea();
		textArea4.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	           char c = e.getKeyChar();
	           if (!(Character.isDigit(c) ||
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {
	                e.consume();
	                new ErrorToast("Insert valid number");

	              }
	           else {
	        	   if( Character.getNumericValue(c) > 9 || Character.getNumericValue(c) == 0) {
	        		   e.consume();
		               new ErrorToast("Insert number < 9");
	        	   }
	        	   
	           }
	         }
		});
		textArea4.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (textArea4.getText().length() >= 1 ) { // limit textfield to 3 characters
	                new ErrorToast("Out of bounds");
		        	e.consume(); 
		        }
		    }  
		});
		
		textArea2.setBounds(350, 70, 50, 20);
		textArea3.setBounds(350, 120, 50, 20);
		textArea4.setBounds(350, 170, 50, 20);

		JButton enterButton = new JButton("Next");
		enterButton.setBounds(350, 250, 70, 30);

		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(50, 250, 70, 30);

		panel.add(textArea2);
		panel.add(textArea3);
		panel.add(textArea4);

		panel.add(label1);
		panel.add(label2);		
		panel.add(label3);
		panel.add(label4);

		panel.add(enterButton);
		panel.add(exitButton);

	    frame.setVisible(true);

	    enterButton.addActionListener(new ActionListener()
	    {
		  public void actionPerformed(ActionEvent e)
		  {
			  		
			  	try {
			  		new ColorInputFrame(Integer.parseInt(textArea2.getText()),Integer.parseInt(textArea3.getText()),Integer.parseInt(textArea4.getText()));
				    frame.setVisible(false);
			  	} 
			  	catch (Exception e1) {
			  		e1.printStackTrace();
				}
        		
		  }
	    });	
	    
	    exitButton.addActionListener(new ActionListener()
	    {
		  public void actionPerformed(ActionEvent e)
		  {
			  frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));      
		  }
	    });	

	}

}
