package net.mirwaldt.streams;

import java.util.List;

public class Example_07b_PrintOutNamesInUpperCase {
    public static void main(String[] args) {
        List<String> names = List.of("Heinz", "Venkat", "Nicolai", "Michael");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        /*
        result:
            HEINZ
            VENKAT
            NICOLAI
            MICHAEL
        */
    }
}
