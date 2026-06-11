package tests.Tests_academic_operations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.academic_operations.Consent_Requests_Page;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

public class Consent_Requests_Page_Test extends TestToMainPage {

    By Consent_Requests = By.xpath("//a[text()='Consent Requests ']");
    By GetRequests =  By.xpath("//select[@onchange='GetRequests()']");
    By option = By.cssSelector("[value='1#1']");
    By button = By.cssSelector("[type='button']");

    @Test(
            groups = "smoke",
            dataProvider = "login_pass",
            dataProviderClass = Test_Data.class,
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void setup(String username, String password){
        super.login(username, password);
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
