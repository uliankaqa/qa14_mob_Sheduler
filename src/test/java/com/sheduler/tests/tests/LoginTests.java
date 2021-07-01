package com.sheduler.tests.tests;

import com.sheduler.tests.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){

        app.user().login(new User().withEmail("ulitruli@gmail.com").withPassword("Qa14!ulia"));
        //Assert.assertTrue(app.user().isElementPresent(By.id("")));
    }
}
