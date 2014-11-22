package com.jsv.instance;

/**
 * Sorts by the highest cpu ratio meaning that Instances that need more CPU time
 * have high priority. 
 */

public class HighestCPURatio extends Instance{
	
	public HighestCPURatio(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	/** Compare the cpu ratio of the instances.
	 */
	public int compareTo(Instance instance) {
		//System.out.println("This: " + this.getPid() + " - instance: " + instance.getPid());
		
		double thisComp = super.getCPURatio();
		double othComp = instance.getCPURatio();
		
		if(thisComp > othComp)
		{
			return -1;
		}else if(othComp < thisComp){
			return 1;
		}
		
		return 0;
	}
}
