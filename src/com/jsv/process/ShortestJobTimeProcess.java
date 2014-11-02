package com.jsv.process;

/**
 * The first command of a process is CPU. We take the first command and
 * sort by that time
 */
public class ShortestJobTimeProcess extends Instance {

	public ShortestJobTimeProcess(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	public int compareTo(Instance o) {
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
