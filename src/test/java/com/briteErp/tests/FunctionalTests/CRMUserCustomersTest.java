package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CRMUserCustomersTest extends TestBase {

    @Test
    public void BRIT_2996()throws InterruptedException {

//1.1.1 Open the URL
//1.1.2 Login using valid username and password as CRM user.
//1.1.3 Click on CRM tab on top.
//1.1.4 Click on Customer.

        extentLogger=report.createTest("View Customers Page Test");
        extentLogger.info("Verifying that the CRM user can open the main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();


        extentLogger.info("Verifying to login with user credentials");
        pages.login().login(ConfigurationReader.getProperty("CRMUserEmail"), ConfigurationReader.getProperty("CRMUserPassword"));

        Thread.sleep(5000);
        extentLogger.info("Verifying that CRM user can click on CRM Module");
        pages.login().clickCRModule();

        Thread.sleep(5000);
        extentLogger.info("Verifying that CRM user can click on Customers page");
        pages.getCrmUserCustomersPage().customersLink.click();

        Thread.sleep(5000);
        extentLogger.info("Verify that CRM user is on the Customers page");
        Assert.assertTrue(pages.getCrmUserCustomersPage().getCustomersTitle().contains("Customers"));
        extentLogger.pass("Pass");



    }
}

