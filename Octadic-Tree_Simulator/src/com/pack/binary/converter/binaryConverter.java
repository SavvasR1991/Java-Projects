package com.pack.binary.converter;

import com.pack.colours.ColorValue;

public class binaryConverter {

	public binaryConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public int colorConvertIndex(ColorValue colorInput,int level) {
		int index = 0;
		String binaryRed = binaryToDecimalConverter(colorInput.red);
		String binaryGreen = binaryToDecimalConverter(colorInput.green);
		String binaryBlue = binaryToDecimalConverter(colorInput.blue);
		String binaryIndex =
				Character.toString(binaryRed.charAt(level))+
				Character.toString(binaryGreen.charAt(level))+
				Character.toString(binaryBlue.charAt(level));
		
		index = Integer.parseInt(binaryIndex, 2);
		
		return index;
	}
	public String binaryToDecimalConverter(int num) {
		  String str = "";
	      for(int a = 0; a < 8; a++)
	      {
	         if(num % 2 == 1)
	         {
	            str = "1" + str;
	         }
	         if(num % 2 == 0)
	         {
	            str = "0" + str;
	         }
	         num = num / 2;
	      }
		
		return str;	
	}

}
