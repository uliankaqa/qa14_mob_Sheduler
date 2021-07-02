package com.sheduler.tests.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EventsHelper extends HelperBase {
    public EventsHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isWizardTitlePresent(){
        return isElementPresent(By.id("wizard_settings_title"));
    }

    public boolean isNavPanelPresent(){
        return isElementPresent(By.id("nav_list_fr_container"));
    }

    public void tapOnPlusButton() {
        waitForElementAndTab(By.id("fab_main"),5);
    }

    public void tapOnPencilButton() {
        tap(By.id("fab_add_event"));
    }

    public void fillEventForm(String eventTitle, String eventType, int breaks, String wage) {
        swipeDayToLeft();
        type(By.id("info_title_input"), eventTitle);
        type(By.id("info_type_input"), eventType);
        hideKeyboard();
        if (breaks>0) {
            for (int i = 0; i < breaks; i++) {
                tapOnAddBreakButton();
            }
        }
        addWage(wage);
    }

    public void addWage(String wage) {
        tap(By.id("info_wage_edit"));
        type(By.id("info_wage_input"), wage);
        tap(By.id("info_wage_save"));
    }

    public void tapOnAddBreakButton() {
        tap(By.id("info_break_plus_btn"));
    }

    public void saveEvent() {
        tap(By.id("info_save_btn"));
    }

}
