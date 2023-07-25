package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    // variables
    private String accountName;
    private String accountPassword;
    private double casinoBalance = 0;

    public CasinoAccount(String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
    }

    public CasinoAccount() {

    }

    public String getName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public double getCasinoBalance() {
        return casinoBalance;
    }
    public void addCasinoBalance(double add){
        casinoBalance+=add;
    }
    public void subCasinoBalance(double sub){
        casinoBalance-=sub;
    }


    public void setCasinoBalance(double casinoBalance) {
        this.casinoBalance = casinoBalance;
    }


    public CasinoAccount(String accountName, String accountPassword, double casinoBalance) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.casinoBalance=casinoBalance;
    }


}
