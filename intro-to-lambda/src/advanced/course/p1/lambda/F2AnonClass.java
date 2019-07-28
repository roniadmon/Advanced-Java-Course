package advanced.course.p1.lambda;

import java.util.concurrent.*;

public class F2AnonClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> submit = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                return 42;
            }
        });

        System.out.println("The Meaning of all is... " + submit.get() + "!");
    }
}
