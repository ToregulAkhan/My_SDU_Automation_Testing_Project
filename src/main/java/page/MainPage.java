package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    By sdu_image = By.xpath("//img[@title='SDU University']");

    public MainPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean mainPageIsOpened(){
        return driver.findElement(sdu_image).isDisplayed();
    }
}
