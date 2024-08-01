package ExceptionHandling;

//MultiThreadExample class extends the Thread class to create a custom thread
public class MultiThreadExample extends Thread {
 String threadName; // Variable to store the name of the thread

 // Constructor to initialize the thread name
 public MultiThreadExample(String threadName) {
     super(threadName); // Call the constructor of the Thread class with the thread name
     this.threadName = threadName;
 }

 // The run method contains the code that will be executed when the thread is started
 public void run() {
     // Print the name of the thread
     System.out.println("Name: " + this.getName());
     // Print the priority of the thread
     System.out.println("Priority: " + this.getPriority());
     try {
         // Sleep the thread for 500 milliseconds
         Thread.sleep(500);
     } catch (InterruptedException e) {
         // Print the stack trace if an InterruptedException occurs
         e.printStackTrace();
     }
     // Print the ID of the thread
     System.out.println("ID: " + this.getId());
 }

 // Main method to test the thread operations
 public static void main(String[] args) {
     // Create and start the first thread with the name "demoThread1"
     MultiThreadExample demo = new MultiThreadExample("demoThread1");
     demo.start();

     // Create and start the second thread with the name "demoThread2" and set its priority to 8
     MultiThreadExample demo1 = new MultiThreadExample("demoThread2");
     demo1.setPriority(8);
     demo1.start();

     // Create and start the third thread with the name "demoThread3"
     MultiThreadExample demo2 = new MultiThreadExample("demoThread3");
     demo2.start();
 }
}