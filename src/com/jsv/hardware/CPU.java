package com.jsv.hardware;

import com.jsv.Driver;
import com.jsv.command.Command;
import com.jsv.instance.Instance;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * CPU class that has a priority queue when Instances wait to access it and a finish time
 * for the current Instance. The first place in the queue indicates that the Instance is
 * "in the CPU."
 */

public class CPU {
	
	private PriorityQueue<Instance> 	instanceQueue = new PriorityQueue<Instance>();
	private int 						currentInstanceFinishTime; 
	
	public CPU() {
		this.currentInstanceFinishTime = -1;
	}
	
	/***/
	public void add(Instance instance) {
		if(this.instanceQueue.isEmpty()) {
			this.currentInstanceFinishTime = Driver.clock + instance.getNextCPUCommandTime();
		}
		
		instanceQueue.add(instance);
	}
	
	public int nextFinishTime()
	{
		return this.currentInstanceFinishTime;
	}
	
	public int getTotalTime()
	{
		int totalTime = 0;
		for(Instance instance : instanceQueue)
		{
			totalTime += instance.getNextCPUCommandTime();
		}
		
		return totalTime;
	}
	
	public Instance remove()
	{
		Instance current = this.instanceQueue.poll();
		Command command = current.remove();
		if(this.instanceQueue.size()>0)
		{
			this.currentInstanceFinishTime = Driver.clock + this.instanceQueue.peek().getNextCPUCommandTime();
		}else{
			this.currentInstanceFinishTime = -1;
		}
		return current;
	}
	
	@Override
	public String toString()
	{
		ArrayList<Instance> copy = new ArrayList(this.instanceQueue);
		String ret_string = "";
		
		for(Instance instance : copy)
		{
			ret_string += instance.getPid()+" ";
		}
		
		ret_string.trim();
		return ret_string;
	}
	
	
	// Getters
	public PriorityQueue<Instance> getInstanceQueue() {
		return this.instanceQueue;
	}

	public int getCurrentInstanceFinishTime() {
		return this.currentInstanceFinishTime;
	}

	
	// Setters
//	public void setInstanceQueue(PriorityQueue<Instance> instanceQueue) {
//		this.instanceQueue = instanceQueue;
//	}
	
	public void setCurrentInstanceFinishTime(int currentInstanceFinishTime) {
		this.currentInstanceFinishTime = currentInstanceFinishTime;
	}

}