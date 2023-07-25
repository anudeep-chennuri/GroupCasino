package com.github.zipcodewilmington.casino.games.BlackJack;

public class BlackJackCard implements Comparable<BlackJackCard>{

     private BlackJackSuit blackJackSuit;
     private BlackJackRankEnum blackJackRankEnum;


    public BlackJackCard(BlackJackSuit blackJackSuit, BlackJackRankEnum blackJackRankEnum){
        this.blackJackSuit = blackJackSuit;
        this.blackJackRankEnum = blackJackRankEnum;
    }


    public BlackJackCard(BlackJackCard blackJackCard){
        this.blackJackSuit = blackJackCard.getSuit();
        this.blackJackRankEnum = blackJackCard.getRank();
    }


    public int getValue(){
        return blackJackRankEnum.rankValue;
    }


    public BlackJackSuit getSuit(){
        return blackJackSuit;
    }

    public BlackJackRankEnum getRank(){
        return blackJackRankEnum;
    }


    public String toString(){
        return ("["+ blackJackRankEnum +" of "+ blackJackSuit + "] ("+this.getValue()+")");

    }


    @Override
    public int compareTo(BlackJackCard c) {
        //if this card is greater than the other card
        if(this.getValue() > c.getValue()){
            return 1;
        }
        else if(this.getValue() < c.getValue()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
