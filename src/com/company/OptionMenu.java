package com.company;

import java.io.IOException;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput=new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
    HashMap<Integer,Integer> data=new HashMap<>();
    /**
     * Validate Login Information customer number and pin number
     */
    public void getLogin() throws IOException{
        int x=1;
        do{
            try{
                data.put(191520018,7007360);
                data.put(191520014,70780499);
                System.out.println(" ------- Welcome to the ATM Project ------- ");
                System.out.println("Enter Your Customer Number:");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter Your Pin Number:");
                setPinNumber(menuInput.nextInt());

            }catch (Exception e){
                System.out.println("\n"+"Invalid Character(s). Only numbers."+"\n");
                x=2;
            }
            for(Map.Entry<Integer,Integer> entry: data.entrySet()){
                if(entry.getKey()== getCustomerNumber() && entry.getValue()== getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n"+"Wrong Customer Number or Pin Number."+"\n");
        }
        while (x==1);
    }

    private void getAccountType() {
        System.out.println("Select the account you want to access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("choice: ");
        int selection=menuInput.nextInt();
        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thanks You For using this ATM, bye.");
                break;
            default:
                System.out.println("\n "+"Invalid choice."+"\n");
                getAccountType();
        }

    }

    private void getChecking() {
        System.out.println("Checking Account :");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        int selection=menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: "+moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" +"Invalid Choice. "+"\n");
                getChecking();

        }


    }
    private void getSaving() {
        System.out.println("Saving Account :");
        System.out.println("Type 1 -  View Balance");
        System.out.println("Type 2 -  Withdraw Funds");
        System.out.println("Type 3 -  Deposit Funds");
        System.out.println("Type 4 -  Exit");
        System.out.print("choice: ");
        int selection=menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;
            default:
                System.out.println("\n" +"Invalid Choice. "+"\n");
                getSaving();
            }
    }
}


