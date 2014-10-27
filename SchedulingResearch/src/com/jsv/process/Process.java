package com.jsv.process;
import java.util.LinkedList;
import java.util.List;


public class Process implements Comparable<Process>{
	private int			pid;
	private List<Event> eventList = new LinkedList<Event>();
	private int			startTime;
	
	
	public Process(int pid, int startTime) {
		this.pid = pid;
		this.startTime = startTime;
	}
	
	@Override
	public int compareTo(Process o) {
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
	private int getNextCpuEventTime() {
		return 0;
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
