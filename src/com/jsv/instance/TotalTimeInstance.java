package com.jsv.instance;

/**
 * Sorts by the total time that a Instance needs to execute 
 */
public class TotalTimeInstance extends Instance {

	public TotalTimeInstance(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	/** Sort by the total time of the Instance.
	 */
	public int compareTo(Instance instance) {
		int thisTotalTime = super.getTotalTime();
		int otherTotalTime = instance.getTotalTime();
		
		if(thisTotalTime < otherTotalTime) {
			return -1;
		}
		else if(thisTotalTime > otherTotalTime) {
			return 1;
		}
		
		return 0;
	}


}
