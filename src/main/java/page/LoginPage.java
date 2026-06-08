package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    By input_username = By.id("username");
    By input_password = By.id("password");
    By button_login = By.className("q-button");


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void openSite(){
        driver.get("https://my.sdu.edu.kz/");
    }

    public void login(String username, String password){
        String username_chek = driver.findElement(input_username).getAttribute("value");
        if(!username_chek.isEmpty()){

            WebElement username_clear = driver.findElement(input_username);
            username_clear.sendKeys(Keys.CONTROL+"a");
            username_clear.sendKeys(Keys.DELETE);
            username_clear.sendKeys(username);

            driver.findElement(input_password).sendKeys(password);

        }else {

            driver.findElement(input_username).sendKeys(username);

            driver.findElement(input_password).sendKeys(password);

        }

    }
}
