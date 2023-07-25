package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.CasinoWar.CasinoWar;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

public class CasinoWarTest {

    private CasinoWar casinoWar;

    @Before
    public void setUp() {
        casinoWar = new CasinoWar();
    }

    @Test
    public void testPlayersTurn() {
        // Player's turn test
        //casinoWar.playersTurn();

    }

    @Test
    public void testDealersTurn() {
        // Dealer's turn test
        //casinoWar.dealersTurn();
    }

    @Test
    public void testCompareCards_PlayerWins() {
        // Player wins a round
        String playerCard = "8 of Hearts";
        String dealerCard = "4 of Spades";
        casinoWar.compareCards(playerCard, dealerCard);
        assertEquals(1, casinoWar.getPlayerScore());
    }

    @Test
    public void testCompareCards_DealerWins() {
        // Dealer wins a round
        String playerCard = "2 of Diamonds";
        String dealerCard = "Queen of Hearts";
        casinoWar.compareCards(playerCard, dealerCard);
        assertEquals(1, casinoWar.getDealerScore());
    }

    @Test
    public void testCompareCards_War() {
        // A war occurs
        String playerCard = "King of Clubs";
        String dealerCard = "King of Spades";
        casinoWar.compareCards(playerCard, dealerCard);
    }

    @Test
    public void testStartWar_PlayerWins() {
        // Player wins the war
        casinoWar.startWar(Collections.singletonList("5 of Clubs"), Collections.singletonList("4 of Hearts"));
        assertEquals(1, casinoWar.getPlayerScore());
    }



    @Test
    public void testStartWar_DealerWins() {
        // Dealer wins the war
        casinoWar.startWar(Collections.singletonList("10 of Spades"), Collections.singletonList("Queen of Diamonds"));
        assertEquals(1, casinoWar.getDealerScore());

    }

    @Test
    public void testStartWar_Tie() {
        // A tie occurs during the war
        casinoWar.startWar(Collections.singletonList("Ace of Hearts"), Collections.singletonList("Ace of Diamonds"));
        // The test should pass if the war results in a tie and no score changes.
        assertEquals(0, casinoWar.getPlayerScore());
        assertEquals(0, casinoWar.getDealerScore());
    }

    @Test
    public void testDisplayScore() {
        // Test displaying scores
        casinoWar.displayScore();

    }
}
