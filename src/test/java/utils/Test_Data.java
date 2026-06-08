package utils;

import org.testng.annotations.DataProvider;

public class Test_Data {

    @DataProvider(name = "login_pass")
    public Object[][] data(){
        return new Object[][]{
                {"230103366", "toregulakhanvvv4442005"}
        };
    }
}
