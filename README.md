OS Scheduling Research
===================

[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/mijecu25/dsa/master/LICENSE)

OS final project researching scheduling algorithms. We developed a Java program that simulated the execution of processes using different scheduling algorithms. We ran our simulations using 1, 4, 8, and 16 CPUs since those are some common configurations you find in current computers. 

The algorithms we tested were First Come First Serve (FCFS), Shortest Job Time (SJT), Shortest Total Time (STT), Highest CPU Ratio (HCPUR), Lowest CPU Ratio (LCPUR), and Round Robin with different time slicing. The different quanta we use were 5 (RR5), the minimum execution command time (RRMin), the maximum execution command time (RRMax), and half of the maximum execution command time (RRHalf). 

We concluded that FCFS performs better with more processes and CPUs and, overall, it performs the best of all algorithms on multiple CPUs. We also confirmed that RR approximates FCFS fairly well with multiple CPUs. Finally, SJT and LCPUR may seem better, but when more processes were executed, we experience starvation and did not perform as well as others

================

###License

The MIT License (MIT)

Copyright (c) 2014 Jack Jensen, Ryan Slechta, Miguel Velez

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

===================
Thanks to Zaktius and rslechta for their contributions.
