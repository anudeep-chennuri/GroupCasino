package com.github.zipcodewilmington.casino.games.RideTheBus;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.Card;
import com.github.zipcodewilmington.casino.games.RideTheBus.RideTheBusGame;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RideTheBusGameTest {

    @Test
    void testGetWallet() {
        CasinoAccount s= new CasinoAccount(null,null,50.0);
        RideTheBusPlayer player = new RideTheBusPlayer(s);
        player.setWallet(10000.0);
        double f = player.getWallet();
        Assert.assertEquals(10000.0, f, 0);
    }


    @Test
    void testSetWallet() {
        CasinoAccount s = new CasinoAccount(null,null,50.0);

        RideTheBusPlayer player = new RideTheBusPlayer(s);
        player.setWallet(50000.0);
        double f = player.getWallet();
        Assert.assertEquals(50000.0, f, 0);
    }


    @Test
    void testGetCurrentBet() {
        CasinoAccount s = new CasinoAccount(null,null,50.0);

        RideTheBusPlayer player = new RideTheBusPlayer(s);
        player.currentBet = 50;
        double f = player.getCurrentBet();
        Assert.assertEquals(50, f, 0);
    }


    @Test
    void tesetSetCurrentBet() {
        CasinoAccount s = new CasinoAccount(null,null,50.0);

        RideTheBusPlayer player = new RideTheBusPlayer(s);
        player.setCurrentBet(50);
        int f = player.getCurrentBet();
        Assert.assertEquals(f, 50);
    }


    @Test
    void testHop() {
        CasinoAccount f = new CasinoAccount(null,null,50.0);

        RideTheBusGame ride = new RideTheBusGame(f);
        ride.hop();
        int index = ride.index0;
        Assert.assertEquals(1, index);
    }

    @Test
    void testBack()
    {
        CasinoAccount f = new CasinoAccount(null,null,50.0);

        RideTheBusGame ride = new RideTheBusGame(f);
    ride.index0 = 3;
    ride.back();
    Assert.assertEquals(ride.index0,2);
    }

    @Test
    void testDeal()
    {
        CasinoAccount f = new CasinoAccount(null,null,50.0);

        RideTheBusGame ride = new RideTheBusGame(f);
        ride.deal();
        Assert.assertTrue(ride.table[0]!=null);
    }

    @Test
    void testcheckHiLow()
            //This test needs to be altered because it is relying on random values.
    {
        CasinoAccount s = new CasinoAccount(null,null,50.0);

        RideTheBusGame rider = new RideTheBusGame(s);
        rider.deal();
       boolean f= rider.checkHiLow("higher");
        Assert.assertTrue(f);
    }

    @Test
    void testReact()
    {
        CasinoAccount f = new CasinoAccount(null,null,50.0);

        RideTheBusGame rider = new RideTheBusGame(f);
        rider.react(true);
        Assert.assertEquals(rider.getIndex0(),1);
    }



    @Test
    void testgetIndex()
    {
        CasinoAccount s = new CasinoAccount(null,null,50.0);

        RideTheBusGame rider = new RideTheBusGame(s);
        int f =rider.getIndex0();
        Assert.assertEquals(f,0);
    }



}




    // Add more test cases using @Test annotations as needed

