package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "skip-link skip-account")
    public WebElement accountBotton;

    @FindBy(css = "#send2")
    public static WebElement loginButton;

    @FindBy(css ="#nav > ol > li.level0.nav-4.parent > a")
    public static WebElement homeAndDecorBotton;

    @FindBy(css ="#email")
    public static WebElement email;

    @FindBy(id ="pass")
    public static WebElement pass;

    @FindBy(css ="body > div > div.page > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(4) > a")
    public static WebElement decorativeAccentsBotton;

    @Step("Click Subcategory")
    public static void clickSubcategory() {
        homeAndDecorBotton.click();
        decorativeAccentsBotton.click();
    }

    @Step("Insert username and password")
    public static void setMailAndPass(String mail, String password) {
        email.click();
        email.clear();
        email.sendKeys(mail);
        pass.click();
        pass.clear();
        pass.sendKeys(password);
    }

    @Step("Click on login button")
    public static HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }

}