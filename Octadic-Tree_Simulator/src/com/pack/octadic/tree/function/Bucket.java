package com.pack.octadic.tree.function;

import com.pack.colours.ColorValue;

public class Bucket {
	
	public int redColourCounter;
	public int greenColourCounter;
	public int blueColourCounter;
	public int summaryCounter;


	Bucket() {
		this.summaryCounter = 0;
		this.redColourCounter = 0;
		this.greenColourCounter = 0;
		this.blueColourCounter = 0;
	}
	
	void BucketInsertColor(ColorValue colorInput) {
		this.redColourCounter = this.redColourCounter+colorInput.red;
		this.greenColourCounter = this.redColourCounter+colorInput.green;
		this.blueColourCounter = this.redColourCounter+colorInput.blue;
		this.summaryCounter++;
	}
	

	
}
