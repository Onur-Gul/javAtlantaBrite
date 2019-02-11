package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;


public class CRMUserCustomersTest extends TestBase {

    @Test
    public void viewCustomerPage() throws InterruptedException {
    //1.1. Verify that CRM user can click on the Customers tab.
    //Test case # BRIT_2996
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

        extentLogger.info("Verify that search box is cleaned.");
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();

        Thread.sleep(20000);
        extentLogger.info("Verifying that CRM user can click on Customers page");
        pages.getCrmUserCustomersPage().customersLink.click();

       Thread.sleep(5000);
        extentLogger.info("Verify that CRM user is on the Customers page");
        Assert.assertTrue(pages.getCrmUserCustomersPage().getCustomersTitle().contains("Customers"));
        System.out.println(pages.getCrmUserCustomersPage().getCustomersTitle());
        extentLogger.pass("Pass");

    }

    @Test (description = "BRIT-2998")

    public void createNewCustomer() throws InterruptedException {

        //1.2. Verify that CRM user can create a new Customer profile when clicked on create button.
        //1.2.1. Click on create button.
        //1.2.2. Enter name.
        //1.2.3. Click on save button  to create the profile

        extentLogger=report.createTest("Create new customer Test");

        extentLogger.info("Logging in");
        positiveLoginTest();

        extentLogger.info("Verifying that CRM user can click on CRM Module");
        pages.login().clickCRModule();

        extentLogger.info("Verify that search box is cleaned.");
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();

        Thread.sleep(15000);
        extentLogger.info("Verifying that CRM user can click on Customers page");
        pages.getCrmUserCustomersPage().customersLink.click();

        extentLogger.info("Clicking on create to create a new customer profile");
        pages.getCrmUserCustomersPage().newCustomerProfile.click();

        extentLogger.info("Entering name");
        pages.getCrmUserCustomersPage().nameField.sendKeys("CustomerName");


        extentLogger.info("Saving the profile");
        driver.findElement(By.className("btn btn-primary btn-sm o_form_button_save")).click();


        extentLogger.info("Verifying that new profile is saved and displayed");
        String actualTitle= driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[2]")).getText();
        Assert.assertTrue(actualTitle.contains("CustomerNAME"));



    }




    @Test (description = "BRIT-2999")
    public void enterInfo(){
        // 1.3. Verify that CRM user can enter contact and address information while creating new profile.
        //1.3.1. Enter contact and address information
        //1.3.2. Click on save button or create button on the new profile window to create the profile





    }




    //BRIT-3000
    //1.4. Verify that CRM user can enter internal notes while creating new profile when clicked on internal notes button.
    //1.4.1.Click on internal notes button.
    //1.4.2. Enter notes in the box.
    //1.4.3. Click on save button or create button on the new profile window to create the profile

    @Test
    public void createInternalNotes(){

    }

    //BRIT-3003
    //1. 5. Verify that CRM user can enter Sales and Purchases information while creating a new profile when clicked on Sales&Purchases button.
    //1.5.1.Click on Sales&Purchases button.
    //1.5.2. Select if a customer by using the checkbox.
    //1.5.3.Select salesperson using dropdown menu.
    //1.5.4. Select sales price list using the dropdown menu.
    //1.5.5.Select if a Vendor by using the checkbox.
    //1.5.6. Click on save button or create button on the new profile window to create the profile

    @Test
    public void enterSalesPurchasesInfo(){

    }

    //BRIT-3004
    //1.6. Verify that CRM user can edit the profile when cliked on edit button.
    //1.6.1. Click on edit.
    //1.6.2. Make changes on the profile.
    //1.6.3. Click on save button to save changes.

    @Test
    public void editProfile(){

    }

    //BRIT-3006
    //1.7. Verify that CRM user can discard any changes while editing the profile when clicked on discard.
    //1.7.1. Click on discard after any changes.
    //1.7.2. Receive the warning ""The record has been modified, your changes will be discarded. Do you want to proceed?""
    //1.7.3. Click ok to discard.
    //1.7.4  Click cancel if you would like to keep the changes.

    @Test
    public void discardChanges(){

    }

    //BRIT-3007
    //1.8. Verify that CRM user can search with customer or company name using search box.
    //1.8.1. Click on the search box.
    //1.8.2. Enter key terms to view certain customers.

    @Test
    public void searchCustomer(){

    }

    //BRIT-3008
    //1.9. Verify that CRM user can clear the search box.
    //1.9.1 Cick on the x next to the key terms.

    @Test
    public void clearSearch(){

    }

    //BRIT-3013
    //1.10. Verify that CRM user can import new customers when clicked on import using csv. or excel file.
    //1.10.1 Click on import.
    //1.10.2. Click on load the find the csv. or excel file to be imported.
    //1.10.3. Clcik on import to complete importing.

    @Test
    public void importCustomers(){

    }


}

