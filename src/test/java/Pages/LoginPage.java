package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
    private final String BASE_URL = "https://tut.by";


    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void logIn(String username, String password)
    {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.button.auth__enter")).click();

    }


    public void logOut(String username, String password){
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input.button.auth__enter")).click();
        driver.get("http://www.tut.by/?trnd=34428");
        driver.findElement(By.cssSelector("span.uname")).click();
        driver.findElement(By.linkText("Выйти")).click();
    }

    public boolean isLogOut(){
        boolean logOutIsTrue=false;
        if(driver.findElement(By.linkText("Войти")).isDisplayed()) logOutIsTrue=true;
        return  logOutIsTrue;
    }

    public boolean isLogIn(){
        boolean logInIsTrue=false;
        if(driver.findElement(By.cssSelector("span.uname")).isDisplayed()) logInIsTrue=true;
        return  logInIsTrue;
    }
}