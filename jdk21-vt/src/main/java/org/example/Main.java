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
                        System.out.printf("Thread %s no %s\n", Thread.currentThread().getName(), number);

                        Thread.sleep(10_000);
                    } catch (final InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

            // ########################################################################################################

            executor.shutdown();

            final var terminated = executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
            System.out.printf("done %s\n", terminated);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}