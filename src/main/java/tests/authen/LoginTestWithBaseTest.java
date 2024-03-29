package tests.authen;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.models.LoginCred;
import test_flows.authentication.LoginFlow;
import tests.BaseTest;

public class LoginTestWithBaseTest extends BaseTest {
    @Test(dataProvider = "loginCredData")
    public void testLogin(LoginCred loginCred){
                LoginFlow loginFlow = new LoginFlow(getDriver(), loginCred.getEmail(), loginCred.getPassword());
                loginFlow.gotoLoginScreen();
                loginFlow.login();
                loginFlow.verifyLogin();
    }


    @DataProvider
    public LoginCred[] loginCredData(){
        String filePath = "\\src\\main\\java\\test_data\\authen\\LoginCreds.json";
        return DataObjectBuilder.buildDataObject(filePath, LoginCred[].class);

    }

}
