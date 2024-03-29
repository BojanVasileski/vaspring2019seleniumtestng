package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalendarEventsPage extends NavigationBar{

    public CalendarEventsPage(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

}