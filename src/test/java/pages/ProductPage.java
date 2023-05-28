package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "product-collection-image-390")
    private static WebElement product;

    @FindBy(id = "Add to Cart")
    private static WebElement addToCartButton;

    @FindBy(id ="Add to Wishlist")
    private static WebElement addWishlistBotton;

    @FindBy(css = "body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span")
    private static WebElement wishListMessage;

    @FindBy(css = "body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1")
    private static WebElement productTitle;

    @Step("Add Product to Wish List")
    public static void addWishlistProduct () {
        addWishlistBotton.click();
    }

    @Step("Add to Cart")
    public void addToCart() {
        addToCartButton.click();
    }

    @Step("Get wishlist message")
    public static String getWishListMessage() {
        return wishListMessage.getText();
    }

    @Step("Get Tittle Product")
    public static String getTitleProductMessage() {
        return productTitle.getText();
    }
}
