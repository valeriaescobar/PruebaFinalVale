package scripts;

import dataProvider.LoginData;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SubCategoryPage;
import utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddProductWishList {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Constants.urlBase);
    }

    @Test (dataProvider = "login", dataProviderClass = LoginData.class)
    public static void addProductWishList (String mail, String password) {

        String expectedWishListMessage = "Stone Salt and Pepper Shakers has been added to your wishlist. Click here to continue shopping.";

        HomePage homePage = new HomePage(driver);
        HomePage.clickToLogin();
        LoginPage.setMailAndPass(mail, password);
        LoginPage.clickLoginButton();
        LoginPage.clickSubcategory();
        SubCategoryPage.clickToProduct();
        ProductPage.addWishlistProduct();
        assertEquals(ProductPage.getWishListMessage(), expectedWishListMessage);
        takeScreenshot();
    }

    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Exception while closing the driver " + e.getMessage());
        }
    }

    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public static byte[] takeScreenshot() {
        byte[] image = new byte[0];
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return image;
    }
}
