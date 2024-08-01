package ExceptionHandling;

class Order {
    private boolean isPaid = false;

    public synchronized void makePayment() {
        System.out.println("Processing payment...");
        try {
            Thread.sleep(1000); // Simulate time taken for payment processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isPaid = true;
        System.out.println("Payment completed.");
        notify(); // Notify the waiting thread (order) that payment is done
    }

    public synchronized void placeOrder() {
        if (!isPaid) {
            System.out.println("Waiting for payment to complete...");
            try {
                wait(); // Wait until payment is done
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Order placed successfully.");
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        Order order = new Order();

        Thread paymentThread = new Thread(() -> {
            order.makePayment();
        });

        Thread orderThread = new Thread(() -> {
            order.placeOrder();
        });

        // Start the threads
        orderThread.start();
        paymentThread.start();
    }
}
