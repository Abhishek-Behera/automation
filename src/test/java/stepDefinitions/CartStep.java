package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;

public class CartStep {
    CartPage cartPage;

    @Before
    public void setUp() {
        this.cartPage = new CartPage();
    }

    @BeforeStep
    public void beforeStep() {
        cartPage.waitFor(1);
    }

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        cartPage.navigateTo("https://www.demoblaze.com/");
        System.out.println("Home Page is displayed");
    }

    @When("the user navigates to the last page by clicking next")
    public void theUserNavigatesToTheLastPageByClickingNext() {
        System.out.println("Clicking next page");
        cartPage.clickNext();
    }

    @And("the user selects the last product")
    public void theUserSelectsTheLastProduct() {
        System.out.println("Selecting the last product");
        cartPage.selectProduct();
    }

    @And("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        System.out.println("Adding the product to the cart");
        cartPage.addToCart();
    }

    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
        String successMessage = cartPage.getAlertMessage();
        Assert.assertEquals("Product added", successMessage);
        System.out.println("Product added to the cart");
    }

    @After
    public void tearDown() {
        cartPage.quitDriver();
    }

}
