package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;
import java.util.Scanner;
public class SlotsGame  {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    private IOConsole colorConsoleRed = new IOConsole(AnsiColor.RED);
    private IOConsole colorConsoleBlue = new IOConsole(AnsiColor.BLUE);
    private IOConsole colorConsoleGreen = new IOConsole(AnsiColor.GREEN);

    String wordone="";
    String wordtwo="";
    String wordthree="";

    boolean hit = false;
    //String[]Words = {"APPLE","APPLE","APPLE","APPLE","APPLE","APPLE","APPLE","APPLE","APPLE","APPLE"};
    String[]Words = {"APPLE","PEAR","PEACH","ORANGE","WATERMELON","BLACKBERRY","STRAWBERRY","KIWI","RAZBERRY","BLUEBERRY"};

    SlotsPlayer slotsPlayer;

    public CasinoAccount retr;





    public SlotsGame(CasinoAccount ret2)
    {
        retr = ret2;
       slotsPlayer =  new SlotsPlayer(retr);
    }







    public void run() throws InterruptedException {

        while(!checkbet(getBet()));
        WelcomeMessage();
        pushToStart();
        roll();
        AdjustBank(didWin());
        playagain();
        }



        public void playagain() throws InterruptedException {
            System.out.println("Would you like to play again?");
            System.out.println("Please type yes or no.");
            String ret = scan.nextLine().toLowerCase();
            if(ret.equals("yes")||ret.equals("y"))
            {
                slotsPlayer.setWallet(slotsPlayer.CurrentBet+slotsPlayer.getWallet());
                int f = slotsPlayer.CurrentBet;
                retr.setCasinoBalance(retr.getCasinoBalance()+f);

                slotsPlayer.resetBet();
                run();
            }
           else if(ret.equals("no")||ret.equals("n"))
            {

                int f = slotsPlayer.CurrentBet;
                retr.setCasinoBalance(retr.getCasinoBalance()+f);
            }
        }





    public void roll() throws InterruptedException {
        for (int i = 0; i < 10; i++)
        {
            SlotRoll();
        }
    }

    public int getBet()
    {
        System.out.println("How much would you like to bet inside slots?");
        System.out.println("Your account has: " + slotsPlayer.getWallet());
        int b= scan.nextInt();
        scan.nextLine();
        return b;
    }

    public boolean checkbet(int bet)
    {
        if(bet>slotsPlayer.getWallet())
        {
            System.out.println("You do not have enough funds in your wallet for the bet you just made.");
            System.out.println("Your account has: " + slotsPlayer.getWallet());
            return false;
        }
        slotsPlayer.placeBet(bet);
        retr.setCasinoBalance(retr.getCasinoBalance()-bet);
        slotsPlayer.setWallet(slotsPlayer.wallet-bet);
        System.out.println("You bet has been set.");
        return true;
    }
    public void spacer()
    {
        for(int i =0;i<9;i++)
        {
            System.out.println("");
        }
    }

    public String WelcomeMessage()
    {
        StringBuilder welcome = new StringBuilder();
        welcome.append("--------------------------------\n");
        welcome.append("         WELCOME TO SLOTS       \n");
        welcome.append("                                \n");
        welcome.append("  Please enter any key to roll  \n");
        welcome.append("--------------------------------\n");
        System.out.println(welcome.toString());
        return welcome.toString();
    }

    public void pushToStart()
    {
        scan.nextLine();
    }



    public void assignWords()
    {
        wordone = "";
        wordtwo = "";
        wordthree= "";
        String ret="";
        String ret2="";
        String ret3="";
        for(int i=0;i<3;i++)
        {
            int index = rand.nextInt(10);

            if(i==0)
            {
                wordone=Words[index];
                ret="      " + Words[index];
            }
            else if(i==1)
            {
                wordtwo=Words[index];
                ret2="      " + Words[index];
            }
            else
            {
                wordthree=Words[index];
                ret3="      " + Words[index];
            }

        }
        PrintWords(ret, ret2, ret3);
    }

    public void PrintWords(String ret, String ret2,String  ret3)
    {
        int i = rand.nextInt(10);
        int f = rand.nextInt(10);
        int g = rand.nextInt(10);
        if(i==0 || i==3 || i==6 || i==9)
        {
            colorConsoleRed.print(ret);
        }
        else if(i==1 || i==4 || i==7)
        {
            colorConsoleBlue.print(ret);
        }
        else if(i==2 || i==5 || i==8)
        {
            colorConsoleGreen.print(ret);
        }

        if(f==0 || f==3 || f==6 || f==9)
        {
            colorConsoleBlue.print(ret2);
        }
        else if(f==1 || f==4 || f==7)
        {
            colorConsoleGreen.print(ret2);
        }
        else if(f==2 || f==5 || f==8)
        {
            colorConsoleRed.print(ret2);
        }

        if(g==0 || g==3 || g==6 || g==9)
        {
            colorConsoleGreen.print(ret3);
        }
        else if(g==1 || g==4 || g==7)
        {
            colorConsoleRed.print(ret3);
        }
        else if(g==2 || g==5 || g==8)
        {
            colorConsoleBlue.print(ret3);
        }
    }
    public void AdjustBank(boolean didWin)
    {
        if(didWin==true)
        {
            slotsPlayer.placeBet(slotsPlayer.CurrentBet*3);
            System.out.println("Congratulations! You hit big!!!!");
            System.out.println("You have tripled your current bet!");
            System.out.println("Your current bet is now " + slotsPlayer.CurrentBet);
        }
        else if (didWin==false)
        {
           slotsPlayer.placeBet((int) (slotsPlayer.CurrentBet - slotsPlayer.CurrentBet*.10));
           System.out.println("Sorry. You didn't hit the jackpot this time.");
           System.out.println("Your current bet has been decreased by 10%");
           System.out.println("Your current bet is now " + slotsPlayer.CurrentBet);
        }
    }
    public boolean didWin() throws InterruptedException {
        if (wordone.equals(wordtwo) && wordtwo.equals(wordthree)) {
            System.out.println("YOU WIN");
            return true;
        }
        return false;
    }
    public void SlotRoll() throws InterruptedException
    {
      assignWords();
        spacer();
        Thread.sleep(425);
    }




}

