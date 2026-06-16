package tests.Tests_information;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

import java.time.Duration;

public class Accounting_Info_Page_Test extends BaseTest {
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Accounting_Info(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Accounting Info ']")).click();
    }

    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Accounting_Info",
            priority = 2
    )
    public void pay_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By amount = By.id("amount");
        By pay = By.xpath("//div[text()=\"Pay\"]");

        WebElement amountElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(amount)
        );

        // очистка input
        amountElement.sendKeys(Keys.CONTROL + "a");
        amountElement.sendKeys(Keys.DELETE);

        // проверка VALUE, а не text
        String value = amountElement.getAttribute("value");

        if (value.isEmpty()) {
            DriverManager.driver.findElement(pay).click();

            wait.until(ExpectedConditions.alertIsPresent());
            DriverManager.driver.switchTo().alert().accept();

            WebElement amountWeb = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(amount)
            );

            amountWeb.sendKeys("1");
        }

        // лучше ввод гарантированно перед оплатой
        DriverManager.driver.findElement(pay).click();

        wait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//button[text()='Cancel']")))
                .click();
    }

    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Accounting_Info",
            priority = 3
    )
    public void account(){
        DriverManager.driver.findElement(By.xpath("//input[@onclick=\"AccountDetails('230103366','2023','1')\"]")).click();
        DriverManager.driver.findElement(By.xpath("//input[@onclick=\"AccountDetails('230103366','2023','2')\"]")).click();
        DriverManager.driver.findElement(By.xpath("//input[@onclick=\"AccountDetails('230103366','2024','1')\"]")).click();
        DriverManager.driver.findElement(By.xpath("//input[@onclick=\"AccountDetails('230103366','2024','2')\"]")).click();
        DriverManager.driver.findElement(By.xpath("//input[@onclick=\"AccountDetails('230103366','2025','1')\"]")).click();
        DriverManager.driver.findElement(By.xpath("//input[@onclick=\"AccountDetails('230103366','2025','2')\"]")).click();
    }
}
