package tests.Tests_information;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

import java.time.Duration;

public class Gate_Entry_Records_Page_Test extends BaseTest {
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Gate_Entry_Records(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Gate Entry Records ']")).click();
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 2
    )
    public void Gate_Entry_test(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By Beginning_date = By.id("date1");
        By Ending_date = By.id("date2");
        By type = By.id("rGroup");
        By show = By.id("btn_results");

        String[] options = {
                "Chemistry Lab",
                "Dorm Boys",
                "Dorm Girls",
                "GYM Boys, GYM Girls, Sport Hall",
                "Meeting Room - ENG",
                "Server Room, Synology",
                "TechnoPark",
                "Tourniquet, Gates, SDU Life"};

        for (String option : options) {

            int count = 0;

            while (count < 5){
                try{

                    WebElement begin = wait.until(ExpectedConditions.visibilityOfElementLocated(Beginning_date));
                    WebElement end = wait.until(ExpectedConditions.visibilityOfElementLocated(Ending_date));

                    begin.sendKeys("2025-06-01");
                    end.sendKeys("2025-07-02");

                    WebElement select_option = wait.until(ExpectedConditions.visibilityOfElementLocated(type));
                    new Select(select_option).selectByVisibleText(option);

                    wait.until(ExpectedConditions.elementToBeClickable(show)).click();

                    break;

                }catch(StaleElementReferenceException e){
                    count++;
                    if (count == 5){
                        throw e;
                    }
                }
            }
        }
    }

}
