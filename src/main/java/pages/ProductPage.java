package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage{

    private By productName = By.className("hrefch");
    private By categoryName = By.id("itemc");

    public ProductPage( ) {
        super();
    }

    public void seeProduct() {
        waitFor(2);
        List<WebElement> products = driver.findElements(productName);
        System.out.println("Product names are displayed below:");
        for (WebElement product : products) {
            System.out.println(product.getText());
        }
    }

    public void navigateToCategory(String name) {
            List<WebElement> categories = driver.findElements(categoryName);
            System.out.println("Category names are displayed below:");
            WebElement categoryToClick = null;
            for (WebElement category : categories) {
                System.out.println(category.getText());
                if (category.getText().equals(name)) {
                    categoryToClick = category;
                }
            }
            if (categoryToClick != null) {
                categoryToClick.click();
                waitFor(1);
            }
    }

    public void checkProduct() {
        seeProduct();
    }
}
