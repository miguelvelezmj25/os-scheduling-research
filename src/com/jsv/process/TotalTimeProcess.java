package com.jsv.process;

public class TotalTimeProcess extends Process {

	public TotalTimeProcess(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	public int compareTo(Process o) {
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