## Overview
- Java implementation of Scheduling Algorithm: `First Come First Serve` and `Round Robin`.

## Algorithm
- First Come First Serve:
  - Queue.java (Used for implementing process FIFO queue)
  - Process.java (Used for implementing every single process)
  - FCFSSCheduling.java (Main Program for the algorithm)

- Round Robin:
  - Queue.java (Used for implementing process FIFO queue)
  - RoundRobinProcess.java (Inherit from Process class. Has additional `slice` arraylists)
  - RoundRobin.java (Main Program for the algorithm where all processes arrived at time 0)
  - RoundRobin.java (Main Program for the algorithm where all processes have differen arrival time )
