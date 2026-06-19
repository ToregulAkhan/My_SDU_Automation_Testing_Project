package tests.Tests_services;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

public class Online_Services_Page_Test extends TestToMainPage {
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Online_Services(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Online Services ']")).click();
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 2
    )
    public void send_order(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By order_type = By.id("doc_type");

        String[] order_type_options = {
                "Transcript","Military Service (Certificate №3)",
                "Information about studying place (University)",
                "Анықтама №29", "Certificate of tuition fees",
                "Student Card", "Анықтама №4", "Certificate №6",
                "Certificate №2-1"};

        String[] Language_options = {"English", "Kazakh", "Russian"};

        String[] Delivery_method_options = {"Advising Desk", "Online"};

        for(String o : order_type_options){
            select(order_type, o);

            Select s = new Select(DriverManager.driver.findElement(By.id("doc_lang")));
            Select s2 = new Select(DriverManager.driver.findElement(By.id("dm")));

            for (String lang : Language_options) {
                try {
                    s.selectByVisibleText(lang);
                    break; // нашли и выбрали
                } catch (NoSuchElementException e) {
                    // такого языка нет, пробуем следующий
                }
            }

            for(String m : Delivery_method_options){
                try {
                    s2.selectByVisibleText(m);
                    break; // нашли и выбрали
                } catch (NoSuchElementException e) {
                    // такого языка нет, пробуем следующий
                }
            }
        }




    }

    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "send_order"
    )
    public void order(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//span[@onclick=\"Sifarisler(); return false;\"]")).click();
        String mainWindow = DriverManager.driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"showPdf(78402);\"]"))).click();
        wait.until(d->d.getWindowHandles().size() > 1);
        for (String h : DriverManager.driver.getWindowHandles()) {
            if (!h.equals(mainWindow)) {
                DriverManager.driver.switchTo().window(h);
                break;
            }
        }
        DriverManager.driver.close();
        DriverManager.driver.switchTo().window(mainWindow);
        wait.until(d->d.getWindowHandles().size() == 1);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"https://ezsigner.kz/\"]"))).click();
        wait.until(d->d.getWindowHandles().size() > 1);
        for (String h : DriverManager.driver.getWindowHandles()) {
            if (!h.equals(mainWindow)) {
                DriverManager.driver.switchTo().window(h);
                break;
            }
        }
        DriverManager.driver.close();
        DriverManager.driver.switchTo().window(mainWindow);
        wait.until(d->d.getWindowHandles().size() == 1);
    }

    public void select(By selector, String option){
        int count = 0;
        while (count < 5){
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
                Select s = new Select(element);
                s.selectByVisibleText(option);
                return;
            }
            catch (StringIndexOutOfBoundsException e){
                count++;
                if (count == 5){
                    throw e;
                }
            }
        }
    }
}
