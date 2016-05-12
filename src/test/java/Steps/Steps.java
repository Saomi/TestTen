package Steps;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;




public class Steps {
    private WebDriver driver;
    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    public void closeDriver()
    {
        driver.close();
    }

    public void logInTUT(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://tut.by");
        loginPage.logIn(username, password);
    }
    public boolean isLoggedIn()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogIn());
    }
    public void logOutTUT(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://tut.by");
        loginPage.logOut(username,password);
    }
    public boolean isLoggedOut()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogOut());
    }

    public void SearchTUT(String searcword){
        Search search = new Search(driver);
        search.openPage("https://tut.by");
        search.Search(searcword);
    }
    public boolean isSearched()
    {
        Search search = new Search(driver);
        return (search.isSearch());
    }

    public void QuizTUT(){
        Quiz quiz = new Quiz(driver);
        quiz.openPage("https://tut.by");
        quiz.Quiz();
    }
    public boolean isQuized()
    {
        Quiz quiz = new Quiz(driver);
        return (quiz.isQuiz());
    }


    public void CalcTUT(String summa,String publ){
        Calc calc = new Calc(driver);
        calc.openPage("http://finance.tut.by/calcs/kredit");
        calc.Calc(summa,publ);
    }
    public boolean isCalc()
    {
        Calc calc = new Calc(driver);
        return (calc.isCalc());
    }

    public void RecallTUT(String username,String password,String text){
        Recall recall = new Recall(driver);
        recall.openPage("http://finance.tut.by/banks/alfa");
        recall.Recall(username,password,text);
    }
    public boolean isRecall()
    {
        Recall recall = new Recall(driver);
        return (recall.isRecall());
    }

    public void SendNewsTUT(String name,String call,String email,String text){
        SendNews sendNews = new SendNews(driver);
        sendNews.openPage("http://auto.tut.by/tell_news");
        sendNews.SendNews(name,call,email,text);
    }
    public boolean isSendNews()
    {
        SendNews sendNews = new SendNews(driver);
        return (sendNews.isSendNews());
    }

    public void ComparisonDepositsTUT(String sum,String USD,String payments,String year,String supplement){
        Calc comparisondeposits = new Calc(driver);
        comparisondeposits.openPage("http://finance.tut.by/calcs/sravnenie_depozitov/");
        comparisondeposits.ComparisonDeposits(sum,USD,payments,year,supplement);
    }
    public boolean isComparisonDeposits()
    {
        Calc comparisondeposits = new Calc(driver);
        return (comparisondeposits.isComparisonDeposits());
    }

    public void SearchAutoTUT(String mark,String model,String year){
        Search searchauto = new Search(driver);
        searchauto.openPage("https://tut.by");
        searchauto.SearchAuto(mark,model,year);
    }
    public boolean isSearchAuto()
    {
        Search searchauto = new Search(driver);
        return (searchauto.isSearchAuto());
    }

    public void CalcMillionTUT(String sum,String USD,String year,String supplement){
        Calc calcmillion = new Calc(driver);
        calcmillion.openPage("http://finance.tut.by/calcs/stat_millionerom/");
        calcmillion.CalcMillion(sum,USD,year,supplement);
    }
    public boolean isCalcMillion()
    {
        Calc calcmillion = new Calc(driver);
        return (calcmillion.isCalcMillion());
    }

    }


