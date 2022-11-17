package learningStreamConcept.StreamReduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        //using reduce() to sum the products
        Float sumOfPrice = productArrayList.stream().map(product -> product.price)
                .reduce(0.0f,(sum,price) -> sum+price);
        System.out.println("sum price of the product : "+sumOfPrice);
        //using reduce() to find highest price
        Optional<Product> highestPrice = productArrayList.stream()
                .reduce((product1,product2) -> product1.price > product2.price ? product1 : product2);
        List<Product> highPriceProduct = highestPrice.stream().collect(Collectors.toList());
        System.out.println("product with High price : "+highPriceProduct);
        //using reduce() to find Lowest price Product
        Optional<Product> lowestPrice = productArrayList.stream()
                .reduce((product1,product2) -> product1.price > product2.price ? product2 : product1);
        List<Product> lowestPriceProduct = lowestPrice.stream().collect(Collectors.toList());
        System.out.println("product with Low price : "+lowestPriceProduct);




    }
}
