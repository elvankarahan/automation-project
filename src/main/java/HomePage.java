import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBar searchBar;

    By account = new By.ByCssSelector("a.o-header__userInfo--item.bwi-account-o.-customer");
    By favorite = new By.ByCssSelector("a.o-header__userInfo--item.bwi-favorite-o.-favorite");
    By cart = new By.ByCssSelector("a.o-header__userInfo--item.bwi-cart-o.-cart");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBar = new SearchBar(driver);
    }

    public SearchBar searchBar(){
        return this.searchBar;
    }

    public boolean isOnHomePage() {
        return (isDisplayed(account) && isDisplayed(favorite) && isDisplayed(cart));
    }

}
