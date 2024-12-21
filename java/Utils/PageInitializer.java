package Utils;

import Pages.AccountUsage;
import Pages.Filter;
import Pages.LoginPage;
import Pages.Updates;

public class PageInitializer {

    public static LoginPage loginPage;
    public static AccountUsage accountUsage;
    public static Updates updates;
    public static Filter filter;



    public static void initializePageObjects(){
        loginPage = new LoginPage();
        accountUsage = new AccountUsage();
        updates = new Updates();
        filter = new Filter();

    }

}
