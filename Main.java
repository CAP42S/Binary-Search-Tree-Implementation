// Author: Samer Ali
// Description: This program simulates a binary search tree. The program implements
// an abstract data type that enables it to act as a more general data structure
// for all types of data instances.
// Date: December, 2022

import java.util.Scanner;


class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Table table = new Table();

    public static void main(String[] args) {
        System.out.println("Hello, this program simulates a binary " +
                "search tree as a table of FIFA players");
        System.out.println("Please select any of the following options " +
                "to proceed: ");
        int userInput;
        do {
            do {
                printOptions();
                userInput = scan.nextInt();
                if(userInput < 1 || userInput > 8) {
                    System.out.println("Please select options 1-8...");
                }
            }while(userInput < 1 || userInput > 8);
            scan.nextLine();
            initiateOption(userInput);
        }while(userInput != 8);
    }
    private static void printOptions() {
        System.out.println("1.) Initialize new table");
        System.out.println("2.) Insert new item");
        System.out.println("3.) Return data based on given item");
        System.out.println("4.) Return height of the tree");
        System.out.println("5.) Return number of nodes in tree");
        System.out.println("6.) Display the contents of the tree in a " +
                "tree like fashion");
        System.out.println("7.) Display the entire contents of the table " +
                "in order by their keys");
        System.out.println("8.) Quit Program");
    }
    private static void initiateOption(int option) {
        switch (option) {
            case 1: table = new Table();
                System.out.println("Operation Complete. New table " +
                        "initialized.");
                break;

            case 2:
                System.out.println("To insert new item, fill in the " +
                        "following...");

                System.out.print("Enter name of player: ");
                String name = scan.nextLine();
                System.out.print("\nEnter jersey number: ");
                int jerseyNumber = scan.nextInt();
                scan.nextLine();
                System.out.print("\nEnter player's country: ");
                String country = scan.nextLine();
                System.out.print("\nEnter average goals scored per game: ");
                double goalsScored = scan.nextDouble();
                FIFAPlayer fifaPlayer = new FIFAPlayer(jerseyNumber,
                        country, name, goalsScored);
                table.insertion(fifaPlayer);
                System.out.println("Operation Complete. " + name
                        + " has been added to table");
                break;

            case 3:
                System.out.println("To search for a key, fill in the " +
                        "following...");
                System.out.print("\nEnter player's country: ");
                String playerCountry = scan.nextLine();
                System.out.print("\nEnter player jersey number: ");
                int playerNumber = scan.nextInt();
                FIFAPlayerKey fifaPlayerKey = new FIFAPlayerKey(playerNumber,
                        playerCountry);
                Keyed data = table.search(fifaPlayerKey);
                System.out.println("Player info: " + data.briefSummary());
                break;

            case 4:
                System.out.println("The height of the tree is " +
                        table.getHeight());
                System.out.println("Operation completed.");
                break;

            case 5:
                System.out.println("The size of the tree is " +
                        table.getSize());
                System.out.println("Operation completed.");
                break;

            case 6:
                System.out.println("Displaying contents... ");
                table.showTree();
                System.out.println("Operation completed.");
                break;

            case 7:
                System.out.println("Displaying contents in order...");
                System.out.println(table);
                System.out.println("Operation completed.");
                break;

            case 8:
                System.out.println("Goodbye!");
                break;
        }
    }
}
