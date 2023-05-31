import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {

    @DataProvider(name = "Positive Data")
    public Object[][] positiveDataTest() {
        return new Object[][] {
            {"4 + 5", "9"},
            {"1 - 5", "-4"},
            {"10 * 5", "50"},
            {"10 * 10", "100"},
            {"9 / 5", "1"}
        };
    }

    @DataProvider(name = "Negative Data")
    public Object[][] exceptionDataTest() {
        return new Object[][] {
            {"-14 + 5"},
            {"0 + 5"},
            {"14 - IV"},
            {"a + b"},
            {"14"},
            {" * 99"},
            {"1 / 0"},
            {"14 / "}
        };
    }

    @Test(dataProvider = "Positive Data")
    public void testCalc(String input, String result) throws Exception {
        Assert.assertEquals(result, Main.calc(input));
    }

    @Test(dataProvider = "Negative Data", expectedExceptions = { Exception.class })
    public void testCalcException(String input) throws Exception {
        Main.calc(input);
    }

    @Test
    public void testCalc2() {
        String input = "2 - 2";
        String signs = input.replaceAll("[^+\\-*\\/]", "");
        System.out.println(signs);
    }
}
