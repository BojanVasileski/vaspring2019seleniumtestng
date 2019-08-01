package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehiclePage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VyTrackUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class VehiclePageTests extends TestBase {
    @BeforeMethod
    public void setUp2(){
        driver.get(ConfigurationReader.get("vy_url"));
        //creating a new page object and using it
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("password"));

    }

    @Test
    public void testFirstHeaderOption(){

        //create and use object in the same line, this objest will not be saved
        new DashboardPage().selectMenuOption("Fleet","Vehicles");

        //verify that first coll name is license plate
        String expectedCol = "LICENSE PLATE";

        VehiclePage vehiclePage = new VehiclePage();
        BrowserUtils.waitFor(2);

        WebElement firstColumn = vehiclePage.gridHeaders.get(0);

        Assert.assertEquals(firstColumn.getText(),expectedCol);


    }

    @Test
    public void removeGridHeaderTest(){
        new DashboardPage().selectMenuOption("Fleet","Vehicles");

        VehiclePage vehiclePage = new VehiclePage();
        VyTrackUtils.waitForUIOverlay();
        vehiclePage.gridSettings.click();

        WebElement licensePlateCh = vehiclePage.gridSettingsCheckbox("License Plate");

        Assert.assertTrue(licensePlateCh.isSelected(),"Checkbox should be checked");
        licensePlateCh.click();

        List<WebElement> allGridHeaders = vehiclePage.gridHeaders;

        for (WebElement element : allGridHeaders) {
            if (element.getText().equals("LICENSE PLATE")) {
                Assert.fail("LICENSE PLATE should not be displayed");

            }
        }
    }


}
