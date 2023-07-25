package com.github.zipcodewilmington.casino.games.CasinoWar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CasinoWar {

    private List<String> deck;
    private int playerScore;
    private int dealerScore;

    public CasinoWar() {
        deck = createShuffledDeck();
        playerScore = 0;
        dealerScore = 0;
    }

    public void playersTurn() {
        // Player's turn
        System.out.println("Press Enter to draw a card.");
        new Scanner(System.in).nextLine();
        String playerCard = drawCard();
        System.out.println("You drew: " + playerCard);
        dealersTurn(playerCard);
    }

    public void dealersTurn(String playerCard) {
        // Dealer's turn
        System.out.println("Press Enter for the dealer to draw a card.");
        new Scanner(System.in).nextLine();
        String dealerCard = drawCard();
        System.out.println("Dealer drew: " + dealerCard + "\n");
        compareCards(playerCard, dealerCard);
    }

    public void compareCards(String playerCard, String dealerCard) {
        // Compare the cards
        int playerValue = getCardValue(playerCard);
        int dealerValue = getCardValue(dealerCard);

        if (playerValue > dealerValue) {
            System.out.println("You win this round!");
            playerScore++;
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins this round!");
            dealerScore++;
        } else {
            System.out.println("It's a tie! Time for war!");
            // War: draw three more cards each
            List<String> playerWarCards = new ArrayList<>();
            List<String> dealerWarCards = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                playerWarCards.add(drawCard());
                dealerWarCards.add(drawCard());
            }
            startWar(playerWarCards, dealerWarCards);
        }
    }

    public void startWar(List<String> playerWarCards, List<String> dealerWarCards) {
        // Get the fourth card for comparison
        String playerFourthCard = playerWarCards.get(0);
        String dealerFourthCard = dealerWarCards.get(0);

        System.out.println("Your fourth card: " + playerFourthCard);
        System.out.println("Dealer's fourth card: " + dealerFourthCard);

        int playerFourthCardValue = getCardValue(playerFourthCard);
        int dealerFourthCardValue = getCardValue(dealerFourthCard);

        if (playerFourthCardValue > dealerFourthCardValue) {
            System.out.println("You win the war!");
            playerScore++;
        } else if (dealerFourthCardValue > playerFourthCardValue) {
            System.out.println("Dealer wins the war!");
            dealerScore++;
        } else {
            System.out.println("It's a tie in the war too! Nobody wins.");
        }
    }

    public void displayScore() {
        // Display the current scores
        System.out.println("Your score: " + playerScore);
        System.out.println("Dealer's score: " + dealerScore);
        // Check if the deck is empty
        if (deck.isEmpty()) {
            System.out.println("The deck is empty. Game over!");
        }
    }

    private List<String> createShuffledDeck() {
        List<String> deck = new ArrayList<>();

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }

        Collections.shuffle(deck);
        return deck;
    }

    private String drawCard() {
        return deck.remove(deck.size() - 1);
    }

    private int getCardValue(String card) {
        String rank = card.split(" ")[0];
        switch (rank) {
            case "Ace":
                return 14;
            case "King":
                return 13;
            case "Queen":
                return 12;
            case "Jack":
                return 11;
            default:
                return Integer.parseInt(rank);
        }
    }



    public void run(){
        while (!this.deck.isEmpty()) {
            this.playersTurn();
            this.displayScore();
        }
    }

    public int getPlayerScore() {
        return playerScore;
    }


    public int getDealerScore() {
        return dealerScore;
    }

    public boolean isGameOver() {
        return false;
    }

}





