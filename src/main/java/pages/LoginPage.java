package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By loginModalButton = By.id("login2");
    private By logoutButton = By.id("logout2");
    private By userName = By.id("nameofuser");

    public void openLoginModal() {
        click(loginModalButton);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void checkUserName() {
        String usr = getText(userName);
        if (usr!=null)
        {
            System.out.println(usr);

        }
    }

    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void logout() {
        click(logoutButton);
    }

    public void checkLogout() {
        if(!isElementVisible(logoutButton)){
            System.out.println("Logout Successfully");
        }else {
            System.out.println("Logout Failed");
        }
    }
}
