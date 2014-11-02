package com.jsv.hardware;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.jsv.instance.Instance;

public class CPUList{
	
	private ArrayList<CPU> instanceQueues;
	
	public CPUList(int numCPU)
	{
		instanceQueues = new ArrayList<CPU>();
		
		for(int i =0;i<numCPU;i++){
			instanceQueues.add(new CPU());
		}
	}
	
	//Returns the scheduled time in the Instance
	public int getTotalTime(int cpuID)
	{
		return this.instanceQueues.get(cpuID).getTotalTime();
	}
	
	public Instance pop(int cpuID)
	{
		return this.instanceQueues.get(cpuID).remove();
	}
	
	public int getMinimumCPUTime()
	{
		int minIndex = Integer.MAX_VALUE;
		int time = Integer.MAX_VALUE;
		
		for(int cpuID =0;cpuID<this.instanceQueues.size();cpuID++)
		{
			if(this.instanceQueues.get(cpuID).getTotalTime()<time)
			{
				minIndex = cpuID;
				time = this.instanceQueues.get(cpuID).getTotalTime();
			}
		}
		
		return minIndex;
	}
	
	public void add(Instance i)
	{
		int leastTime = this.getMinimumCPUTime();
		this.instanceQueues.get(leastTime).add(i);
	}
	
	public CPU get(int cpuID)
	{
		return this.instanceQueues.get(cpuID);
	}
	
	public void printList()
	{
		for(CPU cpu : this.instanceQueues)
		{
			System.out.println(cpu);
		}
	}

}
