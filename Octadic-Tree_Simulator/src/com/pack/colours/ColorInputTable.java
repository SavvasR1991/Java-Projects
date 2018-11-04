package com.pack.colours;

public class ColorInputTable {

	private colorValue [] colourArray;
	private int serialNumber;
	
	public int getSerialNumber() {
		return serialNumber;
	}

	class colorValue{
		private int red;
		private int green;
		private int blue;
		private int color;
	}
	
	public  ColorInputTable(int dimension) {
		this.colourArray = new colorValue[dimension * dimension];
		this.serialNumber = 0;
	}
	
	public colorValue[] getColourArray() {
		return colourArray;
	}

	public void setColourArray(colorValue[] colourArray) {
		this.colourArray = colourArray;
	}

	public void ColorInputValue(int red,int green,int blue,int index,int color) {

		colourArray[index] = new colorValue();
		
		colourArray[index].red = red;
		colourArray[index].green = green;
		colourArray[index].blue = blue;
		colourArray[index].color = color;
		
		this.serialNumber++;
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
	
	public int ColorInputColor(int index) {
		return colourArray[index].color;
	}

}
