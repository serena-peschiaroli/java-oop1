package org.experis.javabank;

import java.math.BigDecimal;
import java.util.Random;

public class BankAccount {

    //variabili
    private String iban;
    private String clientName;
    private BigDecimal balance;

    //costruttore

    public BankAccount(String clientName) {
        this.clientName = clientName;
        this.iban = generateIban();
        this.balance = BigDecimal.ZERO;
    }

    //metodi

    //generare iban
    public String generateIban(){
        Random random = new Random();
        return "IT" + String.format("%02d", random.nextInt(90) + 10) + String.format("%10d", random.nextInt(1000000000));
    }

    //prelevare denaro

    public void withdrawal(BigDecimal cash){
        // Controlla se cash è maggiore di 0 e non supera il saldo
        if (cash.compareTo(BigDecimal.ZERO) > 0 && cash.compareTo(balance) >0 ){
            balance = balance.subtract(cash);
            System.out.println("Withdrawal successful. current balance: " + balance);

        }else{
            System.out.println("Not valid. Please check available balance");

        }
    }

    //depositare denaro

    public void deposit(BigDecimal amount){
        //se amount è maggiore di zero, procedi con l'operazione
        if(amount.compareTo(BigDecimal.ZERO) > 0){
            balance = balance.add(amount);
            System.out.println("deposit successful. New balance: " + balance);
        }else {
            System.out.println("invalid amount");
        }

    }

    //getters;
    public String getIban() {
        return iban;
    }

    public String getClientName() {
        return clientName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getInfos(){
        return clientName + " " + iban;
    }

}
