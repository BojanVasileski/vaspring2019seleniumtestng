package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMBritePage {
    public CRMBritePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div/button[@type='button'][@data-view-type='pivot']")
    public WebElement pivot;

    @FindBy(xpath = "//div/button[@type='button'][@data-view-type='list']")
    public WebElement list;
}
