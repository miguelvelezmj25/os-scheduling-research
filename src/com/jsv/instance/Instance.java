package com.jsv.instance;

import java.util.LinkedList;
import java.util.List;

import com.jsv.event.Event;

/**
 * Process class
 */

public class Instance implements Comparable<Instance>{
	private int			pid;
	private List<Event> eventList = new LinkedList<Event>();
	private int			startTime;
	
	
	public Instance(int pid, int startTime) {
		this.pid = pid;
		this.startTime = startTime;
	}
	public Event remove()
	{
		return this.eventList.remove(0);
	}
	
	@Override
	public int compareTo(Instance o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void addEvent(Event e) {
		this.eventList.add(e);
	}
	
	// TODO fast access time
	/** Getting the total time of all of the events of this process
	 */
	protected int getTotalTime() {
		int totalTime = 0;
		
		for(Event e : this.getEventList()) {
			totalTime = totalTime + e.getTimeEvent();
		}
		
		return totalTime;
	}
	
	/** Get the event time of the next CPU event
	 */
	public int getNextCpuEventTime() {
		if(!this.eventList.get(0).isCPU()){throw new IllegalArgumentException("Next event is not CPU, but process is in CPU queue");}
		
		return this.eventList.get(0).getTimeEvent();
	}
	public int getNextOthEventTime() {
		if(this.eventList.get(0).isCPU()){throw new IllegalArgumentException("Next event is not OTH, but process is in OTH queue");}
		
		return this.eventList.get(0).getTimeEvent();
	}
		
	/** */
	private int getTotalNumberEvents() {
		return 0;
	}

	
	
	
	// Getters
	public int getPid() { return pid; }

	public List<Event> getEventList() {
		return eventList;
	}

	public int getStartTime() {	return startTime; }

	// Setters
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	

}
