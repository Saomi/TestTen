package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SendNews extends AbstractPage{
    private final String BASE_URL = "http://auto.tut.by/tell_news";


    public SendNews(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void SendNews(String name,String call,String email,String text)
    {
        driver.findElement(By.name("unews_name")).clear();
        driver.findElement(By.name("unews_name")).sendKeys(name);
        driver.findElement(By.name("unews_phone")).clear();
        driver.findElement(By.name("unews_phone")).sendKeys(call);
        driver.findElement(By.name("unews_email")).clear();
        driver.findElement(By.name("unews_email")).sendKeys(email);
        driver.findElement(By.name("unews_body")).clear();
        driver.findElement(By.name("unews_body")).sendKeys(text);
        driver.findElement(By.name("unews_witness_name")).clear();
        driver.findElement(By.name("unews_witness_name")).sendKeys(text);
        driver.findElement(By.id("sbm-button")).click();
    }

    public boolean isSendNews(){
        boolean sendNewsInIsTrue=false;
        if(driver.findElement(By.cssSelector("div.b-success")).getText().contains("Спасибо, ваша новость была успешно отправлена")) sendNewsInIsTrue=true;
        return  sendNewsInIsTrue;
    }
}