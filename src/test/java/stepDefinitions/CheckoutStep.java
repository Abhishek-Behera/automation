package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutStep {
    CheckoutPage checkoutPage;
    CartPage cartPage;

    @Before
    public void setUp() {
        this.checkoutPage = new CheckoutPage();
        this.cartPage = new CartPage();
    }

    @BeforeStep
    public void beforeStep() {
        checkoutPage.waitFor(2);
    }

    @Given("the user has products in their cart")
    public void theUserHasProductsInTheirCart() {
        checkoutPage.navigateTo("https://www.demoblaze.com/");
        cartPage.selectProduct();
        cartPage.addToCart();
        checkoutPage.clickOkInAlert();
        checkoutPage.checkProduct();

    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        System.out.println("Clicked on order button");
        checkoutPage.clickOrder();
    }

    @Then("the user should be able to complete the checkout process")
    public void theUserShouldBeAbleToCompleteTheCheckoutProcess() {
        System.out.println("Filled out the checkout process");
        checkoutPage.completeCheckout();
    }

    @And("the user should see a confirmation of the successful purchase")
    public void theUserShouldSeeAConfirmationOfTheSuccessfulPurchase() {
        checkoutPage.getConfirmation();
    }

    @Given("the user's cart is empty")
    public void theUserSCartIsEmpty() {
        checkoutPage.navigateTo("https://www.demoblaze.com/");
        checkoutPage.checkProduct();
    }

    @Then("the user should see an error message indicating no products to checkout")
    public void theUserShouldSeeAnErrorMessageIndicatingNoProductsToCheckout() {
        checkoutPage.completeCheckout();
        String msg = checkoutPage.getConfirmation();
        Assert.assertNotEquals("Thank you for your purchase!",msg);
    }


}
