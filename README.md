OS Scheduling Research
===================

OS final project researching scheduling algorithms. We developed a Java program that simulated the execution of processes using different scheduling algorithms. We ran our simulations using 1, 4, 8, and 16 CPUs since those are some common configurations you find in current computers. 

The algorithms we tested were First Come First Serve (FCFS), Shortest Job Time (SJT), Shortest Total Time (STT), Highest CPU Ratio (HCPUR), Lowest CPU Ratio (LCPUR), and Round Robin with different time slicing. The different quanta we use were 5 (RR5), the minimum execution command time (RRMin), the maximum execution command time (RRMax), and half of the maximum execution command time (RRHalf). 

We concluded that FCFS performs better with more processes and CPUs and, overall, it performs the best of all algorithms on multiple CPUs. We also confirmed that RR approximates FCFS fairly well with multiple CPUs. Finally, SJT and LCPUR may seem better, but when more processes were executed, we experience starvation and did not perform as well as others

===================
Thanks to Zaktius and rslechta for their contributions.
