package org.experis.javashop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {

    //attributi
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal vat;
    private int quantity;
    private boolean isVisible;
    //costruttore
    public Product(String name, String description, BigDecimal price, BigDecimal vat, int quantity) {
        this.id = generateRandomId();
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
        this.isVisible = quantity > 0;
    }

    //metodi
    //ottieni codice id random
    public int generateRandomId() {
        Random random = new Random();
        // genera un numero casuale comresop tra 100000 e 99999999
        return 100000 + random.nextInt(90000000);
    }

    //ottieni prezzo totale
    /* dividi 22% iva x ottenere decimale 0.22, aggiungere 1 x poter moltiplicare prezzo x 1.22
    * NB: con bigDecimal non si possono usare gli operatori */

    public BigDecimal getTotalPrice(){
        //dividere x 100 ed aggiungere 1
        BigDecimal vatRate = this.vat.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP).add(BigDecimal.ONE);
        //ritornare price * 1.22; NB:   set Scale x arrotondare il risultato a due cifre decimali, RM HA ->arrotondato al numero intero superiore più vicino
        return this.price.multiply(vatRate).setScale(2, RoundingMode.HALF_UP);

    }

    //ottenere il nome esteso

    public String getFullName(){
        return String.format("%08d", this.id) + "-" + this.name;
    }

    //getters per accedere i valori delle istanze

    //id
    public int getId() {
        return this.id;
    }
    //name
    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean getIsVisible() {
        return this.isVisible;
    }
}
