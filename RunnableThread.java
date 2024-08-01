package ExceptionHandling;

//DThread class implements the Runnable interface to create a custom runnable task
class DThread implements Runnable {
 @Override
 public void run() {
     // Print the name of the currently executing thread
     System.out.println("Thread Name: " + Thread.currentThread().getName());
     // Print the priority of the currently executing thread
     System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
 }
}

//RunnableThread class contains the main method to test the runnable task
public class RunnableThread {

 public static void main(String[] args) {
     // Print the name of the main thread
     System.out.println("Thread Name: " + Thread.currentThread().getName());
     
     // Create an instance of the DThread class
     DThread dthread = new DThread();
     // Create a new Thread object, passing the DThread instance and setting the thread name to "Demo one"
     Thread t = new Thread(dthread, "Demo one");
     // Start the newly created thread
     t.start();
 }
}