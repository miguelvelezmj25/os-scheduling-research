package com.jsv.hardware;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.jsv.instance.Instance;

public class CPUList{
	
	private ArrayList<CPU> processQueues;
	
	public CPUList(int numCPU)
	{
		processQueues = new ArrayList<CPU>();
		
		for(int i =0;i<numCPU;i++){
			processQueues.add(new CPU());
		}
	}
	
	//Returns the scheduled time in the process
	public int getTotalTime(int cpuID)
	{
		return this.processQueues.get(cpuID).getTotalTime();
	}
	
	public Instance pop(int cpuID)
	{
		return this.processQueues.get(cpuID).remove();
	}
	
	public int getMinimumCPUTime()
	{
		int minIndex = Integer.MAX_VALUE;
		int time = Integer.MAX_VALUE;
		
		for(int cpuID =0;cpuID<this.processQueues.size();cpuID++)
		{
			if(this.processQueues.get(cpuID).getTotalTime()<time)
			{
				minIndex = cpuID;
				time = this.processQueues.get(cpuID).getTotalTime();
			}
		}
		
		return minIndex;
	}
	
	public void add(Instance i)
	{
		int leastTime = this.getMinimumCPUTime();
		this.processQueues.get(leastTime).add(i);
	}
	
	public CPU get(int cpuID)
	{
		return this.processQueues.get(cpuID);
	}
	
	public void printList()
	{
		for(CPU cpu : this.processQueues)
		{
			System.out.println(cpu);
		}
	}

}
