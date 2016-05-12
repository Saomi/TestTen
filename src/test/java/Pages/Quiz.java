package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Quiz extends AbstractPage{
    private final String BASE_URL = "https://tut.by";


    public Quiz(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void Quiz()
    {
        driver.findElement(By.id("aid14883")).click();
        driver.findElement(By.name("send")).click();
    }
//true если проголосовал успешно либо уже голосовал
    public boolean isQuiz(){
        boolean QuizIsTrue=false;
           if ((driver.findElement(By.cssSelector("p.b-article-details > span")).getText().contains("голос")))
               QuizIsTrue = true;

        return  QuizIsTrue;
    }
}
