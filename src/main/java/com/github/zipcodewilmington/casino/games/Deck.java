package com.github.zipcodewilmington.casino.games;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    String[] colors = {"Red", "Black"};
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    Random rand = new Random();
    public ArrayList<Card> getDeck() {
        return deck;
    }

    ArrayList<Card> deck = new ArrayList<Card>();

    public Deck()
    {
        for (String suit : suits)
        {
            for (int i = 0; i < faces.length; i++)
            {
                String color = (suit.equals("Hearts") || suit.equals("Diamonds")) ? "Red" : "Black";
                Card card = new Card(faces[i], values[i], color, suit);
                deck.add(card);
            }

        }
    }

    public Card GetRandomCard()
    {
        int i = rand.nextInt(deck.size());
        return deck.get(i);
    }


}
