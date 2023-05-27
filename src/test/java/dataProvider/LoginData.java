package dataProvider;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "login")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"pruebafinal@hotmail.com", "prueba1"}
        };
    }
}
