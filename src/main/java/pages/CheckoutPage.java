package pages;

import org.openqa.selenium.By;


public class CheckoutPage extends BasePage{

    private By cartButton = By.id("cartur");
    private By product = By.className("success");
    private By orderButton = By.xpath("//button[text()='Place Order']");
    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By success = By.xpath("//*[text()='Thank you for your purchase!']");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");


    public CheckoutPage() {super();}


    public void checkProduct() {
        click(cartButton);
        if(isElementVisible(product)){
            System.out.println("Product is in cart");
        }else {
            System.out.println("Product is not in cart");
        }
    }

    public void clickOrder() {
        click(orderButton);
    }

    public void completeCheckout() {
        sendKeys(nameField,"a");
        sendKeys(countryField,"a");
        sendKeys(cityField,"a");
        sendKeys(cardField,"a");
        sendKeys(monthField,"a");
        sendKeys(yearField,"a");
        click(purchaseButton);
    }

    public String getConfirmation() {
        System.out.println(getText(success));
        return getText(success);
    }
}
