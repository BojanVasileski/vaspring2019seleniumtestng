package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VyTrackUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCalendarPagesTests extends TestBase {
    @BeforeMethod
    public void setUpMethod2(){
        driver.get(ConfigurationReader.get("vy_url"));

    }

    @Test
    public void repeatOptionsTest(){
        String username = ConfigurationReader.get("sales_username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.selectMenuOption("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        VyTrackUtils.waitForUIOverlay();
        calendarEventsPage.createCalendarEvent.click();

        VyTrackUtils.waitForUIOverlay();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        String selectedValue = createCalendarEventsPage.repeatOptionsList().getFirstSelectedOption().getText();

        System.out.println(selectedValue);

        Assert.assertEquals(selectedValue,"Daily");
    }
}
