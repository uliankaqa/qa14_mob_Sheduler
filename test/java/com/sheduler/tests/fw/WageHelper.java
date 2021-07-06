package com.sheduler.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WageHelper extends HelperBase{

    public WageHelper(AppiumDriver driver) {
        super(driver);
    }

    public void chooseWage(String currency, String wage) {
        tap(By.id("wizard_settings_currency_arrow"));
        // selectCurrency(c);
        selectCurrency1(currency);

        tap((By.id("wizard_settings_wage_arrow")));
        type(By.id("wage_dialog_input"), wage);
        tap(By.id("wage_dialog_ok_btn"));
        tap(By.id("wizard_settings_next"));


    }

    public void selectCurrency(int c) {

        List<WebElement> currency = driver.findElements(By
                .xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_root']"));
        currency.get(c).click();

    }

    public void selectCurrency1(String currency) {
        if (!getSelectedCurrency().equals(currency)){
            swipeUp();
            tap(By.xpath("//android.widget.TextView[@text='" + currency+ "']"));
        }
    }

    private String getSelectedCurrency() {
        WebElement selectedCurrency = driver.findElement(By
                .xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_root']"));
        return selectedCurrency.findElement(By
                .xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/currency_row_title']")).getText();
    }

}
