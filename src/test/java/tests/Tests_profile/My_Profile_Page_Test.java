package tests.Tests_profile;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

import java.time.Duration;

public class My_Profile_Page_Test extends BaseTest {
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void My_Profile(){
        DriverManager.driver.findElement(By.xpath("//a[text()='My Profile ']")).click();
        DriverManager.driver.findElement(By.xpath("//span[text()='My info']")).click();
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 2
    )
    public void Main_Information(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Main Information']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Edit']"))).click();

        WebElement retemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("retemail")));
        retemail.sendKeys(Keys.CONTROL + "a");
        retemail.sendKeys(Keys.DELETE);
        retemail.sendKeys("akhantoregul23@gmail.com");

        By marstatussel = By.id("marstatussel");
        String[] options = {"Мarried", "Single", "Divorced"};

        for(String option : options){
            select(marstatussel, option);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Cancel']"))).click();
        // Ждём, пока Cancel-кнопка исчезнет (DOM обновился)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[value='Cancel']")));
        // Теперь снова ищем Edit — элемент гарантированно свежий
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Edit']"))).click();
        // Save
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Save']"))).click();
        // Ждём подтверждения сохранения (исчезновение Save или появление сообщения)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[value='Save']")));

    }


    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Main_Information"
    )
    public void Contacts(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Contacts']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[onclick='AddContact()']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add Contact']")));

        By type_owner = By.id("typeowner");
        String[] Type_parent = {
                "Oneself", "Father", "Mother", "Sister", "Brother", "Uncle (by Father)",
                "Uncle (by Mother)", "Aunt (by Mother)", "Aunt (by Father)", "Grandfather",
                "Grandmother", "Son", "Daughter", "Cousin", "Spouse", "Other"};

        By type_con = By.id("typecon");
        String[] type = {
                "Mobile phone", "Home phone",
                "Work phone", "E-mail", "Fax"};


        for (String option :Type_parent) {
            select(type_owner, option);

            Select s =  new Select(DriverManager.driver.findElement(type_con));
            for (String option_con : type) {
                try {
                    s.selectByVisibleText(option_con);
                }catch (NoSuchElementException e){

                }
            }
        }

        WebElement contact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact")));
        WebElement note = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note")));

        contact.sendKeys(Keys.CONTROL + "a");
        contact.sendKeys(Keys.DELETE);
        contact.sendKeys("+7 777 666 9999");

        note.sendKeys(Keys.CONTROL + "a");
        note.sendKeys(Keys.DELETE);
        note.sendKeys("+7 777 666 9999");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Cancel']"))).click();
    }


    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Contacts"
    )
    public void Address(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Address']"))).click();
    }


    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Address"
    )
    public void Parent_Information(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Parent Information']"))).click();
    }


    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Parent_Information"
    )
    public void Decisions(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Decisions']"))).click();
    }


    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Decisions"
    )
    public void Dissertation(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Dissertation']"))).click();
    }


    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Dissertation"
    )
    public void Social_Activities(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Social Activities']"))).click();
    }




    public void select(By selector, String option){
        int count = 0;
        while (count < 5){
            try {

                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
                new Select(element).selectByVisibleText(option);
                return;

            }catch (StaleElementReferenceException e){
                count++;
                if (count == 5){
                    throw e;
                }
            }
        }
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Social_Activities"
    )
    public void Sign_out(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='[ Sign out ]']")));
    }
}
