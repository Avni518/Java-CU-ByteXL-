import java.util.*;
import java.util.stream.*;
import java.util.Comparator;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

public class PartC {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200, "Electronics"),
            new Product("Smartphone", 800, "Electronics"),
            new Product("Headphones", 150, "Electronics"),
            new Product("Shirt", 40, "Clothing"),
            new Product("Jeans", 60, "Clothing"),
            new Product("Blender", 100, "Home Appliances"),
            new Product("Microwave", 200, "Home Appliances")
        );

        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        groupedByCategory.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> {
            product.ifPresent(p -> System.out.println(category + ": " + p));
        });

        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
