

### **1. Basics of Threads**
- A **thread** is a lightweight process that allows concurrent execution in Java.
- Java provides **multithreading** to improve performance and responsiveness.
- Threads can be created in two ways:
    1. **Extending `Thread` class**
    2. **Implementing `Runnable` interface**

### **2. Creating Threads**
```java
// Using Thread class
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}
MyThread t = new MyThread();
t.start(); // Starts a new thread
```
```java
// Using Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}
Thread t = new Thread(new MyRunnable());
t.start();
```

### **3. Thread Lifecycle**
- **New:** Thread created but not started.
- **Runnable:** Ready to run but waiting for CPU time.
- **Running:** Actively executing.
- **Blocked/Waiting:** Waiting for a resource or signal.
- **Terminated:** Execution completed or stopped.

### **4. Thread Methods**
- `start()` → Begins execution of a thread.
- `run()` → Defines thread behavior (called internally).
- `sleep(ms)` → Pauses execution for a given time.
- `join()` → Waits for a thread to finish before proceeding.
- `yield()` → Suggests thread scheduler to give CPU to another thread.

### **5. Thread Synchronization**
- To avoid **race conditions**, synchronization is used.
- **Synchronized block** ensures only one thread accesses a resource at a time.
```java
class SharedResource {
    synchronized void printNumbers() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
    }
}
```
- **Locking Mechanisms**: `ReentrantLock`, `synchronized`, `volatile`, `Atomic Variables`.

### **6. Thread Communication**
- **Methods like `wait()`, `notify()`, `notifyAll()`** help threads communicate.
```java
synchronized void method() {
    wait();  // Releases lock and waits
    notify(); // Wakes up waiting thread
}
```

### **7. Concurrency Utilities (`java.util.concurrent`)**
- **Executors:** Manages thread pools (`ExecutorService`).
- **Callable & Future:** Supports returning values from threads.
- **Concurrent Collections:** Thread-safe versions of collections (e.g., `ConcurrentHashMap`).

---
