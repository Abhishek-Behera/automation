package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private By nextButton = By.id("next2");
    private By productName = By.className("hrefch");
    By addCart = By.cssSelector(".btn.btn-success.btn-lg");

    public CartPage( ) {
        super();
    }

    public void clickNext() {
        click(nextButton);
    }

    public void selectProduct() {
        waitFor(2);
        List<WebElement> products = driver.findElements(productName);

        if (!products.isEmpty()) {
            WebElement lastProduct = products.get(products.size() - 1);
            lastProduct.click();
        }
    }

    public void addToCart() {
        waitFor(1);
        click(addCart);
    }

    public void checkCart() {

    }
}

