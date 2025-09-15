package practice.streams.store;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Product{
    String name;
    String category;
    int quantity;

    public Product(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}


public class GeneralStoreManagement {

    public static void main(String[] args) {
        List<Product> productList = List.of(
                new Product("Dove", "Soap", 10),
                new Product("Apple", "Fruit", 20),
                new Product("Potato", "Vegetable", 23),
                new Product("Cinthol", "Soap", 3),
                new Product("Mango", "Fruit", 10),
                new Product("Tomato", "Vegetable", 3),
                new Product("Carrot", "Vegetable", 5)

        );

        Map<String, Integer> productsPerCategory = productList.stream()
                .collect(Collectors.groupingBy(
                        //product -> product.getCategory(),  //Lambda instead of bellow Method Reference
                        Product::getCategory,
                        Collectors.summingInt(Product::getQuantity)
                ));

        System.out.println("productsPerCategory: " + productsPerCategory);
        //productsPerCategory: {Fruit=30, Soap=13, Vegetable=31}

        Optional<Map.Entry<String, Integer>> maxSellCategory = productsPerCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue());
                System.out.println(maxSellCategory.isPresent()?maxSellCategory.get():"empty");

        Optional<String> profitableCategory = productsPerCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                //.map(entry -> entry.getKey());
                        .map(Map.Entry::getKey);
        System.out.println(profitableCategory.orElse("empty"));

        Optional<Integer> profitableCount = productsPerCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                //.map(entry -> entry.getValue());
                .map(Map.Entry::getValue);
        System.out.println(profitableCount.orElse(0));
    }
}
