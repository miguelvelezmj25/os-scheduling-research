package com.jsv.hardware;

import com.jsv.Driver;
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
	private Instance					instanceInCPU;
	private int 						currentInstanceFinishTime;
	private int 						cpuId; 
	
	public CPU(int i) {
		this.cpuId = i;
		this.currentInstanceFinishTime = -1;
		this.instanceInCPU = null;
	}
	
	/** Add an Instance to the queue
	 */
	public void add(Instance instance) {
		// If the hardware itself is empty, the add the instance to it
		if(this.getInstanceInCPU() == null) {
			this.setCurrentInstanceFinishTime(Driver.clock + instance.getNextCPUCommandTime());
			this.setInstanceInCPU(instance);
		}else{		
			this.getInstanceQueue().add(instance);
		}

		System.out.println("Instance queue and add: " + this.instanceQueue.size());	
	}
		
	/** Get the total time of the instances in the queue
	 */
	public int getTotalTime() {
		int totalTime = 0;
		
		// Adding the CPU service time of each instance
		for(Instance instance : this.getInstanceQueue()) {
			totalTime += instance.getNextCPUCommandTime();
		}
		
		// Adding the remaining time of the instance in the CPU
		totalTime += (this.getCurrentInstanceFinishTime() - Driver.clock);
		
		return totalTime;
	}
	
	/** Removes an instance from the queue and returns it. Then it updates the finish time
	 * depending if there are more Instances or not
	 */
	public Instance removeInstance() {
		/*
		// Remove the Instance from the queue
		Instance current = this.getInstanceQueue().poll();
		// Remove the latest command from the instance
		current.remove();
		
		if(this.getInstanceQueue().size() > 0) {
			this.setCurrentInstanceFinishTime(Driver.clock + this.getInstanceQueue().peek().getNextCPUCommandTime());
		}else{
			this.setCurrentInstanceFinishTime(-1);
		}
		
		return current;
		*/
		
		// Remove the CPU command of the Instance
		Instance toReturn = this.instanceInCPU;
		toReturn.removeCommand();
		
		if(!this.instanceQueue.isEmpty()) {
			// Put the Instance from the queue in the hardware
			this.setInstanceInCPU(this.getInstanceQueue().poll());
			
			this.setCurrentInstanceFinishTime(Driver.clock + this.getInstanceInCPU().getNextCPUCommandTime());
		}else{
			this.setCurrentInstanceFinishTime(-1);
		}
		
		return toReturn;
	}
	
	@Override
	/** Prints the Instances of the queue
	 */
	public String toString() {
		ArrayList<Instance> queue = new ArrayList<Instance>(this.getInstanceQueue());
		String returnString = "CPU " + this.getCPUId() + ": " + this.getInstanceInCPU() + "\t Queue Contains: ";
		
		for(Instance instance : queue) {
			returnString += instance.getPid() + " ";
		}
		
		return returnString.trim();
	}
	
	
	// Getters
	public PriorityQueue<Instance> getInstanceQueue() {
		return this.instanceQueue;
	}

	public int getCurrentInstanceFinishTime() {
		return this.currentInstanceFinishTime;
	}
	
	public int getCPUId() {
		return this.cpuId;
	}
	
	public Instance getInstanceInCPU() {
		return this.instanceInCPU;
	}

	
	// Setters
//	public void setInstanceQueue(PriorityQueue<Instance> instanceQueue) {
//		this.instanceQueue = instanceQueue;
//	}
	
	public void setCurrentInstanceFinishTime(int currentInstanceFinishTime) {
		this.currentInstanceFinishTime = currentInstanceFinishTime;
	}
	
	public void setInstanceInCPU(Instance instance) {
		this.instanceInCPU = instance;
	}
	
//	public void setCPUId(int cpuId) {
//		this.cpuId = cpuId;
//	}

}