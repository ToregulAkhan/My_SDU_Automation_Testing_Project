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

public class Rules_and_Regulations_Page_Test extends BaseTest {
    WebDriverWait wait;

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Rules_and_Regulations(){
        DriverManager.driver.findElement(By.xpath("//a[text()='Rules and Regulations ']")).click();
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            dependsOnMethods = "Rules_and_Regulations"
    )
    public void Rules_and_Regulations_Test(){
        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By select = By.id("rGroup");

        String mainWindow = DriverManager.driver.getWindowHandle();

        String[] year = {
                "Academic",
                "Administrative",
                "Archive",
                "Science",
                "Social"};

        for (String option : year){
            term(select,option);

            if (option.equals("Academic")){

                By ru = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/UPufhLdkm3tX8cR9MzTGFBr3fUNxfd1Uoht2DXZY.pdf\"]");
                By en = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/xYBJq8WVDPFRqx287xhef10Wua3zssPwaAUta9jD.pdf\"]");
                By kz = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/Eqq5FzLOBIWegPbOebdIdO9jK0JEjtFzsZQ95e3K.pdf\"]");

                openPdf(ru, mainWindow);
                openPdf(en, mainWindow);
                openPdf(kz, mainWindow);

            }else if (option.equals("Administrative")){

                By ru = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/4pYgWouFvLjDAkOPPDtiGzcu32JmCUPgXrRKupaa.pdf\"]");
                By en = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/kX9CnE5bu04Dy6G1ekGp5vilo3IF6tch8ykwzwXy.pdf\"]");
                By kz = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/r6t2KWF7tMuNM27kKZ4e4UMTSsJZ73gLs7vPeyUR.pdf\"]");

                openPdf(ru, mainWindow);
                openPdf(en, mainWindow);
                openPdf(kz, mainWindow);

            }else if (option.equals("Archive")){

            }else if (option.equals("Science")){

                By ru = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/jh6nKZk10V9vMoUtXFlNiHDYlFybbPu3NHLVLYse.pdf\"]");
                By en = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/3JLlkyikSWWuMAful5MRrWYkJvKss7DfQ2tom0of.pdf\"]");
                By kz = By.xpath("//a[@href=\"https://files.sdu.edu.kz/pms/rule-attachments/Tk8ZvenpTnAWemKi4Q7HtjV7juRdIGtqrh078iv3.pdf\"]");

                openPdf(ru, mainWindow);
                openPdf(en, mainWindow);
                openPdf(kz, mainWindow);

            }else if (option.equals("Social")){

                By ru = By.xpath("//a[@href=\"https://oldpms.sdu.edu.kz/common/download/73852.pdf\"]");
                By en = By.xpath("//a[@href=\"https://oldpms.sdu.edu.kz/common/download/EQUALITY-DIVERSITY-AND-INCLUSIVITY-POLICY.pdf\"]");
                By kz = By.xpath("//a[@href=\"https://oldpms.sdu.edu.kz/common/download/33026.pdf\"]");

                openPdf(ru, mainWindow);
                openPdf(en, mainWindow);
                openPdf(kz, mainWindow);

            }


        }
    }

    public void term(By select, String option){
        int count = 0;

        while (count < 5){
            try {

                WebElement element_select = wait.until(ExpectedConditions.elementToBeClickable(select));
                Select s = new Select(element_select);
                s.selectByVisibleText(option);

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

    public void openPdf(By pdf, String mainWindow){
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(pdf));
        link.click();

        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String handle : DriverManager.driver.getWindowHandles()){
            if (!handle.equals(mainWindow)){
                DriverManager.driver.switchTo().window(handle);
                break;
            }
        }

        DriverManager.driver.close();

        wait.until(d -> d.getWindowHandles().size() == 1);

        DriverManager.driver.switchTo().window(mainWindow);
    }
}
