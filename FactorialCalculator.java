package ExceptionHandling;

public class FactorialCalculator {
    // Synchronized method to calculate factorial
    public synchronized long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();

        // Creating threads to calculate factorials of different numbers
        Thread thread1 = new Thread(() -> {
            int number = 5;
            long result = calculator.calculateFactorial(number);
            System.out.println("Factorial of " + number + " is " + result);
        });

        Thread thread2 = new Thread(() -> {
            int number = 7;
            long result = calculator.calculateFactorial(number);
            System.out.println("Factorial of " + number + " is " + result);
        });

        // Starting the threads
        thread1.start();
        thread2.start();
    }
}
