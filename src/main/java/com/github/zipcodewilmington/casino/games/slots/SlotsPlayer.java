package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer {

    public int getCurrentBet() {
        return CurrentBet;
    }

    int CurrentBet = 0;
    int wallet;
    boolean active = true;

    public SlotsPlayer(CasinoAccount f) {
        this.wallet = (int) f.getCasinoBalance();
    }

    public void placeBet(int bet) {
        CurrentBet = bet;

    }


    public boolean canAffordBet(int bet) {
        if (bet > this.getWallet()) {
            return false;
        } else return true;
    }


    public void resetBet()
    {
        CurrentBet = 0;
    }

    public boolean isActive() {
        return true;
    }

    public void setActive()
    {
        active = true;
    }

    public void setnotActive()
    {
        active = false;
    }

        public int getWallet()

        {
        return wallet;
         }

    public void setWallet(int wallet)
        {
        this.wallet = wallet;
        }
}
