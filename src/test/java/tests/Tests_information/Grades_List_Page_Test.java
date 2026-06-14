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

public class Grades_List_Page_Test extends BaseTest {

    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void grades_test(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Grades List ']")).click();
    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "grades_test"
    )
    public void grades_list(){

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By ysem =  By.id("ysem");
        By show = By.xpath("//input[@value='Show']");

        String[] options = {
                "(2023 - 2024) 1.Term",
                "(2023 - 2024) 2.Term",
                "(2024 - 2025) 1.Term",
                "(2024 - 2025) 2.Term",
                "(2025 - 2026) 1.Term",
                "(2025 - 2026) 2.Term"};

        for (String option : options) {
            step(ysem, show, option);

            wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(ysem)
            ));
        }

    }

    public void step(By ysem, By show, String option){
        int count = 0;
        while (count < 5){
            try {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ysem));
                new Select(element).selectByVisibleText(option);

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
