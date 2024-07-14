package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignupPage;
import utility.ExcelDataReader;

import java.util.List;


public class SignupStep {
    SignupPage signUpPage;
    ExcelDataReader excelDataReader;

    @Before
    public void setUp() {
        this.signUpPage = new SignupPage();
        this.excelDataReader = new ExcelDataReader("D:/testAuto/automation/src/test/resources/testData/Sheet.xlsx");

    }

    @BeforeStep
    public void beforeStep() {
        signUpPage.waitFor(1);
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheSignUpPage() {
        signUpPage.navigateTo("https://www.demoblaze.com/");
        System.out.println("Home Page is displayed");
    }

    @When("the user clicks on Sign up button")
    public void theUserClicksOnSignUpButton() {
        signUpPage.openSignupModal();
        System.out.println("Sign up button clicked");
    }


    @And("user enters login username and password")
    public void userEntersLoginUsernameAndPassword() {
        List<String[]> testData = excelDataReader.readData("Sheet3");
        if (testData.isEmpty()) {
            System.out.println("No data found in the Excel file.");
            return;
        }
        for (String[] data : testData) {
            if (data.length >= 2) {
                signUpPage.enterUsername(data[0]);
                signUpPage.enterPassword(data[1]);
            } else {
                System.out.println("Invalid data row: " + String.join(", ", data));
            }
        }
    }


    @When("clicks on the signup button")
    public void clicksOnTheSignUpButton() {
        System.out.println("Clicking on the signup button");
        signUpPage.clickSignUpButton();
    }

    @Then("the user should be registered successfully")
    public void theUserShouldBeRegisteredSuccessfully() {
        System.out.println("User should be registered successfully");
        String successMessage = signUpPage.getAlertMessage();
        Assert.assertEquals("Sign up successful.", successMessage);
    }

    @And("user enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        List<String[]> testData = excelDataReader.readData("Sheet2");
        if (testData.isEmpty()) {
            System.out.println("No data found in the Excel file.");
            return;
        }
        for (String[] data : testData) {
            if (data.length >= 2) {
                signUpPage.enterUsername(data[0]);
                signUpPage.enterPassword(data[1]);
            } else {
                System.out.println("Invalid data row: " + String.join(", ", data));
            }
        }
    }

    @Then("the user should see an error message")
    public void theUserShouldSeeAnErrorMessage() {
        System.out.println("User should see an error message");
        String errorMessage = signUpPage.getAlertMessage();
        Assert.assertTrue(errorMessage.equals("Please fill out Username and Password.") || errorMessage.equals("This user already exist."));

    }


//    @AfterStep
//    public void afterStep(Scenario scenario) {
//        if (scenario.isFailed()) {
//            String methodName = scenario.getName().replaceAll(" ", "_");
//            signUpPage.takeScreenshot(methodName);
//        }
//    }


    @After
    public void tearDown() {
        signUpPage.quitDriver();
    }

}

