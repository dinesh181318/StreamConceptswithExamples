package learningStreamConcept.StreamSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Product{
    int id;
    String name;
    Float price;
    String type;

    public Product(int id, String name, Float price, String type) {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
//sorting
        System.out.println("Sorting by Comparator by price");
        List<Product> sortListByPrice = productArrayList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList());
        sortListByPrice.forEach(System.out::println);
        System.out.println("Sorting reverse by Comparator by price");
        List<Product> sortReverseListByPrice = productArrayList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()).collect(Collectors.toList());
        sortReverseListByPrice.forEach(System.out::println);

        System.out.println("Sorting by Comparator by name");

        List<Product> sortListByName = productArrayList.stream()
                .sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
        sortListByName.forEach(System.out::println);

        //another methods
        System.out.println("Sorting  by CompareTo price");
        List<Product> sortListByPrice1 = productArrayList.stream()
                .sorted((p1,p2)->p1.getPrice().compareTo(p2.getPrice())).collect(Collectors.toList());
        sortListByPrice1.forEach(System.out::println);

        System.out.println("Sorting by compareTo by name");

        List<Product> sortListByName1 = productArrayList.stream()
                .sorted((p1,p2)->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        sortListByName1.forEach(System.out::println);
        //sorting without stream
        productArrayList.sort((p1,p2)->p1.getPrice().compareTo(p2.getPrice()));
        System.out.println("sort w/o stream");
        productArrayList.forEach(System.out::println);
        System.out.println("sort reverse w/o stream by collection");
        Collections.sort(productArrayList,Comparator.comparing(Product::getPrice).reversed());
        productArrayList.forEach(System.out::println);







    }
}
