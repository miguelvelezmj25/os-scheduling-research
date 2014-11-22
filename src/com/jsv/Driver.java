package com.jsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
import com.jsv.instance.FCFSInstance;
import com.jsv.instance.ShortestJobTimeInstance;
import com.jsv.instance.TotalTimeInstance;

public class Driver {
	
	private static final String NEW = "NEW";
	private static final String CPU = "CPU";
	private static final String OTH = "OTH";
	private static final int NUM_CPUS = 1;
	public static int clock = 0; //Start at time 0
		
	
	/** Alternate CPU and other call. Always start with CPU. 
	 * @throws IOException 
	 * */
	public static void main(String[] args) throws IOException {		
		/***
		 * First come first serve
		 * Shortest Job First
		 * Priority
		 * Pick the time of the next CPU call and find
		 * Least other time
		 * Total number of commands
		 * Time slicing
		 * Multiqueue
		 */
		
		List<Instance> instanceTable = new LinkedList<Instance>();
		
		Driver.readInput(instanceTable);
						
		Queue<OTH> othQueue = new PriorityQueue<OTH>();
		ArrayList<Instance> finishedList = new ArrayList<Instance>();
		
		int originalLength = instanceTable.size();
		CPUList cpuList = new CPUList(Driver.NUM_CPUS);
		
	
		int nextTime;
		int command;
		
		while(finishedList.size() != originalLength)
		{
			Driver.clock = nextImportantEvent(othQueue, instanceTable, cpuList);
			command = Driver.checkTimes(othQueue, instanceTable, cpuList, Driver.clock);
			
			System.out.println("\tCommand: " + command);
			Instance instance;
			
			if(command==2) //0 = CPU, 1 = OTH, 2 = New
			{
				cpuList.add(instanceTable.remove(0));
			}
			else if(command==1) //0 = CPU, 1 = OTH, 2 = New
			{
				instance = othQueue.poll().getInstance();
				instance.removeCommand();
				if(instance.isEmpty())
				{
					System.out.println("Instance " + instance.getPid() + " is done");
					finishedList.add(instance);
				}
				else
				{
					cpuList.add(instance);
				}				

			}
			else if(command==0) //0 = CPU, 1 = OTH, 2 = New
			{
				for(int i = 0; i < NUM_CPUS; i++) {
					if(cpuList.getCPU(i).getCurrentInstanceFinishTime() == Driver.clock) {
						instance = cpuList.pop(i);
						
						if(instance.isEmpty())
						{
							System.out.println("Instance " + instance.getPid() + " is done");
							finishedList.add(instance);
						}
						else
						{
							othQueue.add(new OTH(instance));
						}											
					}
				}
				
			}
			else {
				throw new IllegalArgumentException("-1");
			}
			
			
		}
		
		System.out.println("\n########### We are done broski at time " + Driver.clock + " ###########");
		
	}
			
	public static void readInput(List<Instance> instanceTable) throws IOException {
		int pid = 0;
		
		//StringBuilder filePath = new StringBuilder("src/input.txt");
		StringBuilder filePath = new StringBuilder("src/random.txt");
		BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()));
		
		String[] commandTime = new String[2];
		String line = reader.readLine();
		
		
		while(line != null) {
			commandTime = line.split(" ");
			
			;
			// Make a new Instance
			if(commandTime[0].equals(NEW)) {
				instanceTable.add(new FCFSInstance(pid, Integer.parseInt(commandTime[1])));
//				instanceTable.add(new TotalTimeInstance(pid, Integer.parseInt(commandTime[1])));
//				instanceTable.add(new ShortestJobTimeInstance(pid, Integer.parseInt(commandTime[1])));
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
		
		for(Instance instance :instanceTable) {
			System.out.println("Pid: " + instance.getPid());
			System.out.println("Start time: " + instance.getStartTime());
			System.out.println("Commands: ");
			
			for(Command command :instance.getCommandList()) {
				System.out.println("\t" + command.getCommandType() + " - " + command.getTimeCommand());				
			}
			
			System.out.println("");
		}
	}
	
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
		
		nextCpuTime = cpuList.getNextFinishTime();

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
				
		nextCpuTime = cpuList.getNextFinishTime();

		if(instanceList.isEmpty())
		{
			nextNewTime = Integer.MAX_VALUE;
		}else{
			nextNewTime = instanceList.get(0).getStartTime();
		}
		
		nextImportantTime = Math.min(nextOthTime, nextCpuTime);
		nextImportantTime = Math.min(nextImportantTime, nextNewTime);
		
		System.out.println("\n################## NEXT IMPORTANT TIME: " + nextImportantTime);
		
		return nextImportantTime;
	}
	
}
