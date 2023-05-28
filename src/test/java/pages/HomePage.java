package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id  ="Physical & Virtual Gift Cards")
    private static WebElement giftCards;

    @FindBy(id ="Decorative Accents")
    private static WebElement decorativeAccents;

    @FindBy(id = "product-collection-image-390")
    private static WebElement product1;

    @FindBy(id = "select-language")
    private static WebElement selectLanguage;

    @FindBy(id= "search_mini_form")
    private static WebElement searchBotton;

    @FindBy(css = "#header > div > div.skip-links > a.skip-link.skip-account")
    private static WebElement accountBotton;


    @FindBy(css = "#header-account > div > ul > li.last > a")
    private static WebElement logInBotton;

    @FindBy(css = "#header-account > div > ul > li.last > a")
    private static WebElement logOutBotton;

    @Step("Click To Login")
    public static void clickToLogin() {
        accountBotton.click();
        logInBotton.click();
    }

    @Step("Search and Click Product")
    public void searchAndClickProduct(String product) {
        giftCards.click();
        decorativeAccents.click();
        driver.findElement(By.id(product)).click();
        new ProductPage(driver);
    }

    @Step("Change Language")
    public static void changeLanguage(String Language) {
        selectLanguage.click();
        new Select(driver.findElement(By.id("select-language"))).selectByVisibleText(Language);
    }

    public void searchProduct(String product) {
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys(product);
        searchBotton.submit();
        driver.findElement(By.id(product)).click();
    }

    @Step("Logout")
    public static LoginPage logOut() {
        accountBotton.click();
        logOutBotton.click();
        return new LoginPage(driver);
    }

}
