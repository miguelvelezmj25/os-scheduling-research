package com.jsv.osschedulingresearch.instance;

/**
 * Sorts by the smallest total time that an Instance needs to execute 
 */
public class ShortestTotalTime extends Instance {
  
	public ShortestTotalTime(int pid, int startTime) {
		super(pid, startTime);
	}
	 
	@Override
	/** Sort by the total time of the Instance.
	 */
	// TODO do we want to preempt if a another Instance has a smaller total time
	public int compareTo(Instance instance) {
		int thisTotalTime = super.getTotalTime();
		int otherTotalTime = instance.getTotalTime();
		
//		System.out.println("PID: " + super.getPid() + " - " + thisTotalTime);
//		System.out.println("PID: " + instance.getPid() + " - " + otherTotalTime);
		
		if(thisTotalTime < otherTotalTime) {
			return -1;
		}
		else if(thisTotalTime > otherTotalTime) {
			return 1;
		}
		
		return 0;
	}


}
