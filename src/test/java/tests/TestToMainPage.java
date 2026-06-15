package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

public class TestToMainPage {

    LoginPage loginPage;
    MainPage mainPage;

    By q_button = By.className("q-button");

    @BeforeClass(alwaysRun = true)
    public void open(){
        DriverManager.openBrowser();
    }

    @Test(
            groups = "smoke",
            dataProvider = "login_pass",
            retryAnalyzer = Retry.class,
            dataProviderClass = Test_Data.class,
            priority = 0
    )
    public void login(String username, String password) {

        loginPage = new LoginPage(DriverManager.driver);
        mainPage = new MainPage(DriverManager.driver);

        loginPage.openSite();

        loginPage.login(username, password);

        DriverManager.driver.findElement(q_button).click();

        Assert.assertTrue(mainPage.mainPageIsOpened());
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        DriverManager.closeBrowser();
    }
}