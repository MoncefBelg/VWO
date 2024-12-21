package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountUsage extends CommonMethods {

    @FindBy(xpath ="//button[@id='js-header-account-details']")
    public  WebElement UsageActivityButton;

    @FindBy(xpath = "//a[@class='text-link Fw(medium) Fz(12px) ng-scope']")
    public  WebElement viewDetails;

    @FindBy(xpath = "//vwo-menu[@ng-if='!(isShareView && !isImpersonatedWithoutVwoAccess)']//img[@alt='jwhif mfkwji']")
    public  WebElement profileIcon;








public AccountUsage(){ PageFactory.initElements(driver,this);}


}
