package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.DriverManager;
import utils.Retry;
import utils.Test_Data;

public class HomePage_Test extends TestToMainPage{

    By nowrap = By.xpath("//td[@nowrap='nowrap']");
    By clsTd = By.className("clsTd");

    @Test(
            groups = "smoke",
            retryAnalyzer = Retry.class,
            priority = 1
    )
    public void print() {
        System.out.println("print all info about the user");

        System.out.println(DriverManager.driver.findElements(clsTd).get(0).getText() + " " + DriverManager.driver.findElements(nowrap).get(0).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(2).getText() + " " + DriverManager.driver.findElements(nowrap).get(1).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(4).getText() + " " + DriverManager.driver.findElements(nowrap).get(2).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(6).getText() + " " + DriverManager.driver.findElements(nowrap).get(3).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(8).getText() + " " + DriverManager.driver.findElements(nowrap).get(4).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(10).getText() + " " + DriverManager.driver.findElements(nowrap).get(5).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(12).getText() + " " + DriverManager.driver.findElements(nowrap).get(6).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(14).getText() + " " + DriverManager.driver.findElements(nowrap).get(7).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(16).getText() + " " + DriverManager.driver.findElements(nowrap).get(8).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(18).getText() + " " + DriverManager.driver.findElements(nowrap).get(9).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(20).getText() + " " + DriverManager.driver.findElements(nowrap).get(10).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(22).getText() + " " + DriverManager.driver.findElements(nowrap).get(11).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(25).getText() + " " + DriverManager.driver.findElements(nowrap).get(12).getText());
        System.out.println(DriverManager.driver.findElements(clsTd).get(27).getText() + " " + DriverManager.driver.findElements(nowrap).get(13).getText());

    }

}
