package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {
    public static WebDriver driver;
    private static final int TIMEOUT = 10;
    private static WebDriverWait wait;

    public BasePage() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        waitForVisible(locator).click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    public void takeScreenshot(String methodName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String fileName = "screenshot_" + methodName + "_" + timeStamp + ".png";
        String directory = System.getProperty("user.dir") + "/screenshots/";
        File destinationFile = new File(directory + fileName);
        try {
            FileHandler.copy(screenshotFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAlertMessage() {
        Alert confirmation = driver.switchTo().alert();
        String alerttext = confirmation.getText();
        if (alerttext != null ) {
            System.out.println(alerttext);
        }
        return alerttext;
    }

    public void clickOkInAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
            // Handle case where no alert is present
        }
    }

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scroll(int times) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < times; i++) {
            js.executeScript("window.scrollBy(0, 500)");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        scrollToElement(element);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!isElementVisible(element)) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            try {
                Thread.sleep(500); // Adjust the sleep time if needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
