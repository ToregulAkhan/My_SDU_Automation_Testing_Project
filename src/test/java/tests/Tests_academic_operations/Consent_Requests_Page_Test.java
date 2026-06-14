package tests.Tests_academic_operations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.DriverManager;
import utils.Retry;

public class Consent_Requests_Page_Test extends BaseTest {

    By Consent_Requests = By.xpath("//a[text()='Consent Requests ']");
    By GetRequests =  By.xpath("//select[@onchange='GetRequests()']");
    By option = By.cssSelector("[value='1#1']");
    By button = By.cssSelector("[type='button']");

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void setup(){
        DriverManager.driver.findElement(Consent_Requests).click();
    }

    @Test(
            groups = "smoke",
            priority = 2
    )
    public void test_to_Page(){
        DriverManager.driver.findElement(GetRequests).click();
        DriverManager.driver.findElement(option).click();
        DriverManager.driver.findElement(button).click();
    }
}
