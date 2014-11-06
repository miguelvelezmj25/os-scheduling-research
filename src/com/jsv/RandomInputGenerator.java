package com.jsv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomInputGenerator {
	
	public static void main(String[] args) throws IOException
	{
		Random rand = new Random();
		int num_processes = 4;
		int num_cpus = 0;
		int cum_start_time = 0;
		int rand_start_time = 0;
		int cpu_time = 0;
		int oth_time = 0;
		
		File file = new File("src/rando.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file,false));
	
		
		for(int i=0;i<num_processes;i++)
		{
			rand_start_time = rand.nextInt(100);
			cum_start_time += rand_start_time;
			bw.write("NEW "+cum_start_time);
			bw.newLine();
			do{
				num_cpus = rand.nextInt(10);
			}while(num_cpus == 0);
			
			for(int j=0;j<num_cpus;j++)
			{
				cpu_time = rand.nextInt(500);
				oth_time = rand.nextInt(500);
				bw.write("CPU "+cpu_time);
				bw.newLine();
				bw.write("OTH "+oth_time);
				bw.newLine();
			}
			
		}
		
		bw.close();
	}

}
