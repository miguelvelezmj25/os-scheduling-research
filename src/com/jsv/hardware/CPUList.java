package com.jsv.hardware;

import java.util.ArrayList;

import com.jsv.instance.Instance;

/**
 * CPU List class that holds a list of CPU objects
 */

public class CPUList{
	
	private ArrayList<CPU> instanceQueues = new ArrayList<CPU>();
	
	public CPUList(int numCPU) {		
		for(int i = 0; i < numCPU; i++){
			this.getInstanceQueues().add(new CPU(i));
		}
	}
	
	/** Returns the scheduled time in the Instance of the specified CPU
	 */
	public int getTotalTime(int cpuID) {
		return this.getInstanceQueues().get(cpuID).getTotalTime();
	}
	
	/** Returns the first Instance from the specified CPU
	 */
	public Instance pop(int cpuID) {
		return this.getInstanceQueues().get(cpuID).removeInstance();
	}
	
	/** Returns the CPU index with the smallest current total time
	 */
	public int getMinimumCPUTime() {
		int minIndex = Integer.MAX_VALUE;
		int time = Integer.MAX_VALUE;
		
		for(int cpuId = 0; cpuId < this.getInstanceQueues().size(); cpuId++) {
			if(this.getInstanceQueues().get(cpuId).getTotalTime() < time) {
				minIndex = cpuId;
				time = this.getInstanceQueues().get(cpuId).getTotalTime();
			}
		}
		
		return minIndex;
	}
	
	/** Adds an Instance to the CPU with the minimum total time
	 */
	public void add(Instance instance) {
		int leastTime = this.getMinimumCPUTime();
		this.getInstanceQueues().get(leastTime).add(instance);
	}
	
	/** Return the specfied CPU
	 */
	public CPU getCPU(int cpuID) {
		return this.getInstanceQueues().get(cpuID);
	}
	
	/** Prints the CPUs
	 */
	public void printList()	{
		for(CPU cpu : this.getInstanceQueues()) {
			System.out.println(cpu);
		}
	}
	
	/** Returns the minimum finish time of all the instances currently
	 * running in a CPU
	 */
	public int getNextFinishTime() {
		int minTime = Integer.MAX_VALUE;
		
		for(CPU cpu : this.getInstanceQueues()) {
			if(cpu.getCurrentInstanceFinishTime() != -1) {
//				System.out.println("Get Finish time: " + cpu.getCurrentInstanceFinishTime());
				
				minTime = Math.min(minTime, cpu.getCurrentInstanceFinishTime());
			}
		}
		
		return minTime;
	}

	// Getters
	public ArrayList<CPU> getInstanceQueues() {
		return instanceQueues;
	}

	
	// Setters
//	public void setInstanceQueues(ArrayList<CPU> instanceQueues) {
//		this.instanceQueues = instanceQueues;
//	}

}
