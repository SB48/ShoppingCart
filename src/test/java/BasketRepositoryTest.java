import Shopping.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BasketRepositoryTest {
    @Mock
    UserID userID;
    BasketRepository basket;
    ArrayList<Product> allProducts = new ArrayList<>();


    @BeforeAll
    public void testSetUp() {
        basket = new BasketRepository(userID);
        ProductRepository productRepository = new ProductRepository();
        this.allProducts = productRepository.getAllProducts();
    }


    @Test
    public void cart_empty_after_checkout() {
        basket.addItem(allProducts.get(1), 4);
        basket.checkout();
        Hashtable<String, String> content = basket.returnBasket();
        assertEquals(null, content.get("Total"));
    }


    @Test
    public void price_of_item_at_0multiple_quantity_is_double(){
        Product product = new Product("TestProduct", 4, Type.BOOK);
        basket.addItem(product, 4);
        Hashtable<String,String> content = basket.returnBasket();
        Double expectedValue = 4.00*4.00;
        assertEquals(expectedValue, content.get("Total"));
    }

}
