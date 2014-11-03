package com.jsv.instance;

/**
 * The first command of a Instance is CPU. We take the first command and
 * sort by that time
 */
public class ShortestJobTimeInstance extends Instance {

	public ShortestJobTimeInstance(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	public int compareTo(Instance o) {
		int thisNextTime = super.getCommandList().get(0).getTimeCommand();
		int otherNextTime = o.getCommandList().get(0).getTimeCommand();
		
		if(thisNextTime < otherNextTime) {
			return -1;
		}
		else if(thisNextTime > otherNextTime) {
			return 1;
		}
		
		return 0;
	}


}
