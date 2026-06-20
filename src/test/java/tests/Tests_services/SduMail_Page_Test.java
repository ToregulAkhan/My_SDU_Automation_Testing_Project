package tests.Tests_services;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

import java.time.Duration;

public class SduMail_Page_Test extends BaseTest {
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void SduMail(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        String mainWindow = DriverManager.driver.getWindowHandle();

        DriverManager.driver.findElement(By.xpath("//a[text()='SduMail ']")).click();

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String handle : DriverManager.driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                DriverManager.driver.switchTo().window(handle);
                break;
            }
        }

        DriverManager.driver.close();

        DriverManager.driver.switchTo().window(mainWindow);
    }
}
