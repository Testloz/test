package letter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {

    private final static Long TIMEOUT = 10L;
    private final WebDriver driver;

    By writeButton = By.xpath("//div/div/div/div/div[2]/div/a/i");
    By adressField = By.xpath("//textarea[2]");
    By themeField = By.xpath("//input[@name='Subject']");
    By bodyIframe = By.xpath(".//tr[@class='mceFirst mceLast']//iframe");
    By bodyField = By.xpath("//body[@id='tinymce']");
    By sendButton = By.xpath("//div[3]/div/div[2]/div/div/span");
    //By logoutButton = By.xpath("//a[@id='PH_logoutLink']");


    public UserPage(WebDriver driver) {
        this.driver = driver;

        new WebDriverWait(driver, TIMEOUT, 1)
                .withMessage("Страничка не прогрузилась")
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div/div/div[2]/div/a/i")));
    }


    public void clickWriteLetterButton (){

        driver.findElement(writeButton).click();
    }

    public void inputAdress (){

        driver.findElement(adressField).sendKeys("test_loz@mail.ru");
    }

    public void inputTheme (){

        driver.findElement(themeField).sendKeys("Тема письма");
    }

    public void inputBody (){
        driver.switchTo().frame(driver.findElement(bodyIframe));
        driver.findElement(bodyField).clear();
        driver.findElement(bodyField).sendKeys("Добрый день!");
        driver.switchTo().defaultContent();
    }

    public void clickSendButton (){
        driver.findElement(sendButton).click();
    }


}
