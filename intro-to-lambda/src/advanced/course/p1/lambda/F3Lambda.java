package advanced.course.p1.lambda;

import java.util.concurrent.*;

public class F3Lambda {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> submit = executor.submit(() -> 42);
        // and see bytecode

        System.out.println("The Meaning of all is... " + submit.get() + "!");
    }
}
