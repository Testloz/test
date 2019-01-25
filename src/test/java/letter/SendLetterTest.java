package letter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class SendLetterTest {
    private static WebDriver webDriver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://mail.ru");
    }


    @Test
    public void mailTest(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.inputLogin();
        mainPage.inputDomain();
        mainPage.inputPassword();
        mainPage.clickLoginButton();
        UserPage userPage = new UserPage(webDriver);
        userPage.clickWriteLetterButton();
        userPage.inputAdress();
        userPage.inputTheme();
        userPage.inputBody();
        userPage.clickSendButton();

    }



    @AfterClass
    public static void tearDown() {
               webDriver.quit();
    }

}
