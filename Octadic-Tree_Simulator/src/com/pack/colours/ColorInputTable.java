package com.pack.colours;


public class ColorInputTable {

	public ColorValue [] colourArray;
	private int serialNumber;
	
	public int getSerialNumber() {
		return serialNumber;
	}

	public  ColorInputTable(int dimension) {
		this.colourArray = new ColorValue[dimension * dimension];
		this.serialNumber = 0;
	}
	
	public ColorValue[] getColourArray() {
		return colourArray;
	}

	public void setColourArray(ColorValue[] colourArray) {
		this.colourArray = colourArray;
	}

	public void ColorInputValue(int red,int green,int blue,int index,int color) {

		colourArray[index] = new ColorValue();
		
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
