import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class BaseTest_Product extends BaseTest {

    HomePage homePage;
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void check_homepage(){
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isOnHomePage(), "Not on homepage!");
    }

    @Test
    @Order(2)
    public void search_product(){
        searchPage = new SearchPage(driver);
        homePage.searchBar.search("pantolon");
        Assertions.assertTrue(searchPage.isOnSearchPage(), "Not on search page!");
        searchPage.scrollAndClick();
    }

    @Test
    @Order(3)
    public void select_product(){
        productPage = new ProductPage(driver);
        searchPage.selectProduct();
        Assertions.assertTrue(productPage.isOnProductPage(), "Product not selected!");
    }

    @Test
    @Order(4)
    public void add_to_cart(){
        productPage.addToCart();
        Assertions.assertTrue(productPage.increased(), "Not added to cart!");

    }
    @Test
    @Order(5)
    public void check_prize(){
        productPage.goToCart();
        cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.checkPrize(), "Prices are not the same!");
    }

    @Test
    @Order(6)
    public void make_it_two(){
        cartPage.increase();
        Assertions.assertTrue(cartPage.increased(), "The value specified is invalid");
    }
    @Test
    @Order(7)
    public void remove_product(){
        cartPage.remove();
        Assertions.assertTrue(cartPage.removed(), "Not removed!");
    }
}
