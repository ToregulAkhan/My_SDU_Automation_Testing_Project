package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverManager;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void open(){
        DriverManager.openBrowser();
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        DriverManager.closeBrowser();
    }
}
