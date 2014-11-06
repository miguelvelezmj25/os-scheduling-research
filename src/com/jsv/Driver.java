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
	public static int clock = 0; //Start at time 0
	public static final int NUM_CPUS = 2;
	
	
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
		
		
		Queue<Instance> priority = new PriorityQueue<Instance>(instanceTable);

		/*
		for(int i = 0; !priority.isEmpty(); i++) {
			System.out.println(priority.poll().getPid());		
		}*/

						
		CPUList slechta = new CPUList(Driver.NUM_CPUS);
		
		for(Instance instance : instanceTable)
		{
			slechta.add(instance);
		}
		
	
		/*slechta.printList();
		
		System.out.println("Removing an Instance from CPU 1: " + slechta.pop(1).getPid());
		
		slechta.printList();*/
		Queue<OTH> othQueue = new PriorityQueue<OTH>();
		ArrayList<Instance> finishedList = new ArrayList<Instance>();
		int originalLength = instanceTable.size();
		
		while(finishedList.size() != originalLength)
		{
			System.out.println("Hey bro");
			finishedList.add(new Instance(0,0));
		}
		
		
	}
}
