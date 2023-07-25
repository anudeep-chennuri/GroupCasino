package com.github.zipcodewilmington.casino.games.BlackJack;

import java.util.Scanner;


public class BlackJackPlayer extends BlackJackPerson {

    Scanner input = new Scanner(System.in);

    //Create a new Player
    public BlackJackPlayer() {
        super.setName("Player");

    }

    //Allow the player to make decisions
    public void makeDecision(BlackJackDeck blackJackDeck, BlackJackDeck discard) {

        int  decision = 0;
        boolean getNum = true;

        while(getNum){

            try{
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Invalid");
                input.next();
            }
            //we don't close the scanner, because we will need it later.
        }

        if (decision == 1) {
            this.hit(blackJackDeck, discard);
            //return if they have blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                this.makeDecision(blackJackDeck, discard);
            }

        } else {
            System.out.println("You stand.");
        }


    }


}
