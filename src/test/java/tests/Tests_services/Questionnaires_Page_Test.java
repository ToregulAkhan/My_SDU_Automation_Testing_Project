package tests.Tests_services;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.DriverManager;
import utils.Retry;

public class Questionnaires_Page_Test extends BaseTest {

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Questionnaires(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Questionnaires ']"));
    }
}
