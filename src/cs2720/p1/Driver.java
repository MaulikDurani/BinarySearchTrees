package cs2720.p1;

import java.io.*;
import java.util.*;

public class Driver<T extends Comparable<T>> {
    /**
     * Main method of Driver to run program.
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = null;
        boolean quit = false;
        boolean badPrevAns = false;
        Scanner sc = new Scanner(System.in);
        // Scanner scan;
        System.out.print("Enter list type (i - int, d - double, s - std:string): ");

        String choice = sc.nextLine();
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
	String type = "s";
        if (choice.equals("s")) {
            bst.insert(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                bst.insert(arr[i].trim());
            }
        } else if (choice.equals("i")) {
            bst.insert(Integer.parseInt(arr[0]));
            for (int i = 1; i < arr.length; i++) {
                bst.insert(Integer.parseInt(arr[i].trim()));
            }
        } else {
            bst.insert(Double.parseDouble(arr[0]));
            for (int i = 1; i < arr.length; i++) {
                bst.insert(Double.parseDouble(arr[i].trim()));
            }
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
		    bst.convertAndInsert(input);
		    System.out.println(bst.toString());
		    System.out.print("TREE: \n");
                    bst.toTree();
                    break;
                case "d":
                    quit = true;
                    System.out.print("Enter an item to delete: ");
                    break;
                case "p":
                    badPrevAns = false;
                    System.out.println(bst.toString());
                    break;
                case "r":
                    badPrevAns = false;
                    System.out.print("retrieve item");
                    break;
                case "l":
                    badPrevAns = false;
		    int numLeafNodes = bst.getLeafCount();
		    System.out.println("The number of leaf nodes are " + numLeafNodes);
                    break;
                case "s":
                    badPrevAns = false;
                    System.out.println("find single parents");
                    break;
                case "c":
                    System.out.print("find cousins");
                    break;
                case "q":
                    badPrevAns = false;
                    quit = true;
                    break;
                default:
                    badPrevAns = true;
                    System.out.println("Invalid command, try again: ");
                    break;
            } // switch statement
        } // while loop

    } // main

    /**
     * !File creation will be updated to create the bst objects later on!.
     * 
     * @param file
     * @return String representing the bst object.
     * @throws FileNotFoundException
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

}
