package tests.Tests_information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.DriverManager;
import utils.Retry;

import java.time.Duration;

public class My_Curriculum_Page_Test extends BaseTest {

    By My_Curriculum = By.xpath("//a[text()='My Curriculum ']");
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void my_curriculum_test(){
        DriverManager.driver.findElement(My_Curriculum).click();
    }
    @Test(
            retryAnalyzer = Retry.class,
            groups = "smoke",
            priority = 2
    )
    public void syllabus() {
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        String mainTab = DriverManager.driver.getWindowHandle();

        By trackSelect = By.xpath("//select[@onchange='GetCourseStructure(this)']");
        By mainTrack = By.xpath("//option[text()='M - Main Track']");

        // первый раз выбираем трек
        wait.until(ExpectedConditions.elementToBeClickable(trackSelect)).click();
        wait.until(ExpectedConditions.elementToBeClickable(mainTrack)).click();

        //EN
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'dk=MDE 171') and contains(@href,'lang=EN')]")
        )).click();
        switchToNewTab(mainTab);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabBasic"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabDesc"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabContents"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabOthers"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabPolicies"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//i[text()='Close window']]"))).click();
        DriverManager.driver.switchTo().window(mainTab);

        //RU
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'dk=MDE 171') and contains(@href,'lang=RU')]")
        )).click();
        switchToNewTab(mainTab);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabBasic"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabDesc"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabContents"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabOthers"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabPolicies"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//i[text()='Close window']]"))).click();
        DriverManager.driver.switchTo().window(mainTab);

        //KZ
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'dk=MDE 171') and contains(@href,'lang=KZ')]")
        )).click();
        switchToNewTab(mainTab);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabBasic"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabDesc"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabContents"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabOthers"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("stabPolicies"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//i[text()='Close window']]"))).click();
        DriverManager.driver.switchTo().window(mainTab);
    }

    private void switchToNewTab(String mainTab) {
        wait.until((WebDriver driver) -> driver.getWindowHandles().size() > 1);
        for(String tag : DriverManager.driver.getWindowHandles()) {
            if (!tag.equals(mainTab)) {
                DriverManager.driver.switchTo().window(tag);
                break;
            }
        }
    }
}
