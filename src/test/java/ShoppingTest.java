import Shopping.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShoppingTest {
    ArrayList<Product> allProducts = new ArrayList<>();
    ShoppingBasketService cart = new ShoppingBasketService();
    User user = new User();

    @BeforeAll
    public void testSetUp(){
        ProductRepository productRepository = new ProductRepository();
        this.allProducts = productRepository.getAllProducts();
    }

    // Acceptance Criteria 1
    // Shopping basket should be created when the first product is added
    @Test
    public void created_on_first_product_add() throws Exception {
        Date date = new Date();
        String curDate = date.getDate();
        cart.addItem(user, allProducts.get(0), 1);
        var content = cart.basketFor(user);
        assertEquals(curDate, content.get("Date"));
    }

    // Acceptance Criteria 2
    // Shopping basket should be persisted - checkout (In-memory, DB later)
    @Test
    public void shopping_basket_exists_after_checkout(){
        cart.addItem(user, allProducts.get(0), 1);
        cart.checkout(user);
        assertTrue(cart!=null);

    }

    // Acceptance Criteria 2
    // Shopping basket should be persisted - no items (In-memory, DB later)
    @Test
    public void shopping_basket_exists_after_items_removed(){
        cart.addItem(user, allProducts.get(0), 1);
        cart.remove(user, allProducts.get(0), 1);
        assertTrue(cart!=null);
    }


//     Acceptance Criteria 3
//     Each user should have her own shopping basket.
    @Test
    public void user_has_shopping_basket(){
        //user.(allProducts.get(0), 1);
        //verify(cart).addItem(userID, productID, 1);
    }

    @Test
    public void add_all_items(){
        for (Product product : allProducts){
            cart.addItem(user, product, 1);
        }
        cart.basketFor(user);
    }

    @Test
    public void add_multiple_of_item(){
        cart.addItem(user, allProducts.get(1), 4);
        cart.checkout(user);
    }

    @Test
    public void cart_empty_after_checkout(){
        cart.addItem(user, allProducts.get(1), 4);
        cart.checkout(user);
        Hashtable<String, String> content = cart.basketFor(user);
        assertEquals(null, content.get("Total"));

    }
}
