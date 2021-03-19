package Shopping;

import java.text.DecimalFormat;

import static java.lang.Math.round;

public class Product {
    ProductID productID;
    public Double price;
    public String name;
    Type type;

    public Product(String name, int price, Type type) {
        this.name = name;
        DecimalFormat decimal = new DecimalFormat("###0.00");
        this.price = Double.valueOf(decimal.format(price));
        this.type = type;
        this.productID = new ProductID();
    }

}
