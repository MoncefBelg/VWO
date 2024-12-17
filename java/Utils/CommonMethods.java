package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

public static void openBrowserAndNavigateToURL(){

    ConfigReader.readProperties(Constants.CONFIG_PROPERTIES_PATH);

    switch (ConfigReader.getPropertyValue("browser")){

        case "chrome":
            driver = new ChromeDriver();
            break;

        case "edge":
            driver = new EdgeDriver();
            break;
    }

    driver.manage().window().maximize();
    driver.get(ConfigReader.getPropertyValue("url"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    //this method is going to initialize all the objects available inside this method
    initializePageObjects();

}
 public static void closeBrowser(){
     if (driver!= null){
       driver.close();
   }
}

     public static void sendText(String text, WebElement element) {
         element.clear();
         element.sendKeys(text);
     }

    public static WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(CommonMethods.driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void assertElementText(WebDriver driver, By locator, String expectedText) {
        WebElement element = waitForElementToBeVisible(driver, locator);
        String actualText = element.getText();
        assertEquals(expectedText, actualText);
    }

}
























