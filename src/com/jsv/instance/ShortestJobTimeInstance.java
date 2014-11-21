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
	/** Comparing the first command in the instance and sorting by that 
	 * time.
	 */
	public int compareTo(Instance instance) {
		System.out.println("This: " + this.getPid() + " - instance: " + instance.getPid());
		
		int thisNextTime = super.getCommandList().get(0).getTimeCommand();
		int otherNextTime = instance.getCommandList().get(0).getTimeCommand();
		
		if(thisNextTime < otherNextTime) {
			return -1;
		}
		else if(thisNextTime > otherNextTime) {
			return 1;
		}
		
		return 0;
	}

}
