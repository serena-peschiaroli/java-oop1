package org.experis.javashop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Fountain pen", "an elegant fountain pen", new BigDecimal("20.50"), new BigDecimal("22"), 10, true);
        Product product2 = new Product("Notepad A4 - 3 Pack", "A notepad packed with list pages", new BigDecimal("27.79"), new BigDecimal("22"), 7, true);

        System.out.println("product no 1: " + product1.getFullName() + ", total price: " + product1.getTotalPrice() + ", is available: " + product1.getIsVisible());
        System.out.println("product 2: " + product2.getFullName() + ", net price: " + product2.getPrice() +  ", tot price: " + product2.getTotalPrice());




    }
}
