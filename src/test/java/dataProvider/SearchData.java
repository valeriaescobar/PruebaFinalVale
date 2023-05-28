package dataProvider;

import org.testng.annotations.DataProvider;
public class SearchData {
    @DataProvider(name = "product")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"Stone Salt and Pepper Shakers"}
        };
    }
}
