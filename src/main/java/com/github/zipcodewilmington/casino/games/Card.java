package com.github.zipcodewilmington.casino.games;

public class Card {
    String face;
   public int value;
   public String color;
  public  String suit;

    public Card(String face, int value, String Color, String suit)
    {
        this.face = face;
        this.value = value;
        this.color = Color;
        this.suit = suit;
    }


    @Override
    public String toString() {
        String ret ="";
        if(value==11)
        {
            ret ="Jack of "+ suit;
        }
        else if (value==12)
        {
            ret ="Queen of "+ suit;
        }
        else if(value==13)
        {
            ret ="King of "+suit;
        }
        else if(value==14)
        {
            ret = "Ace of "+suit;
        }
        else
        {
            ret = value + " of " + suit;
        }
        return ret;

    }
}
