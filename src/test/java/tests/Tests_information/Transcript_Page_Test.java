package tests.Tests_information;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

public class Transcript_Page_Test extends BaseTest {

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void transcript_Test() {
        DriverManager.driver.findElement(By.xpath("//a[text()='Transcript ']"));
    }
}
