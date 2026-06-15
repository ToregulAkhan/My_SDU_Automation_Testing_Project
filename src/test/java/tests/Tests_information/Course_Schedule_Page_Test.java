package tests.Tests_information;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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

public class Course_Schedule_Page_Test extends BaseTest {

    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Course_Schedule(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Course Schedule ']")).click();
    }

    @Test(
            retryAnalyzer = Retry.class,
            groups = "smoke",
            priority = 2
    )
    public void Individual_Schedule(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.id("rgI")).click();
        By select = By.id("ysem");
        By show = By.xpath("//input[@onclick=\"switchScheduleType(this);\"]");
        String[] options = {"Select", "(2023 - 2024) 1.term", "(2023 - 2024) 2.term", "(2024 - 2025) 1.term", "(2024 - 2025) 2.term", "(2025 - 2026) 1.term", "(2025 - 2026) 2.term"};

        for (String option : options) {
            select_year(select, show, option);

            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(select)));
        }
    }

    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Individual_Schedule"
    )
    public void Individual_Schedule_Details(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.id("rgI")).click();
        DriverManager.driver.findElement(By.id("chbDet")).click();
        By select = By.id("ysem");
        By show = By.xpath("//input[@onclick=\"switchScheduleType(this);\"]");
        String[] options = {"Select", "(2023 - 2024) 1.term", "(2023 - 2024) 2.term", "(2024 - 2025) 1.term", "(2024 - 2025) 2.term", "(2025 - 2026) 1.term", "(2025 - 2026) 2.term"};

        for (String option : options) {
            select_year(select, show, option);

            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(select)));
        }
    }

    @Test(
            retryAnalyzer = Retry.class,
            groups = "smoke",
            priority = 3
    )
    public void Speciality_Schedule(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.id("chbDet")).click();
        DriverManager.driver.findElement(By.id("rgS")).click();
        By select = By.id("ysem");
        By show = By.xpath("//input[@onclick=\"switchScheduleType(this);\"]");
        String[] options = {"Select", "(2023 - 2024) 1.term", "(2023 - 2024) 2.term", "(2024 - 2025) 1.term", "(2024 - 2025) 2.term", "(2025 - 2026) 1.term", "(2025 - 2026) 2.term"};

        for (String option : options) {
            select_year(select, show, option);

            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(select)));
        }
    }

    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Speciality_Schedule"
    )
    public void Speciality_Schedule_Details(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.id("rgS")).click();
        DriverManager.driver.findElement(By.id("chbDet")).click();
        By select = By.id("ysem");
        By show = By.xpath("//input[@onclick=\"switchScheduleType(this);\"]");
        String[] options = {"Select", "(2023 - 2024) 1.term", "(2023 - 2024) 2.term", "(2024 - 2025) 1.term", "(2024 - 2025) 2.term", "(2025 - 2026) 1.term", "(2025 - 2026) 2.term"};

        for (String option : options) {
            select_year(select, show, option);

            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(select)));
        }
    }


    public void select_year(By select, By show, String option){
        int count = 0;
        while (count < 5){
            try{
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(select));
                new Select(element).selectByVisibleText(option);

                wait.until(ExpectedConditions.elementToBeClickable(show)).click();

                return;
            }
            catch(StaleElementReferenceException e){
                if (count == 5){
                    throw e;
                }
                count++;
            }
        }
    }
}
