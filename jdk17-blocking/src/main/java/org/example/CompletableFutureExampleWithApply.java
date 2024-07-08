package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CompletableFutureExampleWithApply {

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        increaseAge(28, 1)
                .thenApply(newAge -> increaseAge(newAge, 1)
                        .thenApply(newerAge -> increaseAge(newerAge, 1)
                                .thenApply(evenNewerAge -> increaseAge(evenNewerAge, 3)
                                        .thenAccept(veryOldAge -> log.info("finally {}", veryOldAge))
                                        .join())
                                .join())
                        .join())
                .join();
    }

    public static CompletableFuture<Integer> increaseAge(int initialAge, int ageDifference) {
        log.info("Thread {}", Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(() -> initialAge + ageDifference, executor);
    }

}