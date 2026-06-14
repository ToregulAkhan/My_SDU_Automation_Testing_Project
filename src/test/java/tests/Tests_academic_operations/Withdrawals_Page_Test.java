package tests.Tests_academic_operations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

public class Withdrawals_Page_Test extends TestToMainPage {

    By withdrawals = By.xpath("//a[text()='Withdrawals '] ");
    By yearTerm = By.id("yearTerm");
    By year_term = By.id("yearterm");

    @Test(
            groups = "smoke",
            priority = 1,
            retryAnalyzer = Retry.class
    )
    public void withdrawals_test(){
        DriverManager.driver.findElement(withdrawals).click();
        DriverManager.driver.findElement(yearTerm).click();
        DriverManager.driver.findElement(year_term).click();
        
    }
}
