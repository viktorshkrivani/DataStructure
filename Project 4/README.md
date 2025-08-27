# Project 4 🏥 — Triage Simulator with Priority Queues

## Overview
This project simulates a hospital emergency room triage system using priority queues.  
Patients are read from an input file and assigned to queues based on their triage code and urgency level.

## Features
- `TriageSimulator` maintains three queues (priority 1, 2, and 3).  
- `add()` reads patients from file and places them into the correct queue.  
- `remove()` returns the next patient to be treated based on priority rules.  
- `isEmpty()` checks if all queues are empty.  
- Patients with higher urgency are always treated before lower-priority ones.

## Sample Runs
Input file: [`data.txt`](./proj4/src/proj4/data.txt)  

## Example output:  
[Sample Images](./proj4/PROJSCREEN1.pdf)

## Files
- [`Main.java`](./proj4/src/proj4/Main.java) — Entry point, loads data and runs simulation.  
- [`Patient.java`](./proj4/src/proj4/Patient.java) — Represents a patient with name and triage code.  
- [`TriageSimulator.java`](./proj4/src/proj4/TriageSimulator.java) — Implements the triage logic.  

## Code Location
[Source code](./proj4/src/proj4)
