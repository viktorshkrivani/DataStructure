# Project 3 📚 — ChangeStack (Custom Stack with Modifiers)

## Overview
This project implements a custom stack-like data structure using a linked chain of nodes.  
It behaves like a normal stack with `push` and `pop`, but also adds `increaseValues` and `decreaseValues` operations to modify elements.

## Features
- `ChangeStack` class with:
  - `push()` and `pop()` for stack behavior.  
  - `peekTop()` to view the top element.  
  - `increaseValues()` and `decreaseValues()` to adjust the bottom k elements.  
- Throws a custom `StackEmptyException` when popping or peeking from an empty stack.  
- Uses only a linked structure (no arrays).

## Sample Runs
Sample execution results can be found here:  
[Sample Image](./proj3/Proj3.pdf) 

## Files
- `ChangeStack.java` — Defines the custom stack and its operations.   

## Code Location
[ChangeStack.java](./proj3/proj3/src/proj3/ChangeStack.java) 
