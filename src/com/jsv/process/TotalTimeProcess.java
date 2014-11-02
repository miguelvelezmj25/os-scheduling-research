package com.jsv.process;

/**
 * Sorts by the total time that a process needs to execute 
 */
public class TotalTimeProcess extends Instance {

	public TotalTimeProcess(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	public int compareTo(Instance o) {
		int thisTotalTime = super.getTotalTime();
		int otherTotalTime = o.getTotalTime();
		
		if(thisTotalTime < otherTotalTime) {
			return -1;
		}
		else if(thisTotalTime > otherTotalTime) {
			return 1;
		}
		
		return 0;
	}


}
