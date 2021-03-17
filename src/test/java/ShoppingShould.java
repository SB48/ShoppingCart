import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ShoppingShould {
    @Mock ShoppingBasketService cart;
    @Mock UserID userID;
    @Mock ProductID productID;

    @Test
    public void purchase_unit(){
        cart.addItem(userID, productID, 1);
        var content = cart.checkContent();
        assertEquals("userID", content);
    }

    @Test
    public void passing_test(){
        assertEquals(1,1);
    }

    @Test
    public void created_on_first_product_add(){

    }

}
