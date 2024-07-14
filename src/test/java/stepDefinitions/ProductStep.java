package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;

public class ProductStep {
    ProductPage productPage;

    @Before
    public void setUp() {
        this.productPage = new ProductPage();
    }

    @Then("user should see a list of products")
    public void iShouldSeeAListOfProducts() {
        System.out.println("See the list of products");
        productPage.seeProduct();
    }

    @When("the user navigates to a product category {string}")
    public void theUserNavigatesToAProductCategory(String name) {
        System.out.println("Navigate to the product category");
        productPage.navigateToCategory(name);
    }

    @Then("the user should see a list of products in that category")
    public void theUserShouldSeeAListOfProductsInThatCategory() {
        System.out.println("See the list of products in that category");
        productPage.checkProduct();
    }


}
