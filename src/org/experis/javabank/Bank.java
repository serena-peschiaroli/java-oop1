package org.experis.javabank;

import java.math.BigDecimal;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        //inizializzare scanner

        Scanner scanner = new Scanner(System.in);

        //chiedere nome utente
        System.out.println("welcome, enter your name: ");

        String name = scanner.nextLine();
        //nuovo BankAccount con nome utente
        BankAccount account = new BankAccount(name);
        System.out.println("new account created with iban: " + account.getIban());
        //loop per permettere ad utente di effettuare scelte
        boolean exit = false;
        //mentre Exit è false:
        while(!exit){
            System.out.println("Please enter an option: 1- deposit, 2- Withdraw, 3- Show Balance 4-Your info, 5-Exit ");

            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice){
                case 1:
                    System.out.println("enter amout to deposit");
                    //per evitare exception fra scanner nextline e scanner nextbigdecimal
                    BigDecimal depositAmount = new BigDecimal(scanner.nextLine());
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("enter amount to withdraw: ");
                    BigDecimal withdrawalAmount = new BigDecimal(scanner.nextLine());
                    account.withdrawal(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Your info: " + account.getInfos());
                    break;
                case 5:
                    System.out.println("Thank you. Good bye");
                    exit = true;
                    break;
                default:
                    System.out.println("not valid, please enter a valid choice");
                    break;
            }


        }
        scanner.close();
    }
}
