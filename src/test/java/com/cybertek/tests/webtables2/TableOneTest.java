package com.cybertek.tests.webtables2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Complete the implementation of methods.
 * All of the methods are about the first web table
 * from the http://practice.cybertekschool.com/tables
 * Run the test following any method to test it
 */
public class TableOneTest extends TestBase {

    @BeforeMethod
    public void setUpMethodSubClass() {
        driver.get("http://practice.cybertekschool.com/tables");
    }


    /**
     * method that returns the number of rows including headers in table 1
     *
     * @return
     */
    public int getRowCount() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));


        return rows.size();

    }

    @Test
    public void getRowCountTest() {

        assertEquals(getRowCount(), 5, "Number of rows did not match");
    }

    /**
     * method that returns the number of columns in table 1
     *
     * @return
     */
    public int getColCount() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        return columns.size();
    }

    @Test
    public void getColCountTest() {
        assertEquals(getColCount(), 6, "Number of columns did not match");
    }

    /**
     * method that returns the size of the table 1
     *
     * @return
     */
    public int[] getTableSize() {
        int[] tableSize = new int[2];
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        tableSize[0] = rows.size();
        tableSize[1] = columns.size();
        return tableSize;
    }

    @Test
    public void getTableSizeTest() {
        int[] expectedSize = new int[]{5, 6};
        assertEquals(getTableSize(), expectedSize, "Table size did not match");
    }

    /**
     * method that returns all headers in table 1
     *
     * @return
     */
    public List<WebElement> getHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));

        return headers;
    }

    @Test
    public void getHeadersTest() {
        List<String> expectedHeaders = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<String> actualHeaders = BrowserUtils.getElementsText(getHeaders());
        assertEquals(actualHeaders, expectedHeaders, "Headers did not match");

    }

    /**
     * method that returns all cells under given column in table 1
     *
     * @param colName
     * @return
     */
    public List<WebElement> getCellsInColumn(String colName) {
        int col = 0;
        List<WebElement> result = new ArrayList<>();


        for(int i= 1;i<=6;i++){
           if( driver.findElement(By.xpath("//table[@id='table1']/thead//th["+i+"]")).getText().equals(colName)){
               col=i;
           }
        }

        for (int i = 1; i <= 4; i++) {
            result.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+col+"]")));
        }
        //table[@id='table1']/thead//th[5]
        //table[@id='table1']/tbody/tr[1]/td[5]

        return result;

    }


    @Test
    public void getCellsInColumnTest() {
        List<String> expectedLastNames = Arrays.asList("Smith", "Bach", "Doe", "Conway");
        List<String> actualLastNames = BrowserUtils.getElementsText(getCellsInColumn("Last Name"));

        assertEquals(actualLastNames, expectedLastNames, "First names did not match");

        List<String> expectedFirstNames = Arrays.asList("John", "Frank", "Jason", "Tim");
        List<String> actualFirstNames = BrowserUtils.getElementsText(getCellsInColumn("First Name"));

        assertEquals(actualFirstNames, expectedFirstNames, "First names did not match");


    }





}