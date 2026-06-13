/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;
/**
 *
 * @author danvicedaa
 * EXERCISE 11
 * 1. load reference link: https://www.teknogadyet.com/2019/08/smart-prepaid-text-call-internet-promos.html
 * 
 * Might change my comments in the code in the future for better clarity, just stay it like that to understand the flow and concept of code
 */

//TO DO TOM: CLEAN CODE READABILITY
import java.util.Scanner;

public class LoadRegistrationApp {

    static Scanner sc = new Scanner(System.in); // the scanner now can be accessible in any class
    static double moneyBalance = 500.03;

    public static void main(String[] args) {

        enterUssdCode();

        // The app will keep running and showing the main menu unless they exit
        while (true) {
            
            try {
                System.out.println("\n==========================");
                System.out.println("      MAIN MENU           ");
                System.out.println("==========================");
                System.out.println("Balance: P" + moneyBalance);
                System.out.println("--------------------------");
                System.out.println("[1] GIGA VIDEO");
                System.out.println("[2] GIGA VIDEO+");
                System.out.println("[3] GIGA ALL NET");
                System.out.println("[4] GIGA IG+FB+TikTok");
                System.out.println("[5] GIGA GAMES");
                System.out.println("[6] Exit");
                
                System.out.print("Choice: ");
                int choice = sc.nextInt(); //  i think its better to use int here for me to use try catch
                sc.nextLine();

                switch (choice) {
                    case 1:
                        showPromoMenu("GIGA VIDEO 50", "4GB", "3 days", 50,
                                      "GIGA VIDEO 99", "9GB", "7 days", 99);
                        break;
                    case 2:
                        showPromoMenu("GIGA VIDEO+ 50", "5GB video + 1GB open access", "3 days", 50,
                                      "GIGA VIDEO+ 99", "10GB video + 2GB open access", "7 days", 99);
                        break;
                    case 3:
                        showPromoMenu("ALL NET 50", "2GB open access", "3 days", 50,
                                      "ALL NET 99", "6GB open access", "3 days", 99);
                        break;
                    case 4:
                        showPromoMenu("GIGA STORIES 50", "4GB", "3 days", 50,
                                      "GIGA STORIES 99", "9GB", "7 days", 99);
                        break;
                    case 5:
                        showPromoMenu("GIGA GAMES 50", "4GB for gaming", "3 days", 50,
                                      "GIGA GAMES 99", "9GB for gaming", "7 days", 99);
                        break;
                    case 6:
                        askExit();
                        break;
                    default:
                        clearScreen();
                        System.out.println("-----------------------------------------------");
                        System.out.println("Invalid choice! Enter 1-6 only.");
                        System.out.println("-----------------------------------------------\n");
                        break;
                }

            } catch (Exception e) {
                    clearScreen();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Invalid input! Please enter a given number only.");
                    System.out.println("--------------------------------------------------\n");
                sc.nextLine();
            }
        }
    }

    static void enterUssdCode() {

        while (true) {

            System.out.println("==========================");
            System.out.println("      LOAD SERVICES       ");
            System.out.println("==========================\n");

            System.out.print("Enter USSD Code (*123#): ");

            try {
                String code = sc.nextLine().trim();

                if (code.isEmpty()) {
                    clearScreen();
                    System.out.println("--------------------------------------------------");
                    System.out.println("USSD can't be empty!");
                    System.out.println("--------------------------------------------------\n");

                } else if (!code.equals("*123#")) {
                    clearScreen();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Invalid USSD Code!");
                    System.out.println("--------------------------------------------------\n");

                } else {
                    clearScreen();
                    break;
                }

            } catch (Exception e) {
                System.out.println("Input error detected. Please try again."); // para sa input error o kapag na interrupt yung program (ex : Ctrl + C sa cmd)
                sc.nextLine();
            }
        }
    }

    //method applied sample in previous topic
    static void showPromoMenu(String loadName1, String dataAllowance1, String validity1, int price1,
                               String loadName2, String dataAllowance2, String validity2, int price2) {
        
        boolean back = false;
        clearScreen();
        
        while (!back) {
            try {
                System.out.println("\n==========================");
                System.out.println("      SELECT LOAD         ");
                System.out.println("==========================");
                System.out.println("[1] " + loadName1 + " - P" + price1);
                System.out.println("[2] " + loadName2 + " - P" + price2);
                System.out.println("[3] Go Back");
                
                System.out.print("Choice: ");
                int pick = sc.nextInt();
                sc.nextLine();

                // The arguments passed to showDetails() come from the parameters of showPromoMenu()
                // The data types and order of the arguments must match the parameters of showDetails();
                // otherwise, a compile-time error may occur.
                
                switch (pick) {
                    case 1:
                        showDetails(loadName1, dataAllowance1, validity1, price1);
                        back = true;
                        break;
                    case 2:
                        showDetails(loadName2, dataAllowance2, validity2, price2);
                        back = true;
                        break;
                    case 3:
                        clearScreen();
                        back = true;
                        break;
                    default:
                        clearScreen();
                        System.out.println("-----------------------------------------------");
                        System.out.println("Invalid choice! Enter 1-3 only.");
                        System.out.println("-----------------------------------------------\n");
                        break;
                }
                
            } catch (Exception e) {
                clearScreen();
                System.out.println("-----------------------------------------------");
                System.out.println("Invalid input! Please enter a given number only.");
                System.out.println("-----------------------------------------------\n");
                sc.nextLine();
            }
        }
    }

    static void showDetails(String name, String data, String validity, int price) {
        
        boolean back = false;
        clearScreen();
        
        while (!back) {
            
            try {
                System.out.println("\n=======================================");
                System.out.println("Promo    : " + name);
                System.out.println("Data     : " + data);
                System.out.println("Validity : " + validity);
                System.out.println("Price    : P" + price);
                System.out.println("----------------------------------------");
                System.out.println("[1] Buy");
                System.out.println("[2] Cancel");
                
                System.out.print("Choice: ");      
                int confirm = sc.nextInt();
                sc.nextLine();

                switch (confirm) {
                    case 1:
                        if (moneyBalance >= price) {
                            moneyBalance -= price;
                            clearScreen();
                            System.out.println("\nYou're now subscribed to " + name + ". Enjoy!");
                            System.out.printf("Remaining Balance: P%.2f\n", moneyBalance); // copied from my previous excercise good to use if want two decimal to be displayed
                        } else {
                            clearScreen();
                            System.out.println("\nInsufficient balance! Please top up to enjoy the benifits of the promos!");
                        }   back = true;
                        break;
                    case 2:
                        boolean cancelled = askCancel();
                        if (cancelled) {
                            back = true;
                        }   break;
                    default:
                        clearScreen();
                        System.out.println("-----------------------------------------------");
                        System.out.println("Invalid choice! Enter 1-2 only.");
                        System.out.println("-----------------------------------------------\n");
                        break;
                }
                
            } catch (Exception e) {
                clearScreen();
                System.out.println("-----------------------------------------------");
                System.out.println("Invalid input! Please enter a given number only.");
                System.out.println("-----------------------------------------------\n");
                sc.nextLine();
            }
        }
    }

    static boolean askCancel() {
        clearScreen();
        
        try {
            
            System.out.println("\n[1] Yes, Cancel");
            System.out.println("[2] No, Go Back");
            System.out.print("Choice: ");
            int ans = sc.nextInt();
            sc.nextLine();

            switch (ans) {
                case 1:
                    System.out.println("Cancelled.");
                    clearScreen();
                    return true;
                case 2:
                    clearScreen();
                    System.out.println("Going back...");
                    return false;
                default:
                    clearScreen();
                    System.out.println("Invalid! Going back...");
                    return false;
            }
            
        } catch (Exception e) {
            clearScreen();
            System.out.println("-----------------------------------------------");
            System.out.println("Invalid input! Please enter a given number only.");
            System.out.println("-----------------------------------------------\n");
            sc.nextLine();
            return false; // goes back if invalid
        }
    }

    static void askExit() {
        
        try {
            System.out.println("\n[1] Yes, Exit");
            System.out.println("[2] No, Go Back");
            
            System.out.print("Choice: ");
            int ans = sc.nextInt();
            sc.nextLine();

            switch (ans) {
                case 1:
                    System.out.println("\n==========================");
                    System.out.println("   Thank you! Goodbye!    ");
                    System.out.println("==========================");
                    System.exit(0);
                case 2:
                    clearScreen();
                    System.out.println("Going back...");
                    break;
                default:
                    clearScreen();
                    System.out.println("-----------------------------------------------");
                    System.out.println("Invalid! Going back...");
                    System.out.println("-----------------------------------------------\n");
                    break;
            }
            
        } catch (Exception e) {
            clearScreen();
            System.out.println("-----------------------------------------------");
            System.out.println("Invalid input! Please enter a given number only.");
            System.out.println("-----------------------------------------------\n");
            sc.nextLine();
        }
    }

    //from the previous discussion it Clears the console screen using ANSI escape codes
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}