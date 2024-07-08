package org.example;


import java.util.concurrent.CompletableFuture;

public class CompletableFutureExampleWithCompose {

    public static void main(String[] args) {
        increaseAge(28, 1)
                .thenCompose(newAge -> increaseAge(newAge, 1))
                .thenCompose(newerAge -> increaseAge(newerAge, 1))
                .thenCompose(evenNewerAge -> increaseAge(evenNewerAge, 3))
                .thenAccept(veryOldAge -> System.out.printf("finally %s", veryOldAge))
                .join();
    }

    public static CompletableFuture<Integer> increaseAge(int initialAge, int ageDifference) {
        return CompletableFuture.supplyAsync(() -> initialAge + ageDifference);
    }
}
