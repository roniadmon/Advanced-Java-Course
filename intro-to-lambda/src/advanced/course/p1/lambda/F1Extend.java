package advanced.course.p1.lambda;

import java.util.concurrent.*;

public class F1Extend {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> submit = executor.submit(new MyCallable());

        System.out.println("The Meaning of all is... " + submit.get() + "!");
    }

    public static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() {
            return 42;
        }
    }
}
