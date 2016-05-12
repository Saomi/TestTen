package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Recall extends AbstractPage{
    private final String BASE_URL = "http://finance.tut.by/banks/alfa";


    public Recall(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void Recall(String username,String password,String text)
    {
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.cssSelector("div.i-holder > input[name=\"login\"]")).clear();
        driver.findElement(By.cssSelector("div.i-holder > input[name=\"login\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("div.i-holder > input[name=\"password\"]")).clear();
        driver.findElement(By.cssSelector("div.i-holder > input[name=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("div.b-auth-f > form.b-auth-content > div.b-hold > input.button")).click();
        driver.findElement(By.name("comment")).clear();
        driver.findElement(By.name("comment")).sendKeys(text);
        driver.findElement(By.cssSelector("#main_controls > input.button")).click();
    }

    public boolean isRecall(){
        boolean recInIsTrue=false;
        if(driver.findElement(By.cssSelector("div.b-success")).getText().contains("Комментарий получен, он отобразится после проверки модератором")) recInIsTrue=true;
        return  recInIsTrue;
    }
}