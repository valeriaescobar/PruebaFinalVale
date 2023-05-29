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

    @FindBy(css ="body > div > div.page > div.main-container.col1-layout > div > div > div > ul > li:nth-child(1) > a > img")
    private static WebElement giftCards;

    @FindBy(css ="body > div > div.page > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(4) > a > img")
    private static WebElement decorativeAccents;

    @FindBy(id = "select-language")
    private static WebElement selectLanguage;

    @FindBy(id= "search_mini_form")
    private static WebElement searchBotton;

    @FindBy(css = "#header > div > div.skip-links > a.skip-link.skip-account")
    private static WebElement accountBotton;


    @FindBy(css = "#header-account > div > ul > li.last > a")
    private static WebElement logInBotton;


    @FindBy(css = "#search")
    private static WebElement searchBar;


    @FindBy(css ="body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > h2 > a")
    private static WebElement product3;

    @Step("Click To Login")
    public static void clickToLogin() {
        accountBotton.click();
        logInBotton.click();
    }


    @Step("Search and Click Product")
    public void searchAndClickProduct() {
        giftCards.click();
        decorativeAccents.click();
        product3.click();
        new ProductPage(driver);
    }

    @Step("Change Language")
    public static void changeLanguage(String Language) {
        selectLanguage.click();
        new Select(driver.findElement(By.id("select-language"))).selectByVisibleText(Language);
    }

    public static void searchProduct(String product) {
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(product);
        searchBotton.submit();
    }

}
