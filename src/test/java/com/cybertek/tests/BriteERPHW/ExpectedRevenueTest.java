package com.cybertek.tests.BriteERPHW;

import com.cybertek.pages.CRMBritePage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BriteERPUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ExpectedRevenueTest extends TestBase {
    @BeforeMethod
    public void setUp2(){
        Driver.get().get("http://54.148.96.210/web/login");
        BriteERPUtils.login(Driver.get(), ConfigurationReader.get("Manager5_username"),ConfigurationReader.get("Manager5_password"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


    @Test(priority = 1, description = "Verify that second opportunity " +
            "Expected Revenue value on the Pivot board should be the" +
            " same as the Expected revenue on the list board")
    public void pivotListTet(){
        extentLogger = report.createTest("PivotAndListRevenueTest");

        extentLogger.info("Selecting CRM module");
        BriteERPUtils.selectModule("CRM");

        CRMBritePage crmBritePage = new CRMBritePage();

        extentLogger.info("Waiting for element to appear");
        wait.until(ExpectedConditions.visibilityOf(crmBritePage.pivot));

        extentLogger.info("Selecting Pivot view");
        crmBritePage.pivot.click();

        extentLogger.info("Setting Opportunity mode");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//th[text()='Total']")));
        Driver.get().findElement(By.xpath("//th[text()='Total']")).click();
        wait.until(ExpectedConditions.visibilityOf(Driver.get().findElement(By.xpath("//a[@href='#'][contains(text(),'Opportunity')]"))));
        Driver.get().findElement(By.xpath("//a[@href='#'][contains(text(),'Opportunity')]")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@class='o_pivot_cell_value text-right hidden-xs'][contains(text(),'10.0')]")));
        String pivotRevenueValue = Driver.get().findElement(By.xpath("//td[@class='o_pivot_cell_value text-right hidden-xs'][contains(text(),'10.0')]")).getText();

        extentLogger.info("Waiting for element to appear");
        wait.until(ExpectedConditions.visibilityOf(crmBritePage.list));

        extentLogger.info("Selecting List view");
        crmBritePage.list.click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@class='o_data_cell o_list_number'][contains(text(),'10.0')][1]")));
        String listRevenueValue = Driver.get().findElement(By.xpath("//td[@class='o_data_cell o_list_number'][contains(text(),'10.0')][1]")).getText();

        Assert.assertEquals(listRevenueValue,pivotRevenueValue);
    }

    @Test(priority = 2, description = "Verify total price is sum off all orportunity prices")
    public void totalPivotTest(){
        extentLogger = report.createTest("PivotAndListRevenueTest");

        extentLogger.info("Selecting CRM module");
        BriteERPUtils.selectModule("CRM");

        CRMBritePage crmBritePage = new CRMBritePage();

        extentLogger.info("Waiting for element to appear");
        wait.until(ExpectedConditions.visibilityOf(crmBritePage.pivot));

        extentLogger.info("Selecting Pivot view");
        crmBritePage.pivot.click();

        extentLogger.info("Setting Opportunity mode");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//th[text()='Total']")));
        Driver.get().findElement(By.xpath("//th[text()='Total']")).click();
        wait.until(ExpectedConditions.visibilityOf(Driver.get().findElement(By.xpath("//a[@href='#'][contains(text(),'Opportunity')]"))));
        Driver.get().findElement(By.xpath("//a[@href='#'][contains(text(),'Opportunity')]")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[@class='o_pivot_cell_value text-right'][contains(text(),'311.00')]")));
        String exp = "311.00";
        String acc = Driver.get().findElement(By.xpath("//td[@class='o_pivot_cell_value text-right'][contains(text(),'311.00')]")).getText();

        Assert.assertEquals(exp,acc);

    }



}
