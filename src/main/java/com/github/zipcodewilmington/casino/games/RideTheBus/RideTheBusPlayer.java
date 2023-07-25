package com.github.zipcodewilmington.casino.games.RideTheBus;

import com.github.zipcodewilmington.casino.CasinoAccount;

public class RideTheBusPlayer {


    double wallet =0;
    int currentBet=0;
    public RideTheBusPlayer(CasinoAccount person)
    {
        this.wallet = person.getCasinoBalance();
    }


    public double getWallet() {
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

}
