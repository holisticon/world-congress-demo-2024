package org.example;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor;

public class Main {
    public static void main(String[] args) {
        try (
            final var executor = newVirtualThreadPerTaskExecutor()) {
            // ########################################################################################################

            for (int i = 0; i <= 1_000_000; i++) {
                int number = i;
                executor.submit(() -> {
                    try {
                        System.out.printf("Thread %s counted %s\n", Thread.currentThread().threadId(), number);

                        Thread.sleep(10_000);
                    } catch (final InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

            // ########################################################################################################
            executor.shutdown();
            final var terminated = executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
            System.out.println(">>>>> done !!!\n");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}