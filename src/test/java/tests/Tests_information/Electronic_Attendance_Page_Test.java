package tests.Tests_information;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

import java.time.Duration;

public class Electronic_Attendance_Page_Test extends BaseTest {
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Electronic_Attendance(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Electronic Attendance ']")).click();
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Electronic_Attendance"
    )
    public void Attendance_Select(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        By select = By.id("ysem");
        By show = By.xpath("//input[@class=\"btn\"]");
        String[] year = {
                "Choose",
                "2025 - 2026 ( 2 )",
                "2025 - 2026 ( 1 )",
                "2024 - 2025 ( 2 )",
                "2024 - 2025 ( 1 )",
                "2023 - 2024 ( 2 )",
                "2023 - 2024 ( 1 )"};

        for (String option : year){
            term(select, show, option);

        }
    }

    public void term(By select, By show, String option){
        int count = 0;
        while (count < 5){
            try {
                WebElement element_select = wait.until(ExpectedConditions.elementToBeClickable(select));
                new Select(element_select).selectByVisibleText(option);

                wait.until(ExpectedConditions.elementToBeClickable(show)).click();

                return;
            }
            catch (StaleElementReferenceException e){
                count++;
                if (count == 5){
                    throw e;
                }
            }
        }
    }
}
