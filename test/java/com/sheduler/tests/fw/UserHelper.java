package com.sheduler.tests.fw;

import com.sheduler.tests.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.Random;

public class UserHelper extends HelperBase{

    public UserHelper(AppiumDriver driver){
        super(driver);
    }


    public void login(User user){
        waitForElement(By.id("log_email_input"), 10);
        type(By.id("log_email_input"), user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
        hideKeyboard();
        waitForElement(By.id("login_btn"), 10);
        tap(By.id("login_btn"));

    }

    public void defaultLogin(){
        login(new User().withEmail("ulia@gmail.com").withPassword("Ulia2021!"));
    }

    public void fillLoginForm(User user) {
        waitForElementAndType(By.id("log_email_input"), 5,user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
    }

    public void register() {
        Random random = new Random();
        int r = random.nextInt(1000);
        login(new User().withEmail("cd" + r + "@gmail.com").withPassword("Cdefj2021"));
    }

}
