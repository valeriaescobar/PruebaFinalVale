package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubCategoryPage extends BasePage{
    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="product-collection-image-389")
    private static WebElement product3;

    @Step("Click to Product")
    public static ProductPage clickToProduct() {
        product3.click();
        return new ProductPage(driver);
    }

}
