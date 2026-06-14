package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverManager;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void openBrowser() {
        DriverManager.openBrowser();
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        DriverManager.closeBrowser();
    }
}
