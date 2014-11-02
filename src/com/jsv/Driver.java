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
import com.jsv.process.Process;
import com.jsv.process.ShortestJobTimeProcess;

public class Driver {
	
	private static final String NEW = "NEW";
	private static final String CPU = "CPU";
	private static final String OTH = "OTH";
	
	
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
		
		List<Process> processTable = new LinkedList<Process>();
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
				processTable.add(new ShortestJobTimeProcess(pid, Integer.parseInt(commandTime[1])));
				pid++;
			}
			
			// CPU event
			if(commandTime[0].equals(CPU)) {
				// Get the last process and add a new event
				processTable.get(pid-1).addEvent(new Event(true, Integer.parseInt(commandTime[1])));
			}
						
			// Other event
			if(commandTime[0].equals(OTH)) {
				// Get the last process and add a new event
				processTable.get(pid-1).addEvent(new Event(false, Integer.parseInt(commandTime[1])));
			}
					
			// Read a new line
			line = reader.readLine();			
		}
		
		// Close the reader
		reader.close();
		
		
		Queue<Process> priority = new PriorityQueue<Process>(processTable);
			

		
		for(int i = 0; !priority.isEmpty(); i++) {
			System.out.println(priority.poll().getPid());		
		}
	}

}
