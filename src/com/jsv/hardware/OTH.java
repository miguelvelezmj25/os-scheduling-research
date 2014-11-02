package com.jsv.hardware;
import com.jsv.Driver;
import com.jsv.instance.Instance;


public class OTH implements Comparable<OTH>
{
	private int exitTime;
	private Instance instance;
	
	public OTH(Instance instance)
	{
		this.instance = instance;
		this.exitTime = Driver.clock + instance.getNextOthEventTime();
	}
	public int getExitTime()
	{
		return this.exitTime;
	}
	
	public Instance getInstance()
	{
		return this.instance;
	}
	
	public int compareTo(OTH o) 
	{
		if(o.getExitTime() > this.getExitTime())
		{
			return 1;
		}
		else if(o.getExitTime() == this.getExitTime())
		{
			return 0;
		}
		return -1;
	}
	
}
