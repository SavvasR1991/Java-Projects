package com.pack.colours;

public class ColorInput {

	private ColorValue [] colourArray;
	
	
	public ColorInput(int numColors) {
		this.colourArray = new ColorValue[numColors];
	}
	
	public void ColorInputValue(int red,int green,int blue,int index) {

		colourArray[index] = new ColorValue();
		
		colourArray[index].red = red;
		colourArray[index].green = green;
		colourArray[index].blue = blue;
	}
	
	public int ColorInputRed(int index) {
		return colourArray[index].red;
	}
	
	public int ColorInputGreen(int index) {
		return colourArray[index].green;
	}
	
	public int ColorInputBlue(int index) {
		return colourArray[index].blue;
	}
}
