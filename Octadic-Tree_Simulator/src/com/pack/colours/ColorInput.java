package com.pack.colours;

public class ColorInput {

	private colorValue [] colourArray;
	
	class colorValue{
		private int red;
		private int green;
		private int blue;
	}
	
	public ColorInput(int numColors) {
		this.colourArray = new colorValue[numColors];
	}
	
	public void ColorInputValue(int red,int green,int blue,int index) {

		colourArray[index] = new colorValue();
		
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
