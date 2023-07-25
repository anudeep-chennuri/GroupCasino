package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.BlackJack.*;
import com.github.zipcodewilmington.casino.games.DiceRoll;
import com.github.zipcodewilmington.casino.games.StreetCraps;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class BlackJackTest {



    @Test
    public void testBlackJackSetter() {
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer();
        blackJackPlayer.setName("Bob");


        String actual = blackJackPlayer.getName();
        String expected = "Bob";

        Assert.assertEquals(actual, expected);
    }


    @Test
    public void testBlackJackGetter()
    {
       BlackJackPlayer blackJackPlayer = new BlackJackPlayer();
       String expected = blackJackPlayer.getName();
        String actual = "Player";
        Assert.assertEquals(actual,expected);
    }

    @Test
            public void testJack()
    {
    BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.JACK);
    int actual = blackjackcard.getValue();
    int expected = 10;
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void testKing()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.KING);
        int actual = blackjackcard.getValue();
        int expected = 10;
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void testQueen()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.QUEEN);
        int actual = blackjackcard.getValue();
        int expected = 10;
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void testAce()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.ACE);
        int actual = blackjackcard.getValue();
        int expected = 11;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test10()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.TEN);
        int actual = blackjackcard.getValue();
        int expected = 10;
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void test9()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.NINE);
        int actual = blackjackcard.getValue();
        int expected = 9;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testClub()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.NINE);
        String actual = String.valueOf(blackjackcard.getSuit());
        String expected = "Clubs";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testspade()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.SPADE,BlackJackRankEnum.NINE);
        String actual = String.valueOf(blackjackcard.getSuit());
        String expected = "Spades";
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void testDiamonds()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.DIAMOND,BlackJackRankEnum.NINE);
        String actual = String.valueOf(blackjackcard.getSuit());
        String expected = "Diamonds";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testHeart()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.HEART,BlackJackRankEnum.NINE);
        String actual = String.valueOf(blackjackcard.getSuit());
        String expected = "Hearts";
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void testempyDeck()
    {
        BlackJackDeck blackJackDeck = new BlackJackDeck();
        blackJackDeck.emptyDeck();
        int actual = blackJackDeck.getDeck().size();
        int expected = 0;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testGetName()
    {
        BlackJackDealer blackJackDealer = new BlackJackDealer();
        String actual = blackJackDealer.getName();
        String expected = "Dealer";
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void test99()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.NINE);
        int actual = blackjackcard.getValue();
        int expected = 9;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test8()
    {
        BlackJackCard blackjackcard = new BlackJackCard(BlackJackSuit.CLUB,BlackJackRankEnum.EIGHT);
        int actual = blackjackcard.getValue();
        int expected = 8;
        Assert.assertEquals(actual,expected);
    }







}

