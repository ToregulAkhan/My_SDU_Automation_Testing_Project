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

public class System_Calendar_Page_Test extends BaseTest {

    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void System_Calendar(){
        DriverManager.driver.findElement(By.xpath("//a[text()='System Calendar ']")).click();
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            dependsOnMethods = "System_Calendar"
    )
    public void Сalendar_Select(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        By select = By.id("ysem");
        By show = By.xpath("//input[@value=\"Show\"]");
        String[] year = {
                "2026 - 2027 Fall",
                "2025 - 2026 Summer",
                "2025 - 2026 Spring",
                "2025 - 2026 Fall",
                "2024 - 2025 Summer",
                "2024 - 2025 Spring",
                "2024 - 2025 Fall",
                "2023 - 2024 Summer",
                "2023 - 2024 Spring",
                "2023 - 2024 Fall"};

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
