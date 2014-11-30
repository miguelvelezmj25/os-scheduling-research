package com.jsv.instance;

/**
 * It implements a First Come First Serve. Sorts by id. 
 */
public class RoundRobin extends Instance {

	public RoundRobin(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	public int compareTo(Instance instance) {
		if(super.getTimeEnterQueue() < instance.getTimeEnterQueue()) {
			return -1;
		}
		else if(super.getTimeEnterQueue() == instance.getTimeEnterQueue())
		{
			if(this.getPid() == instance.getPid())
			{
				return 0;
			}
			if(this.getPid() > instance.getPid())
			{
				return 1;
			}
			return -1;
		}
		return 1;
	}

}
