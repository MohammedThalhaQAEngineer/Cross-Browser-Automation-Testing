package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        driver = DriverFactory.getDriver(browser);
        driver.get("https://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        loginPage.login(username, password);
        // Add assertions here
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
            {"user1", "password1"},
            {"user2", "password2"}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
