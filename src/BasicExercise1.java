public class BasicExercise1 {
    public static void run() {
        System.out.println("[Exercise 1] Calculate sum of the first 10 numbers");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum = " + sum);
    }
}
