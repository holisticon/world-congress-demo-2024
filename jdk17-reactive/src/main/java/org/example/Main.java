package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Flux.range(0, 1_000_000)
                .parallel(1_000)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(num -> System.out.printf("Thread %s no %s\n", Thread.currentThread().getName(), num))
                .flatMap(num -> Mono.just(num).delayElement(Duration.of(10_000, ChronoUnit.MILLIS)))
                .sequential()
                .doOnComplete(() -> System.out.print("done\n"))
                .blockLast();
    }
}