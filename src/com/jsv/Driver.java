package com.jsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.jsv.hardware.OTH;
import com.jsv.command.Command;
import com.jsv.hardware.CPUList;
import com.jsv.instance.Instance;
import com.jsv.instance.ShortestJobTimeInstance;

public class Driver {
	
	private static final String NEW = "NEW";
	private static final String CPU = "CPU";
	private static final String OTH = "OTH";
	private static final int NUM_CPUS = 2;
	public static int clock = 0; //Start at time 0
	
//	public static PriorityQueue<OTH> othQueue;
//	public static CPUList ryan;
//	public static LinkedList<Instance> 
	
	
	/** Alternate CPU and other call. Always start with CPU. 
	 * @throws IOException 
	 * */
	
	
	
	public static void main(String[] args) throws IOException {		
		// First come first serve
		
		// Shortest Job First
		
		// Priority 
		// Pick the time of the next CPU call and find
		// Least other time
		// Total number of commands
		
		// Time slicing
		
		// Multiqueue
		
		
		List<Instance> instanceTable = new LinkedList<Instance>();
		int pid = 0;
		
		StringBuilder filePath = new StringBuilder("src/input.txt");
		BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()));
		
		String[] commandTime = new String[2];
		String line = reader.readLine();
		
		
		while(line != null) {
			commandTime = line.split(" ");
			
			// Make a new Instance
			if(commandTime[0].equals(NEW)) {
//				instanceTable.add(new FCFSInstance(pid, Integer.parseInt(commandTime[1])));
//				instanceTable.add(new TotalTimeInstance(pid, Integer.parseInt(commandTime[1])));
				instanceTable.add(new ShortestJobTimeInstance(pid, Integer.parseInt(commandTime[1])));
				pid++;
			}
			
			// CPU command
			if(commandTime[0].equals(CPU)) {
				// Get the last Instance and add a new command
				instanceTable.get(pid-1).addCommand(new Command(1, Integer.parseInt(commandTime[1])));
			}
						
			// Other command
			if(commandTime[0].equals(OTH)) {
				// Get the last Instance and add a new command
				instanceTable.get(pid-1).addCommand(new Command(2, Integer.parseInt(commandTime[1])));
			}
					
			// Read a new line
			line = reader.readLine();			
		} //Reads file in
		
		// Close the reader
		reader.close();
		
		
//		Queue<Instance> priority = new PriorityQueue<Instance>(instanceTable);

		/*
		for(int i = 0; !priority.isEmpty(); i++) {
			System.out.println(priority.poll().getPid());		
		}*/

		
	
		/*slechta.printList();
		
		System.out.println("Removing an Instance from CPU 1: " + slechta.pop(1).getPid());
		
		slechta.printList();*/
		Queue<OTH> othQueue = new PriorityQueue<OTH>();
		ArrayList<Instance> finishedList = new ArrayList<Instance>();
		
		int originalLength = instanceTable.size();
		CPUList cpuList = new CPUList(Driver.NUM_CPUS);
		
		
//		Driver.nextImportantEvent(othQueue, instanceTable, cpuList);
		
//		for(Instance instance : instanceTable)
//		{
//			cpuList.add(instance);
//		}
//		
		int nextTime;
		int flag;
		
		while(finishedList.size() != originalLength)
		{
			Driver.clock = nextImportantEvent(othQueue, instanceTable, cpuList);
			flag = Driver.checkTimes(othQueue, instanceTable, cpuList, Driver.clock);
			
			System.out.println(flag);
			
			if(flag==0) //0 = CPU, 1 = OTH, 2 = New
			{
				// TODO leave CPU and move to OTH or FINISH
			}
			else if(flag==1) //0 = CPU, 1 = OTH, 2 = New
			{
//				othQueue.add() // TODO leave OTH and move to CPU or FINISH
			}
			else if(flag==2) //0 = CPU, 1 = OTH, 2 = New
			{
				// TODO leave NEW and move to CPU
				cpuList.add(instanceTable.remove(0));
			}
			else {
				throw new IllegalArgumentException("-1");
			}
		}
		
		
	}
	/*
	public static int nextImportantEvent(Queue<OTH> othQueue, List<Instance> instanceList, CPUList cpuList) {
		int nextImportantTime = Integer.MAX_VALUE;
		
		
		if(!othQueue.isEmpty()) {
			nextImportantTime = Math.min(othQueue.peek().getExitTime(), nextImportantTime);
		}
		
		if(!instanceList.isEmpty())
		{
			nextImportantTime = Math.min(instanceList.get(0).getStartTime(), nextImportantTime);
		}
		
		if(!cpuList.getInstanceQueues().isEmpty())
		{
			nextImportantTime = Math.min(cpuList.getNextFinishTime(), nextImportantTime);
		}
		
		
		System.out.println("Next finish time: " + nextImportantTime);
		
		return nextImportantTime;
	}*/
	
	public static int checkTimes(Queue<OTH> othQueue, List<Instance> instanceList, CPUList cpuList,int importantTime)
	{
		
		int nextCpuTime;
		int nextOthTime;
		int nextNewTime;
		
		if(othQueue.isEmpty()){
			nextOthTime = Integer.MAX_VALUE;
		}else{
			nextOthTime = othQueue.peek().getExitTime();
		}
		
		if(cpuList.getInstanceQueues().isEmpty())
		{
			nextCpuTime = Integer.MAX_VALUE;
		}else{
			nextCpuTime = cpuList.getNextFinishTime();
		}
		
		if(instanceList.isEmpty())
		{
			nextNewTime = Integer.MAX_VALUE;
		}else{
			nextNewTime = instanceList.get(0).getStartTime();
		}
		
		if(importantTime == nextCpuTime)
		{
			return 0;
		}
		if(importantTime == nextOthTime)
		{
			return 1;
		}
		
		if(importantTime == nextNewTime)
		{
			return 2;
		}
		return -1;
	}
	
	public static int nextImportantEvent(Queue<OTH> othQueue, List<Instance> instanceList, CPUList cpuList)
	{
		int nextImportantTime = Integer.MAX_VALUE;
		
		int nextCpuTime;
		int nextOthTime;
		int nextNewTime;
		
		if(othQueue.isEmpty()){
			nextOthTime = Integer.MAX_VALUE;
		}else{
			nextOthTime = othQueue.peek().getExitTime();
		}
		
		if(cpuList.getInstanceQueues().isEmpty())
		{
			nextCpuTime = Integer.MAX_VALUE;
		}else{
			nextCpuTime = cpuList.getNextFinishTime();
		}
		
		if(instanceList.isEmpty())
		{
			nextNewTime = Integer.MAX_VALUE;
		}else{
			nextNewTime = instanceList.get(0).getStartTime();
		}
		
		nextImportantTime = Math.min(nextOthTime, nextCpuTime);
		nextImportantTime = Math.min(nextImportantTime, nextNewTime);
		
		System.out.println("Next finish time: " + nextImportantTime);
		
		return nextImportantTime;
	}
	
}
