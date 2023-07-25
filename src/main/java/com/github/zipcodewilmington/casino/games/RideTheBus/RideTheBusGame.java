package com.github.zipcodewilmington.casino.games.RideTheBus;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Card;
import com.github.zipcodewilmington.casino.games.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;

public class RideTheBusGame implements GameInterface {
    public RideTheBusPlayer getRider() {
        return rider;
    }
    private IOConsole colorConsoleRed = new IOConsole(AnsiColor.RED);
    IOConsole colorConsoleGreen = new IOConsole(AnsiColor.GREEN);
    RideTheBusPlayer rider;
    CasinoAccount retr;
    Deck deckobj = new Deck();
    Card[] table = new Card[4];
    int index0;
    Scanner scan = new Scanner(System.in);

public RideTheBusGame(CasinoAccount person)
{
    retr = person;
}


    public void hop() {
        index0 = index0 + 1;



    }

    public void back() {
        index0 = index0 - 1;

    }

    public void deal() {

        for (int i = 0; i < 4; i++) {
            table[i] = deckobj.GetRandomCard();
        }
    }


    public void HalfBet() {
    }

    public String getValue() {
        return table[index0].toString();
    }


    public void reset() {
    }

    public void exitGame() {
    }

    public void start() {

        rider = new RideTheBusPlayer(retr);
        WelcomeMessage();
        while (!checkbet(getBet()))
        {}
        deal();
        while (index0 < 4)
        {
            gameflow();
            status();
        }
        win();
    }

    public void win() {
        if (rider.getCurrentBet() == 0) {
            System.out.println("Congratulations on making it to the end of the bus");
            System.out.println("Unfortunately, you have lost your entire bet.");
            System.out.println("Better luck next time!");
        }
        else
        {
          System.out.println("Congratulations on making it to the end of the bus!");
          int winnings = (int) (rider.getCurrentBet()*2);
          System.out.println("Your returns are: " + winnings);
          rider.setWallet(rider.getWallet()+winnings);
          retr.setCasinoBalance(rider.getWallet());
        }
    }

    public String guessHiLow() {
        System.out.println("Do you believe the next card turned will be higher or lower?");
        String ret = scan.nextLine().toLowerCase();
        if(ret.equals("higher") || ret.equals("lower"))
        {
            return ret;
        }
        else
        {
            System.out.println("Please enter higher or lower as a word.");
            return guessHiLow();
        }
    }

    public int getBet()
    {
      System.out.println("How much would you like to bet in this game?");
      System.out.println("Your account has: " + rider.getWallet());

          int b= scan.nextInt();

      scan.nextLine();
      return b;
    }



    public boolean checkbet(int bet)
    {
        if(bet>rider.getWallet())
        {
            System.out.println("You do not have enough funds in your wallet for the bet you just made.");
            return false;
        }
        rider.setCurrentBet(bet);
        rider.setWallet(rider.wallet-bet);
        retr.setCasinoBalance(retr.getCasinoBalance()-bet);
        System.out.println("You bet has been set.");
        return true;
    }

    public boolean checkHiLow(String guess) {
        if (guess.equals("higher")) {
            int current = table[index0].value;
            table[index0] = deckobj.GetRandomCard();
            System.out.println("The next card turned over was " + table[index0]);
            int NewCard = table[index0].value;
            return current < NewCard;
        } else if (guess.equals("lower"))
        {
            int current = table[index0].value;
            table[index0] = deckobj.GetRandomCard();
            System.out.println("The next card turned over was " + table[index0]);
            int NewCard = table[index0].value;
            return current > NewCard;
        }
        return true;
    }
    public void react(boolean logic) {
        if (logic == true)
        {
            colorConsoleGreen.println("Your guess was right, moving up!");
            hop();
        }
        else if (logic == false)
        {
            if (getIndex0() != 0)
            {
                colorConsoleRed.println("Your guess was wrong, moving back!");
                System.out.println("Your bet has been decreased by 15%");
                rider.setCurrentBet((int) (rider.getCurrentBet()-rider.getCurrentBet()*.15));
                back();
            }
            else if( getIndex0()==0) {
                colorConsoleRed.println("Your guess was wrong but you're still at spot one.");
                System.out.println("Your bet has been decreased by 15%");
                rider.setCurrentBet((int) (rider.getCurrentBet() - rider.getCurrentBet() * .15));
            }
        }
    }

    public boolean checkColor(String guess) {
        if (guess.equals("red")) {

            table[index0] = deckobj.GetRandomCard();
            System.out.println("The card turned over was " + table[index0]);
            String NewColor = table[index0].color.toLowerCase();
            return guess.equals(NewColor);
        } else if (guess.equals("black"))
        {
            table[index0] = deckobj.GetRandomCard();
            System.out.println("The card turned over was " + table[index0]);
            String NewColor = table[index0].color.toLowerCase();
            return guess.equals(NewColor);
        }
       return false;
        }


    public boolean checkSuit(String guess) {
        table[index0] = deckobj.GetRandomCard();
        System.out.println("The card turned over was " + table[index0]);
        String NewSuit = table[index0].suit.toLowerCase();
        return guess.equals(NewSuit);
    }



    public void gameflow() {
        if (index0 == 0 || index0 == 1) {
            reveal();
            react(checkHiLow(guessHiLow()));
        } else if (index0 == 2)
        {
            react(checkColor(guessColor()));
        }
        else if(index0==3) {
            react(checkSuit(guessSuit()));
        }
    }

    public String guessColor() {
        System.out.println("Please input the color of the next card flipped over.");
        String ret = scan.nextLine().toLowerCase();
        if(ret.equals("red")||ret.equals("black"))
        {
            return ret;
        }
        else
        {
            System.out.println("Please enter the color as a word.");
            return guessColor();
        }
    }

    public String guessSuit() {
        System.out.println("Please input the suit of the next card flipped over.");
        String ret = scan.nextLine().toLowerCase();
        if(ret.equals("spades")||ret.equals("clubs")||ret.equals("diamonds")||ret.equals("hearts"))
        {
            return ret;
        }
        else
        {
            System.out.println("Please enter the suit as a word.");
            return guessSuit();
        }

    }

    public void reveal() {
        System.out.println( "The current value of the card you are guessing is " + getValue());
    }

    public void WelcomeMessage() {

        System.out.println( "Welcome to Ride The Bus!");

    }
    public int getIndex0() {
        return index0;
    }
    public void status()
    {
        if(index0<=3)
    System.out.println("You are currently at card position " + (index0+1) + " with a bet balance of " + rider.getCurrentBet());
    }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }
}
