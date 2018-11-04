package com.pack.octadic.tree.function;

public class Bucket {

	Bucket() {
		this.summaryCounter = 0;
		this.redColourCounter = 0;
		this.greenColourCounter = 0;
		this.blueColourCounter = 0;
	}
	
	private int summaryCounter;
	
	public int getSummaryCounter() {
		return summaryCounter;
	}
	public void setSummaryCounter(int summaryCounter) {
		this.summaryCounter = summaryCounter;
	}
	public int getRedColourCounter() {
		return redColourCounter;
	}
	public void setRedColourCounter(int redColourCounter) {
		this.redColourCounter = redColourCounter;
	}
	public int getGreenColourCounter() {
		return greenColourCounter;
	}
	public void setGreenColourCounter(int greenColourCounter) {
		this.greenColourCounter = greenColourCounter;
	}
	public int getBlueColourCounter() {
		return blueColourCounter;
	}
	public void setBlueColourCounter(int blueColourCounter) {
		this.blueColourCounter = blueColourCounter;
	}

	private int redColourCounter;
	private int greenColourCounter;
	private int blueColourCounter;

}
