package com.github.zipcodewilmington.casino.games.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class BlackJackDeck {

    public ArrayList<BlackJackCard> getDeck() {
        return deck;
    }

    //An arraylist to hold the deck of Cards
    private ArrayList<BlackJackCard> deck;



    public BlackJackDeck(){
        deck = new ArrayList<BlackJackCard>();
    }


    public BlackJackDeck(BlackJackDeck c){
        Collections.copy(this.deck, c.getCards());
    }


    public BlackJackDeck(boolean makeDeck){
        deck = new ArrayList<BlackJackCard>();
        if(makeDeck){
            //Go through all the suits
            for(BlackJackSuit blackJackSuit : BlackJackSuit.values()){
                //Go through all the ranks
                for(BlackJackRankEnum blackJackRankEnum : BlackJackRankEnum.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new BlackJackCard(blackJackSuit, blackJackRankEnum));
                }
            }
        }
    }


    public void addCard(BlackJackCard blackJackCard){
        deck.add(blackJackCard);
    }


    public void addCards(ArrayList<BlackJackCard> blackJackCards){
        deck.addAll(blackJackCards);
    }

    public String toString(){
        //A string to hold everything we're going to return
        String output = "";

        for(BlackJackCard blackJackCard : deck){
            output += blackJackCard;
            output += "\n";
        }
        return output;
    }

    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }


    public BlackJackCard takeCard(){

            //Take a copy of the first card from the deck
            BlackJackCard blackJackCardToTake = new BlackJackCard(deck.get(0));
            //Remove the card from the deck
            deck.remove(0);
            //Give the card back
            return blackJackCardToTake;

    }

    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }


    public int cardsLeft(){
        return deck.size();
    }


    public ArrayList<BlackJackCard> getCards() {
        return deck;
    }


    public void emptyDeck(){
        deck.clear();
    }

    public void reloadDeckFromDiscard(BlackJackDeck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }


}
