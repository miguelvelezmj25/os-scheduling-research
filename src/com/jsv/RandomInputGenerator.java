package com.jsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomInputGenerator {
	
	public static void main(String[] args) throws IOException { 
		Random rand = new Random();
		int numProcesses = 75;
		int numCpus = 0;
		int newStartTime = 0;
		int randStartTime = 0;
		int cpuTime = 0;
		int othTime = 0;
		
		File file = new File("src/random.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,false));
	
		
		for(int i=0;i<numProcesses;i++) {
			randStartTime = rand.nextInt(100);
			newStartTime += randStartTime;
			bw.write("NEW "+newStartTime);
			bw.newLine();
			
			do{
				numCpus = rand.nextInt(10);
			} while(numCpus == 0);
			
			for(int j=0;j<numCpus;j++) {
				cpuTime = rand.nextInt(500);
				othTime = rand.nextInt(500);
				bw.write("CPU "+cpuTime);
				bw.newLine();
				bw.write("OTH "+othTime);
				bw.newLine();
			}
			
		}
		
		bw.close();
	}

}
