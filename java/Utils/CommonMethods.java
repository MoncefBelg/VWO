package Utils;

import Pages.Filter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public static WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void assertElementText(WebDriver driver, By locator, String expectedText) {
        WebElement element = waitForElementToBeVisible(driver, locator);
        String actualText = element.getText();
        assertEquals(expectedText, actualText);
    }

    public static WebElement hoverOver(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(Pages.Updates.updates.updateSection).perform();
        return element;
    }

    public static int switchToWindowByIndex(int index){
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

       // Assuming you want to switch to the second window (index 1)
        driver.switchTo().window(windowHandlesList.get(index));
        return index;
    }
    public static boolean switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().contains(title)) {
                return true;
            }
        }
        return false;
    }

    public static  void FilterByProductsSingleSelect(String text){
        List  <WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[contains(@class,'Mih($footer-position-product-blog)')]//div//label"));
        for (int i = 1; i <=allCheckBoxes.size() ; i++) {
            WebElement checkBox = driver.findElement(By.xpath( "//div[contains(@class,'Mih($footer-position-product-blog)')]//div["+i+"]//label[1]"));
            String t =checkBox.getText();

            if (t.equals(text)){
                checkBox.click();
                break;
            }
        }

    }

        public static void FilterByAllProducts(){
            List  <WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[contains(@class,'Mih($footer-position-product-blog)')]//div//label"));
            for (WebElement a: allCheckBoxes) {
                a.click();
            }
          }
          public static void FilterByMultipleProducts(String t,String t1,String t2){
              List  <WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[contains(@class,'Mih($footer-position-product-blog)')]//div//label"));
              for (WebElement b: allCheckBoxes) {
                 String tex=b.getText();

                 if (tex.equals(t) || tex.equals(t1) || tex.equals(t2)){
                     b.click();
                 }
              }


          }


}


































