package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class CompletableFutureExampleRecursive {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        final BiFunction<Integer, Integer, Integer> calculationCalllback = Integer::sum;

        incrementRecursively(0, 1, 1_000_000, calculationCalllback)
                .thenAccept(finalAge -> System.out.printf("finally %s", finalAge))
                .join();
    }


    public static CompletableFuture<Integer> incrementRecursively(int current, int increment, int to,
                                                                  BiFunction<Integer, Integer, Integer> calculationCallback) {
        final var incremented = calculationCallback.apply(current, increment);
        System.out.printf("Thread %s count %s\n", Thread.currentThread().getName(), incremented);
        if (incremented == to) {
            return CompletableFuture.completedFuture(incremented);
        } else {
            return CompletableFuture.supplyAsync(() -> incremented, executor)
                    .thenCompose(newAge -> incrementRecursively(newAge, increment, to, calculationCallback));
        }
    }


}
