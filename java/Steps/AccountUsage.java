package Steps;

import Utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccountUsage extends CommonMethods {
   @When("User click on Usage Activity Button")
    public void user_click_on_usage_activity_button()  {
       CommonMethods.waitForClickability(Pages.AccountUsage.accountUsage.UsageActivityButton);
       CommonMethods.click(Pages.AccountUsage.accountUsage.UsageActivityButton);


    }

   @Then("User is able to check his activities")
    public void user_is_able_to_check_his_activities() throws InterruptedException {
       CommonMethods.waitForClickability(AccountUsage.accountUsage.viewDetails);
       CommonMethods.click(Pages.AccountUsage.accountUsage.viewDetails);
    }
}
