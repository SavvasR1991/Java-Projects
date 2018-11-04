package com.pack.frame.layout;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Timer;

public class ErrorToast {
	
	public String message;

	public ErrorToast(String Inputmessage) {
		  JFrame frame = new JFrame();

		  frame.setUndecorated(true);
		 
		  frame.setLayout(new GridBagLayout());
		  frame.setBackground(new Color(150,150,150,250));
		  frame.setLocationRelativeTo(null);
		  frame.setSize(300, 50);
		  JLabel label = new JLabel(Inputmessage);
		  

		  frame.add(label);
		  frame.addComponentListener(new ComponentAdapter() {
	          public void componentResized(ComponentEvent e) {
	        	 frame.setShape(new  RoundRectangle2D.Double(0,0,frame.getWidth(),
	        	 frame.getHeight(), 20, 20));                      
	          }
		  });  
		      
		  frame.setOpacity(1);
		  frame.setVisible(true);
		  Timer timer = new Timer(2000, new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	        	 
	        	  frame.dispose();
	  	          frame.setVisible(false);	  

	          }
	      });
	      timer.start();  
	}
}
