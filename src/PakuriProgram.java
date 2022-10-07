import java.util.Scanner;

// The main program which the user will interact with.
public class PakuriProgram {
    public static void main(String[] args) {
        // List of variables we will use to know if the user entered a correct value for capacity
        String testMaxPakuri;
        int maxPakuri = 0;
        boolean validCap = false;
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        Scanner scanner = new Scanner(System.in);
        // Checks if user entered a valid value for size
        while (!validCap) {
            System.out.print("Enter max capacity of the Pakudex: ");
            try {
                testMaxPakuri = scanner.next();
                maxPakuri = Integer.parseInt(testMaxPakuri);
                if (maxPakuri < 1) {
                    System.out.println("Please enter a valid size.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
                continue;
            }
            validCap = true;
        }
        // Tells the user how many Pakuri the Pakudex can hold and proceeds to the loop
        System.out.println("The Pakudex can hold " + maxPakuri + " species of Pakuri.");
        Pakudex pakudex = new Pakudex(maxPakuri);
        int option = 0;
        String optionValid;

        // Main menu loop where the user will be asked on what he wants to do with the Pakudex
        do {
            String[] currentPakArr = pakudex.getSpeciesArray();
            System.out.println("\nPakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit\n");
            System.out.print("What would you like to do? ");
            //Checks if the option the user has entered is valid. If not, he will be asked enter an option again.
            try {
                optionValid = scanner.next();
                option = Integer.parseInt(optionValid);
            } catch (Exception e) {
                System.out.println("Unrecognized menu selection!");
                continue;
            }
            // List Pakuri
            if (option == 1) {
                if (currentPakArr == null) {
                    System.out.println("No Pakuri in Pakudex yet!");
                } else {
                    System.out.println("Pakuri In Pakudex:");
                    for (int i = 0; i < currentPakArr.length; i++) {
                        if (currentPakArr[i] != null) {
                            System.out.println(i + 1 + ". " + currentPakArr[i]);
                        }
                    }
                }
                // Show a specific Pakuri and its stats
            } else if (option == 2) {
                System.out.print("Enter the name of the species to display: ");
                String displayPakuri = scanner.next();
                // Checks if the pakuri exist in the Pakudex

                int[] statsArray = pakudex.getStats(displayPakuri);
                if (statsArray == null) {
                    System.out.println("Error: No such Pakuri!");
                } else {
                    System.out.println("\nSpecies: " + displayPakuri);
                    System.out.println("Attack: " + statsArray[0]);
                    System.out.println("Defense: " + statsArray[1]);
                    System.out.println("Speed: " + statsArray[2]);
                }
                // Adds a pakuri in the Pakudex
            } else if (option == 3) {
                // Checks if the Pakudex is full
                if (pakudex.getCapacity() == pakudex.getSize()) {
                    System.out.println("Error: Pakudex is full!");
                } else {
                    System.out.print("Enter the name of the species to add: ");
                    String newPakuri = scanner.next();
                    pakudex.addPakuri(newPakuri);
                }
                // Ask user to select a species to evolve
            } else if (option == 4) {
                System.out.print("Enter the name of the species to evolve: ");
                String evolvePakuri = scanner.next();
                boolean evolveSpecies = pakudex.evolveSpecies(evolvePakuri);
                if (evolveSpecies == true) {
                    System.out.println(evolvePakuri + " has evolved!");
                } else {
                    System.out.println("Error: No such Pakuri!");
                }
                // Sort the Pakudex
            } else if (option == 5) {
                pakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }
            // Exit the program with a goodbye statement
            else if (option == 6) {
                System.out.println("Thanks for using Pakudex! Bye!");
            }
            // Used to check if the integer from option is not valid
            else {
                System.out.println("Unrecognized menu selection!");
            }
        } while (option != 6);
    }
}