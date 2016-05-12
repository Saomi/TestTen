package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search extends AbstractPage{
    private final String BASE_URL = "https://tut.by";


    public Search(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void Search(String searcworld)
    {
        driver.findElement(By.id("search_from_str")).clear();
        driver.findElement(By.id("search_from_str")).sendKeys(searcworld);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.id("search_5")).click();
    }

    public boolean isSearch(){
        boolean serInIsTrue=false;
        if(driver.findElement(By.cssSelector("div.b-search-note")).isDisplayed()) serInIsTrue=true;
        return  serInIsTrue;
    }

    public void SearchAuto(String mark,String model,String year)
    {
        driver.findElement(By.name("venders[0]")).click();
        new Select(driver.findElement(By.name("venders[0]"))).selectByVisibleText(mark);
        new Select(driver.findElement(By.name("models[0]"))).selectByVisibleText(model);
        new Select(driver.findElement(By.name("age_from[0]"))).selectByVisibleText(year);
        driver.findElement(By.cssSelector("input.search_auto__btn")).click();
        driver.findElement(By.linkText("Nissan Teana")).click();

        }

    public boolean isSearchAuto(){
        boolean serAInIsTrue=false;
        if(driver.findElement(By.xpath("(//a[contains(text(),'Характеристики')])[2]")).isDisplayed()) serAInIsTrue=true;
        return  serAInIsTrue;
    }
    }