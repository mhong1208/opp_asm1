public class BasicExercise2 {
    public static void run() {
        System.out.println("[Exercise 2] Check even/odd numbers from 1 to 5");
        for (int i = 1; i <= 5; i++) {
            String kind = (i % 2 == 0) ? "even" : "odd";
            System.out.println(i + " is " + kind);
        }
    }
}
