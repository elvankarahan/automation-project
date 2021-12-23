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
        Assertions.assertTrue(homePage.isOnHomePage(), "No!");
    }

    @Test
    @Order(2)
    public void search_product(){
        searchPage = new SearchPage(driver);
        homePage.searchBar.search("pantolon");
        Assertions.assertTrue(searchPage.isOnSearchPage(), "No!");
        searchPage.scrollAndClick();
    }

    @Test
    @Order(3)
    public void select_product(){
        productPage = new ProductPage(driver);
        searchPage.selectProduct();
        Assertions.assertTrue(productPage.isOnProductPage(), "No!");
    }

    @Test
    @Order(4)
    public void add_to_cart(){
        productPage.addToCart();
        Assertions.assertTrue(productPage.increased(), "No!");

    }
    @Test
    @Order(5)
    public void check_prize(){
        productPage.goToCart();
        cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.checkPrize(), "No!");
    }

    @Test
    @Order(6)
    public void make_it_two(){
        cartPage.increase();
        Assertions.assertTrue(cartPage.increased(), "No!");
    }
    @Test
    @Order(7)
    public void remove_product(){
        cartPage.remove();
        Assertions.assertTrue(cartPage.removed(), "No!");
    }


}
