package com.github.zipcodewilmington.casino.games.BlackJack;


public abstract class BlackJackPerson {

    private BlackJackHand blackJackHand;
    private String name;

    public BlackJackPerson(){
        this.blackJackHand = new BlackJackHand();
        this.name = "";
    }


    //Setters and Getters
    public BlackJackHand getHand(){
        return this.blackJackHand;
    }
    public void setHand(BlackJackHand blackJackHand){
        this.blackJackHand = blackJackHand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }



    public void printHand(){
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.blackJackHand + " Valued at: " + this.blackJackHand.calculatedValue());
    }


    public void hit(BlackJackDeck blackJackDeck, BlackJackDeck discard){

        //If there's no cards left in the deck
        if (!blackJackDeck.hasCards()) {
            blackJackDeck.reloadDeckFromDiscard(discard);
        }
        this.blackJackHand.takeCardFromDeck(blackJackDeck);
        System.out.println(this.name + " gets a card");
        this.printHand();
        BlackJackGame.pause();

    }

    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }



}
