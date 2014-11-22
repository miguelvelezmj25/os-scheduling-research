package com.jsv.instance;

public class HighestCPURatioInstance extends Instance{
	public HighestCPURatioInstance(int pid, int startTime) {
		super(pid, startTime);
		// TODO Auto-generated constructor stub
	}
	
	public int compareTo(Instance instance) {
		//System.out.println("This: " + this.getPid() + " - instance: " + instance.getPid());
		
		double thisComp = super.getCPURatio();
		double othComp = instance.getCPURatio();
		
		if(thisComp > othComp)
		{
			return -1;
		}else if(othComp<thisComp){
			return 1;
		}
		
		return 0;
	}
}
