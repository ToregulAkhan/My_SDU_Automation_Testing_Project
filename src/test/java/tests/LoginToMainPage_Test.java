package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

public class LoginToMainPage_Test{
    LoginPage loginPage;
    MainPage mainPage;

    By q_button = By.className("q-button");

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        DriverManager.openBrowser();
        loginPage = new LoginPage(DriverManager.driver);
        mainPage = new MainPage(DriverManager.driver);
        loginPage.openSite();

    }

    @Test(
            groups = "smoke",
            dataProvider = "login_pass",
            retryAnalyzer = Retry.class,
            dataProviderClass = Test_Data.class,
            priority = 1

    )
    public void login(String username, String password) {
        loginPage.login(username, password);
        DriverManager.driver.findElement(q_button).click();
        Assert.assertTrue(mainPage.mainPageIsOpened());
    }
}
