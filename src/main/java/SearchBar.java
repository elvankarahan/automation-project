import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBar extends BasePage {

    //By searchBarLocator = By.xpath("/html/body/header/div/div/div[2]/div/div/div/input");
    By searchBarLocator = By.cssSelector("input.default-input");

    public SearchBar(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBarLocator, text);
        find(searchBarLocator).sendKeys(Keys.ENTER);
    }
}
