package com.jsv.instance;

/**
 * Sorts by the lowest cpu ratio meaning that Instances that need less CPU time
 * have high priority. 
 */

public class LowestCPURatioInstance extends Instance{

	public LowestCPURatioInstance(int pid, int startTime) {
		super(pid, startTime);
		// TODO Auto-generated constructor stub
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
