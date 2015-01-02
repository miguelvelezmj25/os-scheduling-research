package com.jsv.osschedulingresearch.hardware;

import com.jsv.osschedulingresearch.Driver;
import com.jsv.osschedulingresearch.instance.Instance;

/** OTH hardware that wraps an Instance and runs it. All instances are 
 * run in parallel.
 */

public class OTH implements Comparable<OTH>
{
	private int exitTime;
	private Instance instance;
	
	public OTH(Instance instance)
	{
		this.instance = instance;
		this.exitTime = Driver.clock + instance.getNextOTHCommandTime();
	}
	
	public int compareTo(OTH o) 
	{
		if(o.getExitTime() > this.getExitTime())
		{
			return -1;
		}
		else if(o.getExitTime() == this.getExitTime())
		{
			return 0;
		}
		return 1;
	}
	
	public int getExitTime()
	{
		return this.exitTime;
	}
	
	public Instance getInstance()
	{
		return this.instance;
	}
	
	
}
