package com.jsv.event;

public class Event {
	private boolean isCPU;
	private int timeEvent;
	
	public boolean isCPU() {
		return isCPU;
	}

	public int getTimeEvent() {
		return timeEvent;
	}

	public Event(boolean isCPU, int timeEvent) {
		this.isCPU = isCPU;
		this.timeEvent = timeEvent;
	}
	
	

}
