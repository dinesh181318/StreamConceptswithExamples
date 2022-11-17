package learningStreamConcept.CollectorsGroupingBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    float price;
    String type;

    public Product(int id, String name, float price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        productArrayList.add(new Product(1, "Apple IPhone", 150000.0f,"Smart Phone"));
        productArrayList.add(new Product(3, "OnePlus Phone", 50000.0f,"Smart Phone"));
        productArrayList.add(new Product(4, "Samsung Phone", 75000.0f,"Smart Phone"));
        productArrayList.add(new Product(2, "MI Phone", 15000.0f,"Smart Phone"));
        productArrayList.add(new Product(5, "Realme Phone", 12000.0f,"Smart Phone"));
        
//     filtering highest Price Products
        Comparator<Product> byPrice = Comparator.comparing(Product::getPrice);

        System.out.println("Most Expensive phone");
        Map<String, Optional<Product>> collect =
                productArrayList.stream().collect(
                        Collectors.groupingBy(
                                Product::getType,
                                Collectors.reducing(BinaryOperator.maxBy(byPrice))
                        )
                );
        System.out.println(collect);

        System.out.println("Cheapest Phone");
        Map<String, Product> stringProductMap= productArrayList.stream()
                .collect(Collectors.groupingBy(Product::getType,
                                Collectors.collectingAndThen(
                                        Collectors.minBy(
                                                Comparator.comparingDouble(Product::getPrice)
                                        ), Optional::get)
                        )
                );
        System.out.println(stringProductMap);

    }
}
