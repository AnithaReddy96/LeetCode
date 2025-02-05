# Threads

## What is a Thread ?

A Thread is smallest executable unit in a process

## Ways to create to Thread

There are 2 basic ways and 3 advanced ways to create a Thread in Java

1. By Extending a Thread Class
2. By Implementing a Runnable Interface
3. Using ExecutorService
4. Using Callable Interface
5. ForkJoinPool (for parallelism)

## Points to remember while creating Thread

--> We should not override start method, otherwise it will not create a new thread and the object will run in a main tread.
--> If we don't override run method a default empty run method will get executed.
--> Restarting a thread will give runtime exception as IllegalThreadStateException, so we should not call the thread object more than once.
### 1. By Extending a Class
--> When we extend a Thread class we should override run().
--> We should call start() method on a thread object to create a new thread in Thread Pool. 

### 2. By Implementing Runnable interface
--> you must implement run method

   

