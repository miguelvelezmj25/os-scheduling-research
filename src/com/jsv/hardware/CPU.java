package com.jsv.hardware;

import com.jsv.Driver;
import com.jsv.command.Command;
import com.jsv.instance.Instance;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class CPU {
	
	/**
	 * Implemented such that the first place in the queue indicates that the process is "in the CPU."
	 */
	private PriorityQueue<Instance> processQueue = new PriorityQueue<Instance>();
	private int currentProcessFinishTime = -1; //Indicates that there is no current process
	
	public void add(Instance p)
	{
		if(this.processQueue.isEmpty())
		{
			this.currentProcessFinishTime = Driver.clock+p.getNextCpuEventTime();
		}
		processQueue.add(p);
	}
	
	public int nextFinishTime()
	{
		return this.currentProcessFinishTime;
	}
	
	public int getTotalTime()
	{
		int totalTime = 0;
		for(Instance i : processQueue)
		{
			totalTime += i.getNextCpuEventTime();
		}
		
		return totalTime;
	}
	
	public Instance remove()
	{
		Instance current = this.processQueue.poll();
		Command event = current.remove();
		if(this.processQueue.size()>0)
		{
			this.currentProcessFinishTime = Driver.clock + this.processQueue.peek().getNextCpuEventTime();
		}else{
			this.currentProcessFinishTime = -1;
		}
		return current;
	}
	
	@Override
	public String toString()
	{
		ArrayList<Instance> copy = new ArrayList(this.processQueue);
		String ret_string = "";
		
		for(Instance i : copy)
		{
			ret_string += i.getPid()+" ";
		}
		
		ret_string.trim();
		return ret_string;
	}

}
