package com.example;

import java.util.Arrays;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    private List<Product> products;
    private static final double SALES_TAX = 0.08; // 8% sales tax
    private static final double DISCOUNT_THRESHOLD = 1000.0;
    private static final double DISCOUNT_PERCENTAGE = 0.10; // 10% discount

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public double calculateSubtotal() {
        return products.stream()
                .map(Product::getTotalPrice) // Extracts total price of each product
                .reduce(0.0, Double::sum); // Sums up all prices
    }

    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double discount = (subtotal > DISCOUNT_THRESHOLD) ? subtotal * DISCOUNT_PERCENTAGE : 0.0;
        double discountedTotal = subtotal - discount; // Amount after discount
        double tax = discountedTotal * SALES_TAX; // Sales tax applied to discounted amount
        return discountedTotal + tax; // Final total
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
            new Product("Laptop", 1200.0, 1),
            new Product("Wireless Headphones", 150.0, 2),
            new Product("Smartphone", 800.0, 1),
            new Product("Charging Cable", 25.0, 3),
            new Product("Tablet", 600.0, 1),
            new Product("Mechanical Keyboard", 200.0, 1),
            new Product("Gaming Mouse", 100.0, 1)
        ));

        System.out.println("Subtotal: $" + cart.calculateSubtotal());
        System.out.println("Total (after tax & discount): $" + cart.calculateTotal());
    }
}
