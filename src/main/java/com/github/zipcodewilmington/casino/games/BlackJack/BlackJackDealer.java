package com.github.zipcodewilmington.casino.games.BlackJack;

public class BlackJackDealer extends BlackJackPerson {


    public BlackJackDealer(){

        //Name the dealer "Dealer"
        super.setName("Dealer");

    }


    public void printFirstHand(){
        System.out.println("The dealer's hand looks like this:");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down.");
    }



}
