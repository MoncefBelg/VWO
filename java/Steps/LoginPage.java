package Steps;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends CommonMethods {

    @Given("User is navigating to VWO website")
    public void user_is_navigating_to_vwo_website() {
        CommonMethods.openBrowserAndNavigateToURL();

    }
    @When("User enters a valid email address and a valid password")
    public void user_enters_a_valid_email_address_and_a_valid_password() {
        sendText(ConfigReader.getPropertyValue("email"), Pages.LoginPage.loginPage.username);
        sendText(ConfigReader.getPropertyValue("password"), Pages.LoginPage.loginPage.password);

    }
    @When("User clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
        click(Pages.LoginPage.loginPage.signInButton);

    }
    @Then("User is successfully logged in to the application")
    public void user_is_successfully_logged_in_to_the_application() throws InterruptedException {
      /*  WebElement  dashboardTitle=CommonMethods.waitForElementToBeVisible(driver, By.xpath("//h1[normalize-space()='Dashboard']"));
       // Assert the dashboard title
        String expectedTitle = "Dashboard";
        String actualTitle = dashboardTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println(actualTitle);*/
        Thread.sleep(2000);
        CommonMethods.assertElementText(driver,By.xpath("//h1[normalize-space()='Dashboard']"),"Dashboard");
        CommonMethods.closeBrowser();
    }
}
