package letter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private final static Long TIMEOUT = 10L;
    private final WebDriver driver;

    By loginField = By.xpath("//input[@id='mailbox:login']");
    By passwordField = By.xpath("//input[@id='mailbox:password']");
    By loginButton = By.xpath("//input[@value='Войти']");
    By domainField = By.xpath("//select[@id='mailbox:domain']");
    By mailru = By.xpath("//option[contains(text(),'@mail.ru')]");





    public MainPage(WebDriver driver) {
        this.driver = driver;

        new WebDriverWait(driver, TIMEOUT, 1)
                .withMessage("Страничка не прогрузилась")
                .until(ExpectedConditions.titleContains("Mail.Ru: почта, поиск в интернете, новости, игры"));
    }



    public void inputLogin() {
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys("test_loz");
    }

    public void inputPassword() {

        driver.findElement(passwordField).sendKeys("Test123456");
    }

    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }

    public void inputDomain(){
        driver.findElement(domainField).click();
        driver.findElement(mailru).click();
    }




}
