package com.jsv.instance;

/**
 * Sorts by the lowest cpu ratio meaning that Instances that need less CPU time
 * have high priority.
 */

public class LowestCPURatio extends Instance{

	public LowestCPURatio(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	/** Compare the cpu ratio of the Instances.
	 */
	public int compareTo(Instance instance) {
		//System.out.println("This: " + this.getPid() + " - instance: " + instance.getPid());
		
		double thisComp = super.getCPURatio();
		double othComp = instance.getCPURatio();
		
		if(thisComp < othComp)
		{
			return -1;
		}else if(othComp>thisComp){
			return 1;
		}
		
		return 0;
	}

}
