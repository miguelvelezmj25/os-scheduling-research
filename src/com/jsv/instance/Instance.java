package com.jsv.instance;

import java.util.LinkedList;
import java.util.List;

import com.jsv.command.Command;

/**
 * Instance class that has a pid, a start time, and a list of events/commands that it 
 * executes. It implements the Comparable interface
 */

public class Instance implements Comparable<Instance>{
	private List<Command> 	eventList = new LinkedList<Command>();
	private int				pid;
	private int				startTime;
	
	
	public Instance(int pid, int startTime) {
		this.pid = pid;
		this.startTime = startTime;
	}
	
	@Override
	public int compareTo(Instance instance) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/** Removes the first command in the command list and returns
	 * it
	 */
	public Command remove() {
		return this.getEventList().remove(0);
	}
	
	/** Adds an Command to the command list
	 */
	public void addCommand(Command command) {
		this.getEventList().add(command);
	}
	
	// TODO fast access time
	/** Getting the total time of all of the commands of this Instance
	 */
	protected int getTotalTime() {
		int totalTime = 0;
		
		for(Command command : this.getEventList()) {
			totalTime = totalTime + command.getTimeEvent();
		}
		
		return totalTime;
	}
	
	/** Get the event time of the next CPU command
	 */
	public int getNextCpuEventTime() {
		if(!this.getEventList().get(0).isCPU()) {
			throw new IllegalArgumentException("Next event is not CPU, but Instance is in CPU queue");
		}
		
		return this.eventList.get(0).getTimeEvent();
	}
	
	/** Get the event time of the next OTH command
	 */
	public int getNextOthEventTime() {
		if(this.getEventList().get(0).isCPU()){ 
			throw new IllegalArgumentException("Next event is not OTH, but Instance is in OTH queue");
		}
		
		return this.eventList.get(0).getTimeEvent();
	}
		
	/** */
	// TODO do we need this?
	private int getTotalNumberEvents() {
		return 0;
	}

	
	
	
	// Getters
	public int getPid() { return this.pid; }

	public List<Command> getEventList() {
		return this.eventList;
	}

	public int getStartTime() {	return this.startTime; }

	
	
	// Setters
//	private void setEventList(List<Command> eventList) {
//		this.eventList = eventList;
//	}
//
//	private void setPid(int pid) {
//		this.pid = pid;
//	}
//
//	private void setStartTime(int startTime) {
//		this.startTime = startTime;
//	}
}
