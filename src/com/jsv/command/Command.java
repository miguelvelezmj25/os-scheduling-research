package com.jsv.command;

public class Command {
	private boolean isCPU;
	private boolean isNEW;
	private boolean isOTH;
	private int timeEvent;
	
	public boolean isCPU() {
		return isCPU;
	}

	public int getTimeEvent() {
		return timeEvent;
	}

	public Command(int flag, int timeEvent) {
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
			throw new IllegalArgumentException("You entered a number that does not correspond to a event.");
		}
			
		this.timeEvent = timeEvent;
	}

	public boolean isNEW() {
		return isNEW;
	}


	public boolean isOTH() {
		return isOTH;
	}

	
	

}
