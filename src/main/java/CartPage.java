import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage {

    By productCount = By.id("quantitySelect0");
    By removeButton = By.id("removeCartItemBtn0");
    By emptyMessage = By.id("emtyCart");
    By cartPrice = new By.ByCssSelector("span.m-productPrice__salePrice");

    Select count;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkPrize() {
        String tempPrize = find(cartPrice).getText();
        return ProductPage.price.equals(tempPrize);
    }

    public void increase() {
        count = new Select(find(productCount));
        if(count.getOptions().size() > 1){
            count.selectByValue("2");
        }

//        try {
//            Thread.sleep(3000);
//        }catch (Exception e){
//            System.out.println(e);
//        }

    }

    public boolean increased() {
        return count.getFirstSelectedOption().getAttribute("value").equals("2");
    }

    public void remove() {
        _wait(removeButton);
        find(removeButton).click();
    }

    public boolean removed() {
        _wait(emptyMessage);
        return isDisplayed(emptyMessage);
    }
}
