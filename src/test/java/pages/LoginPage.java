package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#send2")
    public static WebElement loginButton;

    @FindBy(css = "#nav > ol > li.level0.nav-4.parent > a")
    public static WebElement homeAndDecorButton;

    @FindBy(css ="#email")
    public static WebElement email;

    @FindBy(id ="pass")
    public static WebElement pass;

    @FindBy(css = "#header > div > a > img.large")
    private static WebElement backToHome;

    @FindBy(css ="body > div > div.page > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(4) > a")
    public static WebElement decorativeAccentsButton;

    @FindBy(css ="body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div > div > div.page-title > h1")
    public static WebElement tittle;

    @Step("Back to Home")
    public static void backtoHome() {
        backToHome.click();
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

    @Step("Get title message")
    public static String getTitleMessage() {
        return tittle.getText();
    }

}