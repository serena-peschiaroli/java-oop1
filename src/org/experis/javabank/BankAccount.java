package org.experis.javabank;

import java.math.BigDecimal;
import java.util.Random;

public class BankAccount {
    private String iban;
    private String clientName;
    private BigDecimal balance;

    public BankAccount(String iban, String clientName) {
        this.clientName = clientName;
        this.iban = generateIban();
        this.balance = BigDecimal.ZERO;
    }

    //generare iban
    public String generateIban(){
        Random random = new Random();
        return "IT" + String.format("%02d", random.nextInt(90) + 10) + String.format("%10d", random.nextInt(1000000000));
    }

    //prelevare denaro

    public void withdrawal(BigDecimal cash, BigDecimal balance){
        // Controlla se cash è maggiore di 0 e non supera il saldo
        if (cash.compareTo(BigDecimal.ZERO) > 0 && cash.compareTo(balance) >0 ){
            balance = balance.subtract(cash);
            System.out.println("Withdrawal successful. current balance: " + balance);

        }else{
            System.out.println("Not valid. Please check available balance");

        }
    }

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
