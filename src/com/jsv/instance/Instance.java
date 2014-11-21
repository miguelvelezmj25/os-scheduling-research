package com.jsv.instance;

import java.util.LinkedList;
import java.util.List;

import com.jsv.command.Command;

/**
 * Instance class that has a pid, a start time, and a list of commands that it 
 * executes. It implements the Comparable interface. Commands will get removed
 * from the list once they are completed
 */

public class Instance implements Comparable<Instance>{
	private List<Command> 	commandList = new LinkedList<Command>();
	private int				pid;
	private int				startTime;
	
	
	public Instance(int pid, int startTime) {
		this.pid = pid;
		this.startTime = startTime;
	}
	
	@Override
	// TODO Are we going to change this?
	public int compareTo(Instance instance) {
		return 0;
	}

	/** Returns whether or not there are more commands.
	 */
	public boolean isEmpty() {
		return this.getCommandList().isEmpty();
	}
	
	/** Removes the first command in the command list and returns
	 * it
	 */
	public Command removeCommand() {
		return this.getCommandList().remove(0);
	}
	
	/** Adds an Command to the command list
	 */
	public void addCommand(Command command) {
		this.getCommandList().add(command);
	}
	
	/** Getting the total time of all of the commands of this Instance
	 */
	protected int getTotalTime() {
		int totalTime = 0;
		
		for(Command command : this.getCommandList()) {
			totalTime = totalTime + command.getTimeCommand();
		}
		
		return totalTime;
	}
	
	/** Returns the Command time of the next CPU command
	 */
	public int getNextCPUCommandTime() {
		if(!this.getCommandList().get(0).getIsCPU()) {
			throw new IllegalArgumentException("Next Command is not CPU, it is " + 
					this.getCommandList().get(0).getCommandType() + ". Instance is in CPU queue");
		}
		
		return this.commandList.get(0).getTimeCommand();
	}
	
	/** Get the Command time of the next OTH command
	 */
	public int getNextOTHCommandTime() {
		if(this.getCommandList().get(0).getIsCPU()){ 
			throw new IllegalArgumentException("Next Command is not OTH, it is " + 
					this.getCommandList().get(0).getCommandType() + ". Instance is in CPU queue");
		}
		
		return this.commandList.get(0).getTimeCommand();
	}
		
	/** Returns the total number of commands.
	 */
	private int getTotalNumberCommands() {
		return this.getCommandList().size();
	}

	
	
	
	// Getters
	public int getPid() { return this.pid; }

	public List<Command> getCommandList() {
		return this.commandList;
	}

	public int getStartTime() {	return this.startTime; }

	
	
	// Setters
//	private void setCommandList(List<Command> commandList) {
//		this.commandList = commandList;
//	}
//
//	private void setPid(int pid) {
//		this.pid = pid;
//	}
//
//	private void setStartTime(int startTime) {
//		this.startTime = startTime;
//	}
}