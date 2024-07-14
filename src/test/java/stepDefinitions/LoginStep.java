package stepDefinitions;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.ExcelDataReader;

import java.util.List;

public class LoginStep {
    LoginPage loginPage;
    ExcelDataReader excelDataReader;

    public LoginStep() {
        this.loginPage = new LoginPage();
        this.excelDataReader = new ExcelDataReader("D:/testAuto/automation/src/test/resources/testData/Sheet.xlsx");
    }

    @BeforeStep
    public void beforeStep() {
        loginPage.waitFor(1);
    }


    @When("the user clicks on Login button")
    public void theUserClicksOnSignUpButton() {
        loginPage.openLoginModal();
        System.out.println("Login button clicked");
    }


    @And("the user enters login username and password")
    public void theUserEntersLoginUsernameAndPassword() {
        List<String[]> testData = excelDataReader.readData("Sheet1");
        if (testData.isEmpty()) {
            System.out.println("No data found in the Excel file.");
            return;
        }
        for (String[] data : testData) {
            if (data.length >= 2) {
                loginPage.enterUsername(data[0]);
                loginPage.enterPassword(data[1]);
            } else {
                System.out.println("Invalid data row: " + String.join(", ", data));
            }
        }
    }

    @And("the user enters invalid login username and password")
    public void theUserEntersInvalidLoginUsernameAndPassword() {
        List<String[]> testData = excelDataReader.readData("Sheet2");
        if (testData.isEmpty()) {
            System.out.println("No data found in the Excel file.");
            return;
        }
        for (String[] data : testData) {
            if (data.length >= 2) {
                loginPage.enterUsername(data[0]);
                loginPage.enterPassword(data[1]);
            } else {
                System.out.println("Invalid data row: " + String.join(", ", data));
            }
        }
    }


    @When("clicks on the login button")
    public void clicksOnTheSignUpButton() {
        System.out.println("Clicking on the login button");
        loginPage.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeRegisteredSuccessfully() {
        System.out.println("User should be logged in successfully");
        loginPage.checkUserName();
    }

    @Then("the user should see an error message for invalid credentials")
    public void theUserShouldSeeAnErrorMessageForInvalidCredentials() {
        System.out.println("User should see an error message");
        String errorMessage = loginPage.getAlertMessage();
        Assert.assertTrue(errorMessage.equals("Please fill out Username and Password.") || errorMessage.equals("Wrong password."));
    }

    @Given("the user is logged in with username {string} and password {string}")
    public void theUserIsLoggedIn(String username, String password) {
        loginPage.openLoginModal();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @When("the user clicks the logout button")
    public void theUserClicksTheLogoutButton() {
        loginPage.logout();
    }

    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut() {
        loginPage.checkLogout();
    }


}
