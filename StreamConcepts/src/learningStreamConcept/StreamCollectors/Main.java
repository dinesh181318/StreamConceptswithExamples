package learningStreamConcept.StreamCollectors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    float price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
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

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        productArrayList.add(new Product(1,"Apple IPhone",150000.0f));
        productArrayList.add(new Product(3,"OnePlus Phone",50000.0f));
        productArrayList.add(new Product(4,"Samsung Phone",65000.0f));
        productArrayList.add(new Product(2,"MI Phone",15000.0f));
        productArrayList.add(new Product(5,"Realme Phone",12000.0f));
        //Collectors.toList()
        System.out.println("Collectors.toList()");
        List<Product> productList = productArrayList.stream().collect(Collectors.toList());
        productList.forEach(System.out::println);
        //Collectors.toSet()
        System.out.println("Collectors.toSet()");
        Set<Product> productSet = productArrayList.stream().collect(Collectors.toSet());
        productSet.forEach(System.out::println);
        //Collectors.toCollection()
        System.out.println("Collectors.toCollection() to ArrayList");
        ArrayList<Product> productArrayList1 = productArrayList.stream().collect(Collectors.toCollection(ArrayList::new));
        productArrayList1.forEach(System.out::println);
        System.out.println("Collectors.toCollection() to HashSet");
        HashSet<Product> productHashSet = productArrayList.stream().collect(Collectors.toCollection(HashSet::new));
        productHashSet.forEach(System.out::println);
        // Using Collectors's method to sum the prices.
        double totalPrice = productArrayList.stream()
                .collect(Collectors.summingDouble(product->product.price));
        System.out.println("Total price of all Products : "+totalPrice);
    }
}
