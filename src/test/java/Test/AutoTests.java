package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Steps.Steps;

public class AutoTests {
    private Steps steps;
    private final String USERNAME = "automation_test";
    private final String PASSWORD = "automation_test1";
    private final String searchworld = "концерт";
    private final String summa = "10000000";
    private final String publ = "12";
    private final String TEXT = "TEST NG";
    private final String call = "+375251111111";
    private final String email = "automation_test@tut.by";
    private final String mark = "Nissan";
    private final String model = "Teana";
    private final String year = "До 4 лет";
    private final String USD = "USD";
    private final String payments = "Ежеквартальная";
    private final String supplement = "1000";



    @BeforeMethod(description = "Init Browser")
    public void setUp(){
        steps=new Steps();
        steps.initBrowser();
    }

//вход
    @Test(description = "Login to TUT.BY")
    public void logInTUT() {
        steps.logInTUT(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
    }
//выход
    @Test(description = "LogOut to TUT.BY")
    public void logOutTUT(){
        steps.logOutTUT(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedOut());
    }
//поиск
    @Test(description = "Search TUT.BY")
    public void SearchTUT(){
        steps.SearchTUT(searchworld);
        Assert.assertTrue(steps.isSearched());
    }
 //опрос
    @Test(description = "Quiz TUT.BY")
    public void QuizTUT(){
        steps.QuizTUT();
        Assert.assertTrue(steps.isQuized());
    }

//кредитный калькулятор
    @Test(description = "Calc TUT.BY")
    public void CalcTUT(){
        steps.CalcTUT(summa,publ);
        Assert.assertTrue(steps.isCalc());
    }

 //отзыв
    @Test(description = "Recall TUT.BY")
    public void RecallTUT(){
        steps.RecallTUT(USERNAME,PASSWORD,TEXT);
        Assert.assertTrue(steps.isRecall());
    }
  //отправить новость в редакцию
    @Test(description = "SendNews TUT.BY")
    public void SendNews(){
        steps.SendNewsTUT(USERNAME,call,email,TEXT);
        Assert.assertTrue(steps.isSendNews());
    }
    //поиск авто
    @Test(description = "SearchAuto TUT.BY")
    public void SearchAutoTUT(){
        steps.SearchAutoTUT(mark,model,year);
        Assert.assertTrue(steps.isSearchAuto());
    }

    //Сравнение депозитов
    @Test(description = "ComparisonDeposits TUT.BY")
    public void ComparisonDepositsTUT(){
        steps.ComparisonDepositsTUT(summa,USD,payments,publ,supplement);
        Assert.assertTrue(steps.isComparisonDeposits());
    }
    //калькулятор когда я стану миллионером
    @Test(description = "CalcMillion TUT.BY")
    public void CalcMillionTUT(){
        steps.CalcMillionTUT(summa,USD,publ,supplement);
        Assert.assertTrue(steps.isCalcMillion());
    }

}
