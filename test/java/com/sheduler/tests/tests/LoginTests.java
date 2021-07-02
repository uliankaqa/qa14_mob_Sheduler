package com.sheduler.tests.tests;

import com.sheduler.tests.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void registrationPositiveTest(){

        app.user().login(new User().withEmail("ulia@gmail.com").withPassword("Ulia2021!"));
        Assert.assertTrue(app.event().isWizardTitlePresent());
    }

    @Test
    public void loginPositiveTest(){

        app.user().login(new User().withEmail("ulia@gmail.com").withPassword("Ulia2021!"));
        Assert.assertTrue(app.event().isNavPanelPresent());
    }
}
