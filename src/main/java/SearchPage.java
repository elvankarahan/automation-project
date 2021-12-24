import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SearchPage extends BasePage {

    By sortByBox = By.id("productListTitle");
    By product = By.xpath("//*[@id=\"productList\"]/div");
    By moreContentButton = By.xpath("//*[@id=\"moreContentButton\"]");

    Actions actions = new Actions(driver);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnSearchPage() {
        _wait(sortByBox);
        return isDisplayed(sortByBox);
    }

    public void scrollAndClick() {
        //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        actions.moveToElement(find(moreContentButton));
        actions.perform();
        find(moreContentButton).click();
    }

    public void selectProduct() {
        int size = getAllProducts().size();
        int randomNum = ThreadLocalRandom.current().nextInt(0, size);
        getAllProducts().get(randomNum).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(product);
    }


}
