package com.jsv.instance;

/**
 * Sorts by the total time that a process needs to execute 
 */
public class TotalTimeInstance extends Instance {

	public TotalTimeInstance(int pid, int startTime) {
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
