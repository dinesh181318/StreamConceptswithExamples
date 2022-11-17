package learningStreamConcept.CollectorsPartitionBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        Map<Boolean, List<Product>> products = productArrayList.stream()
                .collect(Collectors.partitioningBy(product -> product.price > 30000.0f));
        System.out.println("products price above 30,000"+products.get(true));
        System.out.println("products price below 30,000"+products.get(false));

    }
}
