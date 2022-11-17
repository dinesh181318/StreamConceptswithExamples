package learningStreamConcept.ConcurrentMap;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;
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

        ConcurrentMap<Integer,Product> productConcurrentMap = productArrayList.stream()
                .collect(Collectors.toConcurrentMap(Product::getId,product -> product));
        System.out.println(productConcurrentMap);

        ConcurrentMap<Integer,String> productConcurrentMap1 = productArrayList.stream()
                .collect(Collectors.toConcurrentMap(Product::getId,Product::getName));
        System.out.println(productConcurrentMap1);
        //getting the object by key
        System.out.println(productConcurrentMap.get(2));

        
    }
}
