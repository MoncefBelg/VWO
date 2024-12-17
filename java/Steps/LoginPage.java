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
    public void user_is_successfully_logged_in_to_the_application()  {
        CommonMethods.assertElementText(driver,By.xpath("//h1[normalize-space()='Dashboard']"),"Dashboard");
        CommonMethods.closeBrowser();
    }

    @When("User enters invalid {string} address and a invalid {string}")
    public void user_enters_invalid_address_and_a_invalid(String email, String password) {
       sendText(email, loginPage.username);
       sendText(password,loginPage.password);
    }
    @Then("{string} message is displayed")
    public void message_is_displayed(String error) {
        CommonMethods.assertElementText(driver,By.xpath("//div[@id='js-notification-box-msg']"),
                "Your email, password, IP address or location did not match");
        CommonMethods.closeBrowser();
    }

}
