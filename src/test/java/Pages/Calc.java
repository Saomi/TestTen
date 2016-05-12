package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Calc extends AbstractPage{
    private final String BASE_URL = "http://finance.tut.by/calcs/kredit";


    public Calc(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void Calc(String summa,String publ)
    {
        driver.findElement(By.name("summa_cred")).click();
        driver.findElement(By.name("summa_cred")).clear();
        driver.findElement(By.name("summa_cred")).sendKeys(summa);
        driver.findElement(By.name("srok")).click();
        driver.findElement(By.name("srok")).clear();
        driver.findElement(By.name("srok")).sendKeys(publ);
        driver.findElement(By.name("proc")).clear();
        driver.findElement(By.name("proc")).sendKeys(publ);
        driver.findElement(By.id("recalc")).click();
    }

    public boolean isCalc(){
        boolean CalcInIsTrue=false;
        if(driver.findElement(By.id("calc_result")).getText().contains("Ежемесячный платеж:")) CalcInIsTrue=true;
        return  CalcInIsTrue;
    }


    public void ComparisonDeposits(String sum,String USD,String payments,String year,String supplement)
    {
        driver.findElement(By.name("summa_cred1")).clear();
        driver.findElement(By.name("summa_cred1")).sendKeys(sum);
        new Select(driver.findElement(By.name("valuta1"))).selectByVisibleText(USD);
        new Select(driver.findElement(By.name("type_proc1"))).selectByVisibleText(payments);
        driver.findElement(By.id("pi1")).clear();
        driver.findElement(By.id("pi1")).sendKeys("12");
        driver.findElement(By.name("srok1")).clear();
        driver.findElement(By.name("srok1")).sendKeys(year);
        driver.findElement(By.name("proc1")).clear();
        driver.findElement(By.name("proc1")).sendKeys(year);
        driver.findElement(By.name("sum_dop1")).clear();
        driver.findElement(By.name("sum_dop1")).sendKeys(supplement);
        driver.findElement(By.id("recalc")).click();
    }

    public boolean isComparisonDeposits(){
        boolean CompDepositsInIsTrue=false;
        if(driver.findElement(By.cssSelector("td.calc-fbt-left")).isDisplayed()) CompDepositsInIsTrue=true;
        return  CompDepositsInIsTrue;
    }


    public void CalcMillion(String sum,String USD,String year,String supplement)
    {

        new Select(driver.findElement(By.name("valuta"))).selectByVisibleText(USD);
        driver.findElement(By.name("summa")).clear();
        driver.findElement(By.name("summa")).sendKeys(sum);
        driver.findElement(By.name("summa_first")).clear();
        driver.findElement(By.name("summa_first")).sendKeys(supplement);
        driver.findElement(By.name("summa_dop")).clear();
        driver.findElement(By.name("summa_dop")).sendKeys(year);
        driver.findElement(By.name("proc")).clear();
        driver.findElement(By.name("proc")).sendKeys(year);
        driver.findElement(By.id("pi")).clear();
        driver.findElement(By.id("pi")).sendKeys(year);
        driver.findElement(By.id("recalc")).click();


    }

    public boolean isCalcMillion(){
        boolean CalcMillionInIsTrue=false;
        if(driver.findElement(By.id("calc_result")).isDisplayed()) CalcMillionInIsTrue=true;
        return  CalcMillionInIsTrue;
    }
}