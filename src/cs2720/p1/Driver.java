package cs2720.p1;

import java.io.*;
import java.util.*;

/**
 * The Driver class is responsible for running the program and interacting with
 * the user.
 * It provides a command-line interface for performing operations on a Binary
 * Search Tree (BST).
 * The user can insert items, delete items, print the tree, retrieve items,
 * count leaf nodes,
 * find single parents, find cousins, and quit the program.
 * 
 * @param <T> the type of elements stored in the BST, must implement the
 *            Comparable interface
 */
public class Driver<T extends Comparable<T>> {
    /**
     * Main method of Driver to run program.
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static String t = "";

    public static void main(String[] args) throws FileNotFoundException {
        File file = null;
        boolean quit = false;
        boolean badPrevAns = false;
        Scanner sc = new Scanner(System.in);

        // Scanner scan;
        System.out.print("Enter list type (i - int, d - double, s - std:string): ");

        final String choice = sc.nextLine();
        t = choice;
        BinarySearchTree<?> bst = null;
        // File "creation"
        switch (choice) {
            case ("i"): {
                file = new File("resources/int-input.txt");
                bst = new BinarySearchTree<Integer>();
                break;
            }
            case ("d"): {
                file = new File("resources/double-input.txt");
                bst = new BinarySearchTree<Double>();
                break;
            }
            case ("s"): {
                file = new File("resources/string-input.txt");
                bst = new BinarySearchTree<String>();
                break;
            }
            default: {
                System.err.println("Invalid file format");
                sc.close();
                throw new FileNotFoundException("FnFE");
            }

        } // end of switch statement

        // define bst here

        String commands = ("Commands:\n" +
                "(i) - Insert Item\n" +
                "(d) - Delete Item\n" +
                "(p) - Print Tree\n" +
                "(r) - Retrieve Item\n" +
                "(l) - Count Leaf Nodes\n" +
                "(s) - Find Single Parents\n" +
                "(c) - Find Cousins\n" +
                "(q) - Quit program");
        System.out.println(commands);
        String[] arr = readData(file).split(" ");
        for (int i = 0; i < arr.length; i++) {
            bst.convertAndInsert(arr[i].trim(), choice);
        }
        while (!quit) {
            if (!badPrevAns) {
                System.out.print("Enter a Command: ");
            }
            String cmd = sc.nextLine();
            cmd = cmd.toLowerCase();

            switch (cmd) {
                case "i":
                    badPrevAns = false; // will change this back to insert, just using it for figuring issues out rn.
                    System.out.print("Enter a number to insert: ");
                    String input = sc.nextLine();
                    bst.convertAndInsert(input, choice);
                    System.out.println(bst.toString());
                    break;
                case "d":
                    badPrevAns = false;
                    System.out.print("Enter an item to delete: ");
                    String item = sc.nextLine();
                    bst.convertAndDelete(item, choice);
                    System.out.println(bst.toString());
                    break;
                case "p":
                    badPrevAns = false;
                    System.out.println(bst.toString());
                    break;
                case "r":
                    badPrevAns = false;
                    System.out.print(bst.toString() + "\nEnter a number to search: ");
                    String ans = sc.nextLine();
                    bst.convertAndSearch(ans, choice);
                    break;
                case "l":
                    badPrevAns = false;
                    System.out.println("The number of leaf nodes are " + bst.getLeafCount());
                    break;
                case "s":
                    badPrevAns = false;
                    System.out.println("Single Parents: " + bst.getSingleParents());
                    break;
                case "c":
                    String word = "number";
                    if (choice.equals("s")) {
                        word = "string";
                    }
                    System.out.print(bst.toString() + "\nEnter a " + word + ": ");
                    String value = sc.nextLine();
                    System.out.print(value + "'s cousins: ");
                    bst.getCousinsConverted(value, choice);
                    System.out.print("\n");
                    break;
                case "q":
                    badPrevAns = false;
                    quit = true;
                    sc.close();
                    break;
                default:
                    badPrevAns = true;
                    System.out.println("Invalid command, try again: ");
                    break;
            } // switch statement
        } // while loop

    } // main

    /**
     * Reads the data from a file and returns it as a string.
     *
     * By Ryan Majd
     * 
     * @param file the file to read the data from
     * @return the data from the file as a string
     * @throws FileNotFoundException if the file is not found
     */
    private static String readData(File file) throws FileNotFoundException {
        try (Scanner reader = new Scanner(file)) {
            StringBuilder dataset = new StringBuilder();

            while (reader.hasNextLine()) {
                dataset.append(reader.nextLine()).append("\n");
            }
            return (dataset.toString());
        } catch (FileNotFoundException fnfe) {
            return "not a string";
        }

    } // readData()

} // Driver
