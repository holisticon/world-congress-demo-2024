package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExampleWithApply {

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        increaseAge(28, 1)
                .thenApply(newAge -> increaseAge(newAge, 1)
                        .thenApply(newerAge -> increaseAge(newerAge, 1)
                                .thenApply(evenNewerAge -> increaseAge(evenNewerAge, 3)
                                        .thenAccept(veryOldAge -> System.out.printf("finally %s", veryOldAge))
                                        .join())
                                .join())
                        .join())
                .join();
    }

    public static CompletableFuture<Integer> increaseAge(int initialAge, int ageDifference) {
        System.out.printf("Thread %s", Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(() -> initialAge + ageDifference, executor);
    }

}