package Shopping;

import Shopping.ProductID;

import java.util.Hashtable;

public class User {
    BasketRepository basket;
    UserID userID;

    public User() {
        this.userID = new UserID();
        basket = new BasketRepository(userID);
    }

    public void addItem(Product product, int quantity) {
        basket.addItem(product, quantity);
    }

    public Hashtable<String, String> getBasket() {
        return basket.returnBasket();
    }

    public void remove(Product product, int quantity) {
        basket.remove(product, quantity);
    }

    public Hashtable<String, String> checkout() {
        return basket.checkout();
    }
}
