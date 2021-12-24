import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductPage extends BasePage {

    By addBasket = By.id("addBasket");
    By variations = new By.ByCssSelector("span.m-variation__item:not(.-disabled)");
    By count = new By.ByClassName("o-header__userInfo--count");
    By priceBox = By.id("priceNew");
    By cart = new By.ByCssSelector("a.o-header__userInfo--item.bwi-cart-o.-cart");

    public static String price;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(addBasket);
    }

    public void addToCart() {
        int size = getSizes().size();
        int randomNum = ThreadLocalRandom.current().nextInt(0, size);
        getSizes().get(randomNum).click();
        _wait(addBasket);
        click(addBasket);
    }

    public boolean increased() {
        _wait(count);
        price = find(priceBox).getText();
        return isDisplayed(count);
    }

    public void goToCart() {
        _wait(cart);
        find(cart).click();
    }

    private List<WebElement> getSizes(){
        return findAll(variations);
    }
}
