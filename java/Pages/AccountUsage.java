package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountUsage extends CommonMethods {

    @FindBy(xpath ="//button[@id='js-header-account-details']")
    public WebElement UsageActivityButton;

    @FindBy(xpath = "//a[@class='text-link Fw(medium) Fz(12px) ng-scope']")
    public WebElement viewDetails;











}
