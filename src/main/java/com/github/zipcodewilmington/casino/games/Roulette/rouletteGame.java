package com.github.zipcodewilmington.casino.games.Roulette;
import com.github.zipcodewilmington.casino.CasinoAccount;

import java.util.Random;
import java.util.Scanner;


public class rouletteGame{
    private RouletteNumber[] rouletteNumbers = RouletteNumber.values();
    private Random random = new Random();
    static Scanner scan = new Scanner(System.in);


    public void run() {
       WelcomeMessage();
       pushToStart();
       rouletteMenu();
    }

    public String WelcomeMessage()
    {
        StringBuilder welcome = new StringBuilder();
        welcome.append("--------------------------------\n");
        welcome.append("|      WELCOME TO ROULETTE     |\n");
        welcome.append("|                              |\n");
        welcome.append("| Please enter any key to roll |\n");
        welcome.append("--------------------------------\n");
        System.out.println(welcome);
        return welcome.toString();
    }

    public void pushToStart(){
        {
            scan.nextLine();
        }
    }

    public void rouletteMenu(){
        while (true) {
            System.out.println("\n Main Menu: Choose Number For Bet \n");
            System.out.println(" 1. Bet on Color: Green/Red/Black");
            System.out.println("2. Bet on Odd or Even");
            System.out.println("3. Leave Table");
            System.out.println("Please make a selection [1-3]: ");
            System.out.println("Your Current Balance is " + roulettePlayer.getWallet());

            Integer userChoice = scan.nextInt();

            switch(userChoice){
                case 1:
                    System.out.print("Choose a color to bet on (Red/Black/Green): ");
                    String chosenColor = scan.next();
                    try {
                        RouletteBoard betColor = RouletteBoard.valueOf(chosenColor.toUpperCase());
                        playRound(player, betAmount, betColor);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid color! Please choose Red, Black, or Green.");
                    }
                    break;
                case 2:
                    System.out.print("Choose to bet on (Odd/Even): ");
                    String chooseOddEven = scan.next();
                    try {
                        RouletteBoard betNumber = RouletteBoard.valueOf(chooseOddEven.toUpperCase());
                        playRound(player, betAmount, betNumber);
                    } catch (IllegalArgumentException e) {
                         System.out.println("Invalid option! Please choose Odd/Even");
                    }
                    break;
                case 3:
                    System.out.println("Back to Menu");
                    scan.close();
                    break;
                default:
                     System.out.println("Invalid betting option!");
            }
        }
        scan.close();

        private void playRound(roulettePlayer player, double betAmount, RouletteBet bet){


         return null;
        }










}





}
