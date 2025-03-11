package com.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product(1, "Laptop", "Electronics", 800),
            new Product(2, "Smartphone", "Electronics", 500),
            new Product(3, "Keyboard", "Computer Accessories", 50),
            new Product(4, "Monitor", "Electronics", 300),
            new Product(5, "Mouse", "Computer Accessories", 30)
        );

        // Group products by category
        Map<String, List<Product>> groupedProducts = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        Random random = new Random();

        groupedProducts.forEach((category, productList) -> {
            if (!productList.isEmpty()) {
                Product randomProduct = productList.get(random.nextInt(productList.size())); // Correct random selection
                System.out.println("Category: " + category + " => " + randomProduct);
            }
        });
    }
}

class Product {
    private final int id;
    private final String name;
    private final String category;
    private final double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}
