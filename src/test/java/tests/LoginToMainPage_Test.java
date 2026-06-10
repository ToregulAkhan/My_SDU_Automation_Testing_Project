package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainPage;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

import java.time.Duration;

public class LoginToMainPage_Test {
    LoginPage loginPage;
    MainPage mainPage;
    WebDriverWait wait;


    By loginLink = By.className("loginLink");
    By studId = By.xpath("//input[@name='studId']");
    By submit = By.xpath("//input[@type='submit']");
    By q_button = By.className("q-button");

    @BeforeClass(alwaysRun = true)
    public void loginPage(){
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
            priority = 3

    )
    public void login(String username, String password) {
        DriverManager.driver.navigate().back();
        DriverManager.driver.navigate().back();
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(q_button));

        loginPage.login(username, password);

        DriverManager.driver.findElement(q_button).click();

        Assert.assertTrue(mainPage.mainPageIsOpened());
    }

    @Test(
            groups = "smoke",
            priority = 2
    )
    public void can_not_access(){
        DriverManager.driver.findElements(loginLink).get(0).click();
        DriverManager.driver.findElement(studId).sendKeys("230103366");
        DriverManager.driver.findElement(submit).click();
    }

}
