package com.pack.frame.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.pack.colours.ColorInputTable;
import com.pack.octadic.tree.function.OctadicTree;;

public class BeforeOctadicFrame {
	
	private int pixel;
	public JFrame frame;

	public BeforeOctadicFrame(int dimension,int depth,ColorInputTable inputColor) {
		this.pixel = 20;
		InputFrameCreation(dimension,depth,inputColor);
	}
	
	public void InputFrameCreation(int dimension,int depth,ColorInputTable inputColor) {
		int i,j;
		
		int frameSize = dimension*this.pixel+(dimension+1)*pixel;
		int pixelGap = (frameSize-dimension*this.pixel)/(dimension+1);
		JFrame frame = new JFrame("Input Colors ");
		
		Dimension Screnndimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((Screnndimension.getWidth()/2 - frame.getWidth()) / 2);
	    int y = (int) ((Screnndimension.getHeight()/2 - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
		frame.setSize(frameSize,frameSize+100);
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		JPanel panel = new JPanel(new BorderLayout()); 
	    panel.setLayout(null);
	    
		JLabel label = new JLabel("Before Octadic Tree");		
		
		label.setBounds(frameSize/2-50,10,100, 20);
		
		panel.add(label);

		frame.getContentPane().add(panel);
		int red = 0;
		int blue = 0;
		int green = 0;
		int counter = 0;
		
		for( i =0;i<dimension;i++) {
			
			for(j =0;j<dimension;j++) {
				JTextField textBox1=new JTextField();
				red = inputColor.ColorInputRed(counter);
				blue = inputColor.ColorInputBlue(counter);
				green = inputColor.ColorInputGreen(counter);
				
				textBox1.setBackground(new Color(red, green, blue));
				textBox1.setBounds(pixelGap+j*(pixel+pixelGap),30+pixelGap+i*(pixel+pixelGap), pixelGap, pixelGap);
				textBox1.setFocusable(false);
				panel.add(textBox1);
				counter++;
			}
		}  
		OctadicTree octadicTreeAlgorith = new OctadicTree(depth,inputColor);
  
		new AfterOctadicFrame(dimension,inputColor);

		
	}
}
