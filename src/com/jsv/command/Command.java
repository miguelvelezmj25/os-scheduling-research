package com.jsv.command;

/**
 * Command class that has a type and a duration 
 */

public class Command {
	private boolean isCPU;
	private boolean isNEW;
	private boolean isOTH;
	private String  commandType;
	private int 	timeCommand;
	
	public Command(int flag, int timeCommand) {
		this.isCPU = false;
		this.isNEW = false;
		this.isOTH = false;
		
		if(flag == 0) {
			this.isNEW = true;
			this.commandType = "NEW";
		} 
		else if(flag == 1) {
			this.isCPU = true;
			this.commandType = "CPU";
		} 
		else if(flag == 2) {
			this.isOTH = true;
			this.commandType = "OTH";
		} 
		else {
			throw new IllegalArgumentException("You entered a number that does not correspond to a Command.");
		}
		
		this.timeCommand = timeCommand;
	}
	
	
	// Getters
	public boolean getIsCPU() {
		return this.isCPU;
	}

	public boolean getIsNEW() {
		return this.isNEW;
	}

	public boolean getIsOTH() {
		return this.isOTH;
	}

	public int getTimeCommand() {
		return this.timeCommand;
	}

	public String getCommandType() {
		return this.commandType;
	}


	// Setters
//	private void setCPU(boolean isCPU) {
//		this.isCPU = isCPU;
//	}
//
//
//	private void setNEW(boolean isNEW) {
//		this.isNEW = isNEW;
//	}
//
//
//	private void setOTH(boolean isOTH) {
//		this.isOTH = isOTH;
//	}
//
//
//	private void setTimeCommand(int timeCommand) {
//		this.timeCommand = timeCommand;
//	}
//	
//	private void setType(String type) {
//		this.type = type;
//	}
	
}
