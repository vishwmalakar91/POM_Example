package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Guru99_Pages.Home_Page;
import Guru99_Pages.Login;

public class TestLogin{
    WebDriver driver;
    Login objLogin;
    Home_Page objHomePage;
    
    @BeforeTest
    public void setup(){
    	System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }
    
    /* Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message*/
    
    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
    objLogin = new Login(driver);    //Create Login Page object
    String loginPageTitle = objLogin.getLoginTitle();    //Verify login page title
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
    objLogin.loginToGuru99("mgr123", "mgr!23");    //login to application
    objHomePage = new Home_Page(driver);    // go the next page
    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));    //Verify home page
    }}