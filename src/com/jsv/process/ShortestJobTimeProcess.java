package com.jsv.process;

public class ShortestJobTimeProcess extends Process {

	public ShortestJobTimeProcess(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	public int compareTo(Process o) {
		int thisNextTime = super.getEventList().get(0).getTimeEvent();
		int otherNextTime = o.getEventList().get(0).getTimeEvent();
		
		if(thisNextTime < otherNextTime) {
			return -1;
		}
		else if(thisNextTime > otherNextTime) {
			return 1;
		}
		
		return 0;
	}


}
