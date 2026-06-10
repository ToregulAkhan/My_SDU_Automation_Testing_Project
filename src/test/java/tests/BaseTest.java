package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

public class BaseTest {

    LoginPage loginPage;
    MainPage mainPage;

    By q_button = By.className("q-button");


    public void login(String username, String password) {
        DriverManager.openBrowser();

        loginPage = new LoginPage(DriverManager.driver);
        mainPage = new MainPage(DriverManager.driver);

        loginPage.openSite();

        loginPage.login(username, password);

        DriverManager.driver.findElement(q_button).click();

        Assert.assertTrue(mainPage.mainPageIsOpened());
    }
}
