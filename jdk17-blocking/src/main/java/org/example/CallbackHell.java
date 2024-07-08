package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
public class CallbackHell {

    public static void main(String[] args) {
        var increasedAge = increaseAge(28, 1,
                (newAge) -> increaseAge(newAge, 1,
                        (newerAge) -> increaseAge(newerAge, 1,
                                (evenNewerAge) -> increaseAge(evenNewerAge, 3,
                                        (veryOldAge) -> veryOldAge))));

        log.info("finally {}", increasedAge);


    }

    public static Integer increaseAge(int initialAge, int ageDifference, Function<Integer, Integer> callbackFunction) {
        int newAge = initialAge + ageDifference;
        return callbackFunction.apply(newAge);
    }

}
