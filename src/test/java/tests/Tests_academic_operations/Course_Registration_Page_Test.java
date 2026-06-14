package tests.Tests_academic_operations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.DriverManager;
import utils.Retry;

public class Course_Registration_Page_Test extends BaseTest {

    By Course_Registration  = By.xpath("//a[text()='Course Registration ']");
    By inputTrack = By.id("inputTrack");
    By selectTrack = By.id("selectTrack");
    By Main_Track = By.xpath("//*[text()='M - Main Track']");

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void setup(){
        DriverManager.driver.findElement(Course_Registration).click();
    }

    @Test(
            groups = "smoke",
            priority = 2
    )
    public void test_to_page(){
        DriverManager.driver.findElement(inputTrack).click();
        DriverManager.driver.findElement(selectTrack).click();
        DriverManager.driver.findElement(Main_Track).click();

    }
}
