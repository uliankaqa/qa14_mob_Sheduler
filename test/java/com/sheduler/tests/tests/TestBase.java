package com.sheduler.tests.tests;

import com.sheduler.tests.fw.AppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {
    protected static AppManager app = new AppManager();
    /*{
      "platformName": "Android",
      "platformVersion": "8.0.0",
      "deviceName": "qa14_Android",
      "appPackage": "com.example.svetlana.scheduler",
      "appActivity": ".presentation.splashScreen.SplashScreenActivity",
      "app": "/Users/qa/Documents/Testing_mobil/v.0.0.3.apk"
    }*/
    @BeforeMethod
    public void setUp() throws MalformedURLException {

        app.init();

    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }

}
