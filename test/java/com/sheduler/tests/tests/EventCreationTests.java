package com.sheduler.tests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase{
    @Test
    public void eventCreationOfRegisteredUserTest() throws InterruptedException {
        if (!app.event().isNavPanelPresent()) {
            app.user().defaultLogin();
        }
        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        Thread.sleep(10000);
        app.event().fillEventForm("Event", "1", 3, "50");
        app.event().saveEvent();

    }

    @Test
    public void eventCreationOfUnregisteredUserTest() throws InterruptedException {
        // preconditions for wizard
        app.event().tapOnPlusButton();
        app.event().tapOnPencilButton();
        Thread.sleep(1000);
        app.event().fillEventForm("Event", "1", 3, "50");
        app.event().saveEvent();

    }
    // tapOnPlusButton
    // tapOnPencilButton
    // fillEventForm
    // confirmEventCreation
    // isEventPresent

    // fab_main
    // fab_add_event
    // info_title_input
    // info_save_btn

}
