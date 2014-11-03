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
	private int 						currentInstanceFinishTime; 
	
	public CPU() {
		this.currentInstanceFinishTime = -1;
	}
	
	/** Add an Instance to the queue
	 */
	public void add(Instance instance) {
		// If the queue is empty by the time we want to add an instance, see the finish time
		if(this.getInstanceQueue().isEmpty()) {
			this.setCurrentInstanceFinishTime(Driver.clock + instance.getNextCPUCommandTime());
		}
		
		this.getInstanceQueue().add(instance);
	}
		
	/** Get the total time of the instances in the queue
	 */
	public int getTotalTime() {
		int totalTime = 0;
	
		for(Instance instance : this.getInstanceQueue()) {
			totalTime += instance.getNextCPUCommandTime();
		}
		
		return totalTime;
	}
	
	/** Removes an instance from the queue and returns it. Then it updates the finish time
	 * depending if there are more Instances or not
	 */
	public Instance remove() {
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
	}
	
	@Override
	/** Prints the Instances of the queue
	 */
	public String toString() {
		ArrayList<Instance> queue = new ArrayList<Instance>(this.getInstanceQueue());
		String returnString = "";
		
		for(Instance instance : queue) {
			returnString += instance.getPid() + ", ";
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

	
	// Setters
//	public void setInstanceQueue(PriorityQueue<Instance> instanceQueue) {
//		this.instanceQueue = instanceQueue;
//	}
	
	public void setCurrentInstanceFinishTime(int currentInstanceFinishTime) {
		this.currentInstanceFinishTime = currentInstanceFinishTime;
	}

}