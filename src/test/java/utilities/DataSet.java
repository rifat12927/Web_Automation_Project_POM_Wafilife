package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name="invaliddata")
    public static Object invalidDataSet(){
        Object[] [] dataset={
                {"","","Error: ইউজার নাম প্রয়োজন"},
                {"rif420","","Error: The password field is empty."},
                {"","12345678","Error: ইউজার নাম প্রয়োজন"},
                {"username","password","Error: The username username is not registered on this site. If you are unsure of your username, try your email address instead."},
                {"username","12345678","Error: The username username is not registered on this site. If you are unsure of your username, try your email address instead."},
                {"rif420","password","Error: The password you entered for the username rif420 is incorrect. Lost your password?"}
        };
        return dataset;
    }
}
