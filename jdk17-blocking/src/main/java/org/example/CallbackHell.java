package org.example;

import java.util.function.Function;

public class CallbackHell {

    public static void main(String[] args) {
        var increasedAge = increaseAge(28, 1,
                (newAge) -> increaseAge(newAge, 1,
                        (newerAge) -> increaseAge(newerAge, 1,
                                (evenNewerAge) -> increaseAge(evenNewerAge, 3,
                                        (veryOldAge) -> veryOldAge))));

        System.out.printf("finally %s", increasedAge);


    }

    public static Integer increaseAge(final int initialAge,
                                      final int ageDifference,
                                      final Function<Integer, Integer> callbackFunction) {
        int newAge = initialAge + ageDifference;
        return callbackFunction.apply(newAge);
    }

}
