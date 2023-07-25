package com.github.zipcodewilmington.casino;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager extends CasinoAccount{
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */

    public static LinkedHashMap<String, CasinoAccount> data = new LinkedHashMap<String, CasinoAccount>();


    public CasinoAccount getAccount(String accountName, String accountPassword) {

        boolean end=false;
        Iterator it = data.entrySet().iterator();
        CasinoAccount acc = null;
       // acc=data.get(accountName);

            while (it.hasNext()&& !end) {
                Map.Entry pair = (Map.Entry) it.next();
                acc = (CasinoAccount) pair.getValue();
                if (Objects.equals(acc.getName(), accountName) && Objects.equals(acc.getAccountPassword(), accountPassword)) {
                    end = true;
                }
                else{
                    acc=null;
                }
        }

        return acc;
    }


        //String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //String currentClassName = getClass().getName();
        //String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        //throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));



    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        CasinoAccount account=new CasinoAccount();



        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        account.setAccountName(accountName);
        String currentClassName = getClass().getName();
        account.setAccountPassword(accountPassword);
        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        data.put(accountName,account);
        return account;


    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    
    public void registerAccount(CasinoAccount casinoAccount) {


        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();

        String currentClassName = getClass().getName();

        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }
    public static void addAllAccounts(){
        data.put("Santos",new CasinoAccount("Santos","123" , 1000));

        

        try {
            Scanner fileIn = new Scanner(new File("src/main/java/com/github/zipcodewilmington/casino/Accounts.txt"));

            while (fileIn.hasNextLine())
            {
                String line = fileIn.nextLine();
                String [] accountData=line.split(",");
                String hashKey= (accountData[0]);
                String accountName= (accountData[1]);
                String accountPass= (accountData[2]);
                double casinoBalance= Double.parseDouble(accountData[3]);

                // Reads the entire line
                // Output the line
                data.put(hashKey, new CasinoAccount(accountName,accountPass,casinoBalance));
            }
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }
    public static void addtofile(){
        //add to file
        File file = new File("src/main/java/com/github/zipcodewilmington/casino/Accounts.txt");
        BufferedWriter bf = null;
        //adds account to properties
        try {


            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, CasinoAccount> entry : data.entrySet()) {
                // put key and value separated by a colon
                bf.write(entry.getKey() + "," + entry.getValue().getName()+","+entry.getValue().getAccountPassword()+","+entry.getValue().getCasinoBalance());
                // new line
                bf.newLine();
            }
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {

                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }

    }
}
