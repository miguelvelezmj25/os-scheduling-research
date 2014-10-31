package com.jsv.process;

public class FCFSProcess extends Process {

	public FCFSProcess(int pid, int startTime) {
		super(pid, startTime);
	}
	
	@Override
	public int compareTo(Process o) {
		if(super.getPid() < o.getPid()) {
			return -1;
		}
		
		return 1;
	}

}
