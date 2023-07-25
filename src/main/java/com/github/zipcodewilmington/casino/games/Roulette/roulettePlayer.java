package com.github.zipcodewilmington.casino.games.Roulette;
import com.github.zipcodewilmington.casino.CasinoAccount;


public class roulettePlayer {
    double wallet =0;
    int currentBet=0;


    public roulettePlayer(CasinoAccount person)
    {
        this.wallet = person.getCasinoBalance();
    }


    public static double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }


    public void placeBet(double betAmount, int chosenNumber) {
        if (betAmount <= 0) {
            System.out.println("Invalid bet amount!");
            return;
        }

        if (betAmount > wallet) {
            System.out.println("Insufficient balance!");
            return;
        }

        RouletteNumber betNumber = RouletteNumber.valueOf("N" + chosenNumber);
        rouletteGame.playRound(this, betAmount, betNumber);
    }


}






}
