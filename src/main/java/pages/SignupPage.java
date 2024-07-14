package pages;
import org.openqa.selenium.By;

public class SignupPage extends BasePage {

    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signUpButton = By.xpath("//button[text()='Sign up']");
    private By signUpModalButton = By.id("signin2");

    public SignupPage( ) {
        super();
    }

    public void openSignupModal() {
        click(signUpModalButton);
    }

    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickSignUpButton() {
        click(signUpButton);
    }


}

