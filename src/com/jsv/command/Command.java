package com.jsv.command;

public class Command {
	private boolean isCPU;
	private boolean isNEW;
	private boolean isOTH;
	private int timeCommand;
	
	public boolean isCPU() {
		return isCPU;
	}

	public int getTimeCommand() {
		return timeCommand;
	}

	public Command(int flag, int timeCommand) {
		this.isCPU = false;
		this.isNEW = false;
		this.isOTH = false;
		
		if(flag == 0) {
			this.isNEW = true;
		} 
		else if(flag == 1) {
			this.isCPU = true;
		} 
		else if(flag == 2) {
			this.isOTH = true;
		} 
		else {
			throw new IllegalArgumentException("You entered a number that does not correspond to a Command.");
		}
			
		this.timeCommand = timeCommand;
	}

	public boolean isNEW() {
		return isNEW;
	}


	public boolean isOTH() {
		return isOTH;
	}

	
	

}
