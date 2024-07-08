package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableFutureExampleWithCompose {

    public static void main(String[] args) {
        increaseAge(28, 1)
                .thenCompose(newAge -> increaseAge(newAge, 1))
                .thenCompose(newerAge -> increaseAge(newerAge, 1))
                .thenCompose(evenNewerAge -> increaseAge(evenNewerAge, 3))
                .thenAccept(veryOldAge -> log.info("finally {}", veryOldAge))
                .join();
    }

    public static CompletableFuture<Integer> increaseAge(int initialAge, int ageDifference) {
        return CompletableFuture.supplyAsync(() -> initialAge + ageDifference);
    }
}
