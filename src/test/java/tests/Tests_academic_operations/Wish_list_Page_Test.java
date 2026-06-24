package tests.Tests_academic_operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

import java.time.Duration;
import java.util.List;

public class Wish_list_Page_Test extends BaseTest {

    By Wish_list  = By.xpath("//a[text()='Wish list ']");
    By option = By.xpath("//option[@value = '[object Object]']");
    By remove = By.xpath("//button[span[text()='remove']]");
    By wish_ysem = By.id("wish_ysem");
    By CSS_105 = By.xpath("//a[@data-courseid='CSS 105']");
    By MDE_131 = By.xpath("//a[@data-courseid='MDE 131']");

    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void summer() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        DriverManager.driver.findElement(Wish_list).click();
        DriverManager.driver.findElement(wish_ysem).click();

        WebElement summerOption = DriverManager.driver.findElements(option).get(0);
        summerOption.click();

        //это код проверяет есть ли элементы в таблице если есть то удаляет
        List<WebElement> existing = DriverManager.driver.findElements(remove);
        for (int i = 0; i < existing.size(); i++) {
            DriverManager.driver.findElements(remove).get(0).click();
            wait.until(ExpectedConditions.alertIsPresent());
            DriverManager.driver.switchTo().alert().accept();
            wait.until(ExpectedConditions.numberOfElementsToBe(remove, existing.size() - 1 - i));
        }

        wait.until(ExpectedConditions.elementToBeClickable(CSS_105)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MDE_131)).click();

        // он ждет, пока станет больше 1
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(remove, 1));
        System.out.println("Initial remove buttons count: " +
                DriverManager.driver.findElements(remove).size());

        // --- Remove first item ---
        wait.until(ExpectedConditions.elementToBeClickable(remove)); // By локатор, не WebElement
        DriverManager.driver.findElements(remove).get(0).click();

        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.driver.switchTo().alert().accept();

        // он ждет пока будет ровно 1
        wait.until(ExpectedConditions.numberOfElementsToBe(remove, 1));

        // --- Remove second item ---
        wait.until(ExpectedConditions.elementToBeClickable(remove)); // снова By локатор
        DriverManager.driver.findElements(remove).get(0).click();

        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.driver.switchTo().alert().accept();

        // он ждет пока всё исчезнет
        wait.until(ExpectedConditions.numberOfElementsToBe(remove, 0));
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 2
    )
    public void fall(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        DriverManager.driver.findElement(Wish_list).click();
        DriverManager.driver.findElement(wish_ysem).click();

        WebElement summerOption = DriverManager.driver.findElements(option).get(1);
        summerOption.click();

        //это код проверяет есть ли элементы в таблице если есть то удаляет
        List<WebElement> existing = DriverManager.driver.findElements(remove);
        for (int i = 0; i < existing.size(); i++) {
            DriverManager.driver.findElements(remove).get(0).click();
            wait.until(ExpectedConditions.alertIsPresent());
            DriverManager.driver.switchTo().alert().accept();
            wait.until(ExpectedConditions.numberOfElementsToBe(remove, existing.size() - 1 - i));
        }

        wait.until(ExpectedConditions.elementToBeClickable(CSS_105)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MDE_131)).click();

        // он ждет, пока станет больше 1
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(remove, 1));
        System.out.println("Initial remove buttons count: " +
                DriverManager.driver.findElements(remove).size());

        // --- Remove first item ---
        wait.until(ExpectedConditions.elementToBeClickable(remove)); // By локатор, не WebElement
        DriverManager.driver.findElements(remove).get(0).click();

        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.driver.switchTo().alert().accept();

        // он ждет пока будет ровно 1
        wait.until(ExpectedConditions.numberOfElementsToBe(remove, 1));

        // --- Remove second item --
        wait.until(ExpectedConditions.elementToBeClickable(remove)); // снова By локатор
        DriverManager.driver.findElements(remove).get(0).click();

        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.driver.switchTo().alert().accept();

        // он ждет пока всё исчезнет
        wait.until(ExpectedConditions.numberOfElementsToBe(remove, 0));
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 3
    )
    public void spring(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        DriverManager.driver.findElement(Wish_list).click();
        DriverManager.driver.findElement(wish_ysem).click();

        WebElement summerOption = DriverManager.driver.findElements(option).get(2);
        summerOption.click();

        //это код проверяет есть ли элементы в таблице если есть то удаляет
        List<WebElement> existing = DriverManager.driver.findElements(remove);
        for (int i = 0; i < existing.size(); i++) {
            DriverManager.driver.findElements(remove).get(0).click();
            wait.until(ExpectedConditions.alertIsPresent());
            DriverManager.driver.switchTo().alert().accept();
            wait.until(ExpectedConditions.numberOfElementsToBe(remove, existing.size() - 1 - i));
        }

        wait.until(ExpectedConditions.elementToBeClickable(CSS_105)).click();
        wait.until(ExpectedConditions.elementToBeClickable(MDE_131)).click();

        // он ждет, пока станет больше 1
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(remove, 1));
        System.out.println("Initial remove buttons count: " +
                DriverManager.driver.findElements(remove).size());

        // --- Remove first item ---
        wait.until(ExpectedConditions.elementToBeClickable(remove)); // By локатор, не WebElement
        DriverManager.driver.findElements(remove).get(0).click();

        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.driver.switchTo().alert().accept();

        // он ждет пока будет ровно 1
        wait.until(ExpectedConditions.numberOfElementsToBe(remove, 1));

        // --- Remove second item ---
        wait.until(ExpectedConditions.elementToBeClickable(remove)); // снова By локатор
        DriverManager.driver.findElements(remove).get(0).click();

        wait.until(ExpectedConditions.alertIsPresent());
        DriverManager.driver.switchTo().alert().accept();

        // он ждет пока всё исчезнет
        wait.until(ExpectedConditions.numberOfElementsToBe(remove, 0));
    }
}
