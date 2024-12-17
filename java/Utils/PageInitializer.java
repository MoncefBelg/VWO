package Utils;

import Pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;



    public static void initializePageObjects(){
        loginPage=new LoginPage();
    }
}
