package com.pack.frame.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pack.colours.ColorInput;
import com.pack.colours.ColorInputTable;

public class InputFrame {
	
	private int pixel;
	public JFrame frame;

	public InputFrame(int dimension,int depth,int numOfColor,ColorInput inputColor) {
		this.pixel = 20;
		InputFrameCreation(dimension,depth,numOfColor,inputColor);
	}
	
	public void InputFrameCreation(int dimension,int depth,int numOfColor,ColorInput inputColor) {
		int i,j,counter = 0;;
		int frameSize = dimension*this.pixel+(dimension+1)*pixel;
		int pixelGap = (frameSize-dimension*this.pixel)/(dimension+1);
		ColorInputTable inputColorTable = new ColorInputTable(dimension*dimension);

		
		JFrame frame = new JFrame("Input Colors Frame");
		
		frame.setSize(frameSize,frameSize+100);
		frame.setBackground(Color.WHITE);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		JPanel panel = new JPanel(new BorderLayout()); 
	    panel.setLayout(null);
	    

		JButton enterButton = new JButton("Next");
		enterButton.setBounds(frameSize-80, frameSize+50, 70, 30);


		JButton exitButton = new JButton("Exit");
		exitButton.setBounds(10, frameSize+50, 70, 30);

		JLabel label = new JLabel("Insert Colors");		
		
		label.setBounds(frameSize/2-50,10,100, 20);
		
		panel.add(enterButton);
		panel.add(exitButton);
		panel.add(label);

		frame.getContentPane().add(panel);
		JTextField [] textFieldSummary = new JTextField[dimension*dimension];
		for( i =0;i<dimension;i++) {
			
			for(j =0;j<dimension;j++) {
				JTextField textBox1=new JTextField();

				textBox1.setBackground(new Color(255, 255, 255));
				textBox1.setBounds(pixelGap+j*(pixel+pixelGap),30+pixelGap+i*(pixel+pixelGap), pixelGap, pixelGap);
				textBox1.setFocusable(true);
				
				textBox1.addKeyListener(new KeyAdapter() {
				    public void keyTyped(KeyEvent e) { 
				        if (textBox1.getText().length() >= 1 ) {// limit textfield to 3 characters
				            e.consume(); 
			            	new ErrorToast("Out of bounds");
				        }
				    }  
				});
				
				textBox1.addKeyListener(new KeyAdapter() {
				    public void keyTyped(KeyEvent e) {
					    char keyChar = e.getKeyChar();
				        if (keyChar> 122 ||keyChar<65) {
				            e.consume(); 
				            new ErrorToast("Put a valid letter");
				        }
				        else if(Character.isLowerCase(keyChar)) {
				        	if(keyChar>96 + numOfColor) {
					            e.consume(); 
					            new ErrorToast("No such color");
				        	}
				        }
				        else if (keyChar > numOfColor+96) {
				            new ErrorToast("No such color");
				            e.consume(); 
				        }
				    } 
					
				});
				
				textBox1.addKeyListener(new KeyAdapter() {
				  public void keyTyped(KeyEvent e) {
				    char keyChar = e.getKeyChar();
				    if (Character.isLowerCase(keyChar)) {
				      e.setKeyChar(Character.toUpperCase(keyChar));
				    }
				  }
				});
				textFieldSummary[counter] = textBox1;
				counter++;
				panel.add(textBox1);

			}
		}   
		
		
		enterButton.addActionListener(new ActionListener()
	    {
		  public void actionPerformed(ActionEvent e)
		  {
			  int counter = 0;
			  int red = 0;
			  int blue = 0;
			  int green = 0;
			  int color = 0;
			  boolean errorNoInput = false;
			  for(int i=0;i<dimension;i++) {
				  for(int j=0;j<dimension;j++) {
					  if(!(textFieldSummary[counter].getText().isEmpty())) {
						  color =((int)(textFieldSummary[counter].getText().charAt(0))) - 65;
						  red = inputColor.ColorInputRed(color);
						  blue = inputColor.ColorInputBlue(color);
						  green = inputColor.ColorInputGreen(color);
						  inputColorTable.ColorInputValue(red, green, blue, counter,color);
						  counter++;
					  }
					  else {
						  errorNoInput = true;
						  break;
					  }
				  }
				  if(errorNoInput) {
					  break;
				  }
			  }
			  if(!errorNoInput) {
				  new BeforeOctadicFrame(dimension,depth,inputColorTable);
				  frame.setVisible(false);
			  }
			  else {
				  
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
