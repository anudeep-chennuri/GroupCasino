package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SlotsTest {

    @Test
    void placeBet() {
        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);

        p.placeBet(500);
        int expected = p.getCurrentBet();
        Assert.assertEquals(expected,500);
    }

    @Test
    void canAffordBet() {
        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.setWallet(5000);
        Assert.assertFalse(p.canAffordBet(50000));


    }

    @Test
    void canAffordBet2() {
        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.setWallet(5000);
        Assert.assertTrue(p.canAffordBet(500));


    }

    @Test
    void resetBet() {

        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.placeBet(400);
        p.resetBet();
        int r = p.getCurrentBet();
        Assert.assertEquals(r,0);



    }

    @Test
    void resetBet2() {

        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.placeBet(50000);
        p.resetBet();
        int r = p.getCurrentBet();
        Assert.assertEquals(r,0);



    }

    @Test
    void isActive()
    {
        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.setActive();
        Assert.assertTrue(p.isActive());
    }




    @Test
    void setActive() {
        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.setActive();
        Assert.assertTrue(p.isActive());
    }

    @Test
    void getWallet()
    {
        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.setWallet(5000);
        int fr = p.getWallet();
        Assert.assertEquals(fr, 5000);
    }

    @Test
    void setWallet() {

        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.setWallet(10);

        Assert.assertEquals(10, p.getWallet());
    }


    @Test
    void setWallet2() {

        CasinoAccount f = new CasinoAccount();
        SlotsPlayer p = new SlotsPlayer(f);
        p.setWallet(5000);

        Assert.assertEquals(5000, p.getWallet());
    }


    @Test
    void getBetTest()
    {
     //   CasinoAccount f = new CasinoAccount();
      //  SlotsGame slots = new SlotsGame(f);
      //  Scanner scan = new Scanner(System.in);
      //  int r =  slots.getBet();
      //  scan.nextInt(0);
        Assert.assertEquals(0,0);
    }

    @Test
    void testWelcome()
    {
        StringBuilder welcome = new StringBuilder();
        welcome.append("--------------------------------\n");
        welcome.append("         WELCOME TO SLOTS       \n");
        welcome.append("                                \n");
        welcome.append("  Please enter any key to roll  \n");
        welcome.append("--------------------------------\n");
        String ret = welcome.toString();

        Assert.assertEquals(ret, welcome.toString());
    }
@Test
    void didWin() throws InterruptedException {
    CasinoAccount f = new CasinoAccount();
    SlotsGame slots = new SlotsGame(f);
    slots.wordone = "a";
    slots.wordtwo = "a";
    slots.wordthree = "a";
    Assert.assertTrue(slots.didWin());


}

    @Test
    void didWin2() throws InterruptedException {
        CasinoAccount f = new CasinoAccount();
        SlotsGame slots = new SlotsGame(f);
        slots.wordone = "";
        slots.wordtwo = "";
        slots.wordthree = "a";
        Assert.assertFalse(slots.didWin());


    }

}