

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Create a rainforest with default size
        Rainforest rainforest = new Rainforest();

        // Create a monkey and add it to the rainforest
        Monkey monkey1 = new Monkey(1, "Koko", new Date("2000-01-01"), true);
        rainforest.addMonkey(monkey1);

        // Create another monkey and add it to the rainforest
        Monkey monkey2 = new Monkey(2, "Luna", new Date("2005-02-02"), true);
        rainforest.addMonkey(monkey2);

        // Search for a monkey by name
        Monkey searchedMonkey = rainforest.searchMonkey("Koko");
        System.out.println("Found monkey: " + searchedMonkey);

        // Sort the monkeys by birthdate
        Monkey[] sortedMonkeys = rainforest.sorted();
        System.out.println("Sorted monkeys: " + Arrays.toString(sortedMonkeys));

        // Save the monkeys to a file
        try {
            rainforest.toFile("monkeys.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read monkeys from a file
        try {
            rainforest.fromFile("monkeys.txt");
        } catch (IOException | CorruptedFileException e) {
            e.printStackTrace();
        }
    }
}

