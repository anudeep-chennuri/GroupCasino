package com.github.zipcodewilmington.casino.games.BlackJack;


public class BlackJackGame {

    //Declare variables needed for Game class
    private BlackJackDeck blackJackDeck, discarded;

    private BlackJackDealer blackJackDealer;

    public BlackJackPlayer getPlayer() {
        return blackJackPlayer;
    }

    private BlackJackPlayer blackJackPlayer;
    private int wins, losses, pushes;




    public BlackJackGame(){

        //Create a new deck with 52 cards
        blackJackDeck = new BlackJackDeck(true);
        //Create a new empty deck
        discarded = new BlackJackDeck();

        //Create the People
        blackJackDealer = new BlackJackDealer();
        blackJackPlayer = new BlackJackPlayer();


        //Shuffle the deck and start the first round
        blackJackDeck.shuffle();
        startRound();
    }

    private void startRound(){
/*        wins = 0; losses = 0; pushes = 1;
        Card testCard = new Card(Suit.CLUB,Rank.NINE);
        Card testCard2 = new Card(Suit.CLUB, Rank.TEN);*/
        //If this isn't the first time, display the users score and put their cards back in the deck
        if(wins>0 || losses>0 || pushes > 0){

            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: "+ losses+ " Pushes: "+pushes);
            blackJackDealer.getHand().discardHandToDeck(discarded);
            blackJackPlayer.getHand().discardHandToDeck(discarded);
        }

        //Check to make sure the deck has at least 4 cards left
        if(blackJackDeck.cardsLeft() < 4){
            blackJackDeck.reloadDeckFromDiscard(discarded);
        }

        //Give the dealer two cards
        blackJackDealer.getHand().takeCardFromDeck(blackJackDeck);
        blackJackDealer.getHand().takeCardFromDeck(blackJackDeck);

        //Give the player two cards
        blackJackPlayer.getHand().takeCardFromDeck(blackJackDeck);
        blackJackPlayer.getHand().takeCardFromDeck(blackJackDeck);

/*        //TEST
        player.getHand().addCard(testCard);
        player.getHand().addCard(testCard2);*/

        //Show the dealers hand with one card face down
        blackJackDealer.printFirstHand();

        //Show the player's hand
        blackJackPlayer.printHand();

        //Check if dealer has BlackJack to start
        if(blackJackDealer.hasBlackjack()){
            //Show the dealer has BlackJack
            blackJackDealer.printHand();

            //Check if the player also has BlackJack
            if(blackJackPlayer.hasBlackjack()){
                //End the round with a push
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack. You lose.");
                blackJackDealer.printHand();
                losses++;
                startRound();
            }
        }

        //Check if player has blackjack to start
        //If we got to this point, we already know the dealer didn't have blackjack
        if(blackJackPlayer.hasBlackjack()){
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }

        //Let the player decide what to do next
        blackJackPlayer.makeDecision(blackJackDeck, discarded);

        //Check if they busted
        if(blackJackPlayer.getHand().calculatedValue() > 21){
            System.out.println("You have gone over 21.");
            losses ++;
            startRound();
        }

        //Now it's the dealer's turn
        blackJackDealer.printHand();
        while(blackJackDealer.getHand().calculatedValue()<17){
            blackJackDealer.hit(blackJackDeck, discarded);
        }

        //Check who wins
        if(blackJackDealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busts");
            wins++;
        }
        else if(blackJackDealer.getHand().calculatedValue() > blackJackPlayer.getHand().calculatedValue()){
            System.out.println("You lose.");
            losses++;
        }
        else if(blackJackPlayer.getHand().calculatedValue() > blackJackDealer.getHand().calculatedValue()){
            System.out.println("You win.");
            wins++;
        }
        else{
            System.out.println("Push.");
        }

        //Start a new round
        startRound();
    }


public static void pause(){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    public static void runBlackJack(){
        System.out.println("Welcome to BlackJack.");

        BlackJackGame blackjack = new BlackJackGame();
    }


}
