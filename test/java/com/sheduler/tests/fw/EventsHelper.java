package com.sheduler.tests.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

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


    public int getTotalEvents() {
        List<WebElement> ids = driver.findElements(By
                .id("row_container_main"));
        int idCount = ids.size();
        System.out.println("Total events quantity: " + idCount);
        return idCount;
    }


    // list_fr_recycler_view
    // //*[@resource-id='com.example.svetlana.scheduler:id/row_container_main']


    public void selectDate(String type, String month, String dayOfMonth) {
        if (!getSelectedMonth().equals(month)) {
            if (type.equals("past")) {
                swipeToRightUntilNeededMonth(month);

                if (!getSelectedDayOfMonth().equals(dayOfMonth)) {
                    swipeToRightUntilNeededDayOfMonth(dayOfMonth);
                }

            } else if (type.equals("future")) {
                swipeToLeftUntilNeededMonth(month);
                if (!getSelectedDayOfMonth().equals(dayOfMonth)) {
                    swipeToLeftUntilNeededDayOfMonth(dayOfMonth);
                }
            }
        } else if (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            if (type.equals("past")) {
                swipeToRightUntilNeededDayOfMonth(dayOfMonth);
            } else if (type.equals("future")) {
                swipeToLeftUntilNeededDayOfMonth(dayOfMonth);
            }
        }
    }

    private void swipeToLeftUntilNeededDayOfMonth(String dayOfMonth) {
        while (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedDayOfMonth();
        }
    }

    private void swipeToRightUntilNeededDayOfMonth(String dayOfMonth) {
        while (!getSelectedDayOfMonth().equals(dayOfMonth)) {
            moveElementToRight(By.id("info_viewPager"));
            getSelectedDayOfMonth();
        }
    }

    private void swipeToRightUntilNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)) {
            moveElementToRight(By.id("info_viewPager"));
            getSelectedMonth();
        }
    }

    private void moveElementToRight(By locator) {
        TouchAction action = new TouchAction(driver);
        //get activity points
        Dimension size = driver.manage().window().getSize();
        int leftPoint = (int) (size.width * 0.2);
        int rightPoint = (int) (size.width * 0.5);

//get Element's point
        WebElement element = driver.findElement(locator);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        action
                .longPress(PointOption.point(leftPoint, middleY))
                .moveTo(PointOption.point(rightPoint, middleY))
                .release()
                .perform();
    }

    public void moveElementToLeft(By locator) {
        TouchAction action = new TouchAction(driver);

        Dimension size = driver.manage().window().getSize();
        int leftPoint = (int) (size.width * 0.2);
        int rightPoint = (int) (size.width * 0.5);

        WebElement element = driver.findElement(locator);

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        action
                .longPress(PointOption.point(rightPoint, middleY))
                .moveTo(PointOption.point(leftPoint, middleY))
                .release()
                .perform();
    }

    private void swipeToLeftUntilNeededMonth(String month) {
        while (!getSelectedMonth().equals(month)) {
            moveElementToLeft(By.id("info_viewPager"));
            getSelectedMonth();
        }

    }

    private String getSelectedMonth() {
        WebElement selectedDate = driver.findElement(By.id("date_container_layout"));
        return selectedDate.findElement(By
                .xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']"))
                .getText();
    }

    private String getSelectedDayOfMonth() {
        WebElement selectedDate = driver.findElement(By.id("date_container_layout"));
        return selectedDate.findElement(By.xpath(".//*[@resource-id='com.example.svetlana.scheduler:id/row_day_number_txt']"))
                .getText();
    }

}



