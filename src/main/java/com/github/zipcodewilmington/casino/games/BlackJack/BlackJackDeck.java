package com.github.zipcodewilmington.casino.games.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A deck of cards
 */
public class BlackJackDeck {

    //An arraylist to hold the deck of Cards
    private ArrayList<BlackJackCard> deck;


    /**
     * Create an empty deck of cards
     */
    public BlackJackDeck(){
        deck = new ArrayList<BlackJackCard>();
    }

    /**
     * Copy Constructor
     * @param c deck being copied
     */
    public BlackJackDeck(BlackJackDeck c){
        Collections.copy(this.deck, c.getCards());
    }

    /**
     * Create a standard deck of cards
     * @param makeDeck makes a standard deck of cards if true
     */
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

    /**
     *
     * @param blackJackCard The card being added to this deck
     */
    public void addCard(BlackJackCard blackJackCard){
        deck.add(blackJackCard);
    }

    /**
     *
     * @param blackJackCards an arraylist of cards to be added to this deck
     */
    public void addCards(ArrayList<BlackJackCard> blackJackCards){
        deck.addAll(blackJackCards);
    }

    /**
     *
     * @return Every value of the deck as a String with line separators
     */
    public String toString(){
        //A string to hold everything we're going to return
        String output = "";

        for(BlackJackCard blackJackCard : deck){
            output += blackJackCard;
            output += "\n";
        }
        return output;
    }

    /**
     * Shuffle the deck of Cards at random
     */
    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

    /**
     *
     * @return The card taken from the deck
     */
    public BlackJackCard takeCard(){

            //Take a copy of the first card from the deck
            BlackJackCard blackJackCardToTake = new BlackJackCard(deck.get(0));
            //Remove the card from the deck
            deck.remove(0);
            //Give the card back
            return blackJackCardToTake;

    }

    /**
     *
     * @return true if the deck still has cards left
     */
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * @return The number of cards left in the deck
     */
    public int cardsLeft(){
        return deck.size();
    }

    /**
     *
     * @return the arraylist containing all the cards in this deck
     */
    public ArrayList<BlackJackCard> getCards() {
        return deck;
    }

    /**
     * Empties out this Deck
     */
    public void emptyDeck(){
        deck.clear();
    }


    /**
     * Take all the cards from a discarded deck and place them in this deck, shuffled.
     * Clear the old deck
     * @param discard - the deck we're getting the cards from
     */
    public void reloadDeckFromDiscard(BlackJackDeck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }


}
