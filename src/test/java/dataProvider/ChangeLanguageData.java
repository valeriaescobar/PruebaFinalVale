package dataProvider;

import org.testng.annotations.DataProvider;

public class ChangeLanguageData {

    @DataProvider(name = "changelanguage")
    public static Object[][] getLanguageData() {
        return new Object[][]{
                {"English"},
                {"French"},
        };
    }

}
