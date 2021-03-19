package Shopping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;

public class BasketRepository {
    UserID userID;
    String date;
    Hashtable<String, String> basket = new Hashtable<String, String>();

    public BasketRepository(UserID userID) {
        this.userID = userID;
        Date getDate = new Date();
        this.date = getDate.getDate();
        constructBasket();
    }


    private void constructBasket(){
        //String dateLine = "Creation Date : " + date;
        basket.put("Date", date);
        basket.put("Total", "0");
    }

    public void addItem(Product product, int quantity) {
        String total = basket.get("Total");
        String productLine = "";
        productLine = String.valueOf(quantity);
        productLine += " x " + product.name + " // ";
        productLine += String.valueOf(quantity) + " x £"  + product.price;
        Double price = getProductPriceTimesQuantity(product, quantity);
        total += price;
        productLine += " = " + String.valueOf(price);
        basket.put("Total", total);
        basket.put(product.productID.simpleID, productLine);
    }

//    private Product getProduct(ProductID productID){
//        ProductRepository productInformation = new ProductRepository();
//        return productInformation.getProduct(productID);
//    }


    private Double getProductPriceTimesQuantity(Product product, int quantity) {
        Double priceUnFormatted = product.price * quantity;
        System.out.println(priceUnFormatted);
        DecimalFormat decimal = new DecimalFormat("#.00");
        Double price = Double.valueOf(decimal.format(priceUnFormatted));
        return price;
    }

    public Hashtable<String, String> returnBasket() {
        return basket;
    }


    public Hashtable<String, String> checkout() {
        basket.put("message", "you have checked out");
        Hashtable<String, String> copy = basket;
        basket.clear();
        return copy;
    }

    public void remove(Product product, int quantity) {
        basket.remove(product.productID.simpleID);
    }
}
