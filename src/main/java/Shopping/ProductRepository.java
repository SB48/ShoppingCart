package Shopping;

import java.util.ArrayList;

//replaced by database
public class ProductRepository {
    ArrayList<Product> products = new ArrayList<>();

    public ProductRepository(){
        fillDatabaseBooks();
        fillDatabaseDVDs();
    }

    void fillDatabaseBooks(){
        Product hobbit = new Product("The Hobbit", 5, Type.BOOK);
        Product loTR = new Product("Lord of the Rings", 10, Type.BOOK);
        products.add(hobbit);
        products.add(loTR);
    }

    void fillDatabaseDVDs(){
        Product goT = new Product("Game of Thrones", 9, Type.DVD);
        Product breakingBad = new Product("Breaking Bad", 7, Type.DVD);
        products.add(goT);
        products.add(breakingBad);
    }

    public Product getProduct(ProductID productID) {
        for (Product product : products) {
            if (productID == product.productID){
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getAllProducts(){
        return products;
    }
}



