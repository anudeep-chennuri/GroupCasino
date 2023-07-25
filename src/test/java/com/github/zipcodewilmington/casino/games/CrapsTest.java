package com.github.zipcodewilmington.casino.games;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.DiceRoll;
import com.github.zipcodewilmington.casino.games.StreetCraps;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {
    @Test
    public void rollDice(){
        DiceRoll.GetDiceRoll(1);
        DiceRoll.runSimulation();


    }

    @Test
    public void checkWin(){
        //given
        boolean expected=true;
        //when
        boolean actual=StreetCraps.checkwin(7);
        //then
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void checkWin2(){
        //given
        boolean expected=false;
        //when
        boolean actual=StreetCraps.checkwin(2);
        //then
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void checkLoss(){
        //given
        boolean expected=true;
        //when
        boolean actual=StreetCraps.checkLoss(2);
        //then
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void checkLoss2(){
        //given
        boolean expected=false;
        //when
        boolean actual=StreetCraps.checkLoss(7);
        //then
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void checkBet(){
        CasinoAccount bob=new CasinoAccount();
        bob.setCasinoBalance(90);
        new StreetCraps(bob);
        //given
        boolean expected=false;
        //when
        boolean actual=StreetCraps.checkbet(100);
        //then
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void checkBet2(){
        CasinoAccount bob=new CasinoAccount();
        bob.setCasinoBalance(110);
        new StreetCraps(bob);
        //given
        boolean expected=true;
        //when
        boolean actual=StreetCraps.checkbet(100);
        //then
        Assert.assertEquals(actual,expected);
    }

}
