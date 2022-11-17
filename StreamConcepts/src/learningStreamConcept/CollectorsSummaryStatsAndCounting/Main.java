package learningStreamConcept.CollectorsSummaryStatsAndCounting;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
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

        DoubleSummaryStatistics summary = productArrayList.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println("max price: "+summary.getMax());
        System.out.println("Low Price: "+summary.getMin());
        System.out.println("Average Price: "+summary.getAverage());
        System.out.println("Count: "+summary.getCount());
        System.out.println("sum Price of all prdts: "+summary.getSum());

        //count
        long count = productArrayList.stream().filter(product -> product.price > 30000.0f)
                .collect(Collectors.counting());
        System.out.println("No of products above 30k : " + count );
        //another method
        long count1 = productArrayList.stream().filter(product -> product.price > 30000.0f).count();
        System.out.println("No of products above 30k : " + count1 );
        //another method for min & max price

        Product productMax = productArrayList.stream()
                .max((product1,product2)-> product1.price > product2.price ? 1 : -1).get();
        System.out.println("Expensive phone : "+productMax);

        Product productMin = productArrayList.stream()
                .min((product1,product2)-> product1.price > product2.price ? 1 : -1).get();
        System.out.println("Cheapest Phone : "+productMin);


    }
}
