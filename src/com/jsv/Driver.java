package com.jsv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.jsv.event.Event;
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
		// Total number of events
		
		// Time slicing
		
		// Multiqueue
		
		
		List<Instance> processTable = new LinkedList<Instance>();
		int pid = 0;
		
		StringBuilder filePath = new StringBuilder("src/input.txt");
		BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()));
		
		String[] commandTime = new String[2];
		String line = reader.readLine();
		
		
		while(line != null) {
			commandTime = line.split(" ");
			
			// Make a new process
			if(commandTime[0].equals(NEW)) {
//				processTable.add(new FCFSProcess(pid, Integer.parseInt(commandTime[1])));
//				processTable.add(new TotalTimeProcess(pid, Integer.parseInt(commandTime[1])));
				processTable.add(new ShortestJobTimeInstance(pid, Integer.parseInt(commandTime[1])));
				pid++;
			}
			
			// CPU event
			if(commandTime[0].equals(CPU)) {
				// Get the last process and add a new event
				processTable.get(pid-1).addEvent(new Event(1, Integer.parseInt(commandTime[1])));
			}
						
			// Other event
			if(commandTime[0].equals(OTH)) {
				// Get the last process and add a new event
				processTable.get(pid-1).addEvent(new Event(2, Integer.parseInt(commandTime[1])));
			}
					
			// Read a new line
			line = reader.readLine();			
		} //Reads file in
		
		// Close the reader
		reader.close();
		
		
		Queue<Instance> priority = new PriorityQueue<Instance>(processTable);
		
		/*
		for(int i = 0; !priority.isEmpty(); i++) {
			System.out.println(priority.poll().getPid());		
		}*/
				
		CPUList slechta = new CPUList(Driver.NUM_CPUS);
		for(Instance i : processTable)
		{
			slechta.add(i);
		}
		
		slechta.printList();
		System.out.println(slechta.pop(1).getPid());
		
		slechta.printList();
		
	}

}
