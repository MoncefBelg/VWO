package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    @FindBy(xpath ="//input[@id='login-username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='login-password']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='js-login-btn']")
    public WebElement signInButton;


    @FindBy(xpath = "//h1[normalize-space()='Dashboard']")
    public WebElement dashboardPage;

public  LoginPage(){
    PageFactory.initElements(driver,this);
}


}
