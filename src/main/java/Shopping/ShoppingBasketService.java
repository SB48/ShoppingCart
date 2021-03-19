package Shopping;

import Shopping.ProductID;
import java.util.Hashtable;
import java.util.Set;

public class ShoppingBasketService {

    public void addItem(User user, Product product, int quantity) {
        user.addItem(product, quantity);
    }

    public void remove(User user, Product product, int quantity) {
        user.remove(product,quantity);
    }

    public Hashtable<String, String> basketFor(User user){
        Hashtable<String, String> allContent = user.getBasket();
        printBasketContent(allContent);
        return allContent;
    }

    public void checkout(User user) {
        Hashtable<String, String> allContent = user.checkout();
        printBasketContent(allContent);
    }

    private void printBasketContent(Hashtable<String, String> contents) {
        Set<String> setOfKeys = contents.keySet();
        for (String key : setOfKeys) {
            System.out.println(contents.get(key));
        }
    }

}
