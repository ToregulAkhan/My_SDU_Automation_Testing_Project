package tests.Tests_information;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.TestToMainPage;
import utils.DriverManager;
import utils.Retry;

import java.sql.Driver;
import java.time.Duration;

public class Curricula_Page_Test extends TestToMainPage {

    WebDriverWait wait;

    By curricula = By.xpath("//a[text()='Curricula ']");

    private void selectYearWithRetry(By selectBy, By showBtn, String year) {
        int attempts = 0;
        while (attempts < 10) {
            try {
                WebElement selectElement = wait.until(
                        ExpectedConditions.elementToBeClickable(selectBy)
                );
                new Select(selectElement).selectByVisibleText(year);

                wait.until(
                        ExpectedConditions.elementToBeClickable(showBtn)
                ).click();

                return; // success
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 10) throw e;
            }
        }
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void Curricula_test(){
        DriverManager.driver.findElement(curricula).click();
    }

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 2
    )
    public void c_10029() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='10029']")).click();

    }

    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "c_10029"
    )
    public void c_10020_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {"Choose","2026","2025","2024","2023","2022"};

        for (String year : years) {

            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//__________________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 3
    )
    public void CPDI_DLD() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='CPDI_DLD']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "CPDI_DLD"
    )
    public void CPDI_DLD_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {"Choose","2023","2022","2021"};

        for (String year : years) {

            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//__________________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 4
    )
    public void DEP_COMP_SCI() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_COMP_SCI']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_COMP_SCI"
    )
    public void DEP_COMP_SCI_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012","2011","2010","2009","2008",
                "2007","2006","2005","2004","2003","2002","2001"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//__________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 5
    )
    public void DEP_ECO_BUS() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_ECO_BUS']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_ECO_BUS"
    )
    public void DEP_ECO_BUS_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012","2011","2010","2009","2008",
                "2007","2006","2005","2004","2003","2002","2001"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 6
    )
    public void DEP_HUMANITIES() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_HUMANITIES']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_HUMANITIES"
    )
    public void DEP_HUMANITIES_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 7
    )
    public void DEP_INF_SYS() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_INF_SYS']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_INF_SYS"
    )
    public void DEP_INF_SYS_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012","2011","2010","2009","2008",
                "2007","2006","2005","2004","2003","2002","2001"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 8
    )
    public void DEP_JURIS() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_JURIS']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_JURIS"
    )
    public void DEP_JURIS_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 9
    )
    public void DEP_LANG_EDU() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_LANG_EDU']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_LANG_EDU"
    )
    public void DEP_LANG_EDU_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012","2011","2010","2009","2008",
                "2007","2006","2005","2004","2003","2002","2001"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 10
    )
    public void DEP_MATH() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_MATH']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_MATH"
    )
    public void DEP_MATH_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012","2011","2010","2009","2008",
                "2007","2006","2005","2004","2003","2002","2001"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 11
    )
    public void DEP_PED() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_PED']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_PED"
    )
    public void DEP_PED_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012","2011","2010","2009","2008",
                "2007","2006","2005","2004","2003","2002","2001"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 12
    )
    public void DEP_SOC_SCI() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='DEP_SOC_SCI']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "DEP_SOC_SCI"
    )
    public void DEP_SOC_SCI_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020","2019","2018","2017","2016","2015",
                "2014","2013","2012","2011","2010"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 13
    )
    public void FOUNDATION() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='FOUNDATION']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "FOUNDATION"
    )
    public void FOUNDATION_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

//_____________________________________________________________________________________________________________

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 14
    )
    public void MDE_CENTER() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        DriverManager.driver.findElement(By.xpath("//a[text()='MDE_CENTER']")).click();

    }
    @Test(
            retryAnalyzer = Retry.class,
            dependsOnMethods = "MDE_CENTER"
    )
    public void MDE_CENTER_test() {

        wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        By selectBy = By.id("ysem");
        By show = By.className("btn");

        String[] years = {
                "Choose","2026","2025","2024","2023","2022",
                "2021","2020"};

        for (String year : years) {
            selectYearWithRetry(selectBy, show, year);

            if (year.equals("Choose")) {
                wait.until(ExpectedConditions.alertIsPresent());
                DriverManager.driver.switchTo().alert().accept();
            }

            wait.until(
                    ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(selectBy)
                    )
            );
        }

        By goBack = By.xpath("//a[.//i[text()='Go back to department list']]");
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(goBack)).click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }
}
