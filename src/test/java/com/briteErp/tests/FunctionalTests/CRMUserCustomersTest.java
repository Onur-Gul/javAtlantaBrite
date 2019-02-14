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

        Thread.sleep(5000);
        extentLogger.info("Verify that search box is cleaned.");
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();

        Thread.sleep(5000);
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
        loginAsUser();

        extentLogger.info("Verifying that CRM user can click on CRM Module");
        pages.login().clickCRModule();

        extentLogger.info("Verify that search box is cleaned.");
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();


        extentLogger.info("Verifying that CRM user can click on Customers page");
        pages.getCrmUserCustomersPage().customersLink.click();

        Thread.sleep(10000);
        extentLogger.info("Clicking on create to create a new customer profile");
        pages.getCrmUserCustomersPage().newCustomerProfile.click();

        extentLogger.info("Entering name");
        pages.getCrmUserCustomersPage().nameField.sendKeys("Mr. Jones");

        Thread.sleep(5000);
        extentLogger.info("Saving the profile");
        pages.getCrmUserCustomersPage().saveButton.click();

        Thread.sleep(5000);
        extentLogger.info("Verifying that new profile is saved and displayed");
        String actualTitle= pages.getCrmUserCustomersPage().NameDisplay.getText();
        Assert.assertEquals(actualTitle, "Mr. Jones");
    }


    @Test (description = "BRIT-2999")
    public void enterCompanyName() throws InterruptedException {
        // 1.3. Verify that CRM user can view Customers page.
        //1.3.1. Enter company name.
        //1.3.2. Click on save button to save.
        extentLogger=report.createTest("Create new customer Test");

        extentLogger.info("Logging in");
        loginAsUser();

        //Thread.sleep(5000);
        extentLogger.info("Verifying that CRM user can click on CRM Module");
        pages.login().clickCRModule();

        Thread.sleep(5000);
        extentLogger.info("Verify that search box is cleaned.");
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();

        Thread.sleep(5000);
        extentLogger.info("Verifying that CRM user can click on Customers page");
        pages.getCrmUserCustomersPage().customersLink.click();

        Thread.sleep(10000);
        extentLogger.info("Clicking on create to create a new customer profile");
        pages.getCrmUserCustomersPage().newCustomerProfile.click();

        Thread.sleep(5000);
        extentLogger.info("Selecting company option");
        pages.getCrmUserCustomersPage().radioButtonCompany.click();

        Thread.sleep(5000);
        extentLogger.info("Entering company name");
        pages.getCrmUserCustomersPage().nameField.sendKeys("The Best");

        Thread.sleep(5000);
        extentLogger.info("Saving the profile");
        pages.getCrmUserCustomersPage().saveButton.click();

       Thread.sleep(5000);
        extentLogger.info("Verifying that company name is saved and displayed");
        String actualTitle= pages.getCrmUserCustomersPage().NameDisplay.getText();
        Assert.assertEquals(actualTitle, "The Best");

    }


    @Test (description = "BRIT-3000")
    public void createInternalNotes() throws InterruptedException {

            //1.4. Verify that CRM user can enter internal notes while creating new profile when clicked on internal notes button.
            //1.4.1.Click on internal notes button.
            //1.4.2. Enter notes in the box.
            //1.4.3. Click on save button or create button on the new profile window to create the profile

            extentLogger=report.createTest("Enter internal notes to the customer profile");

            extentLogger.info("Logging in");
            loginAsUser();

            //Thread.sleep(5000);
            extentLogger.info("Verifying that CRM user can click on CRM Module");
            pages.login().clickCRModule();

            Thread.sleep(5000);
            extentLogger.info("Verify that search box is cleaned.");
            pages.getCrmUserCustomersPage().xbuttononsearchbox.click();

            Thread.sleep(5000);
            extentLogger.info("Verifying that CRM user can click on Customers page");
            pages.getCrmUserCustomersPage().customersLink.click();

            Thread.sleep(5000);
            extentLogger.info("Clicking on create to create a new customer profile");
            pages.getCrmUserCustomersPage().newCustomerProfile.click();

            extentLogger.info("Entering name");
            pages.getCrmUserCustomersPage().nameField.sendKeys("Mr. Jones");

            extentLogger.info("Clicking on internal notes");
            pages.getCrmUserCustomersPage().internalNotes.click();

            Thread.sleep(5000);
            extentLogger.info("Entering internal notes");
            pages.getCrmUserCustomersPage().internalNotesEntered.sendKeys("Our company is rapidly growing");

            Thread.sleep(10000);
            extentLogger.info("Saving the profile");
            pages.getCrmUserCustomersPage().saveButton.click();

            Thread.sleep(5000);
            extentLogger.info("Verifying that internal notes entered is saved and displayed");
            String actualTitle= pages.getCrmUserCustomersPage().noteDisplayed.getText();
            System.out.println(actualTitle);
            Assert.assertTrue(actualTitle.contains("Our company is rapidly growing"));

    }


    @Test (description = "BRIT-3003")
    public void enterSalesPurchasesInfo() throws InterruptedException {
        //1. 5. Verify that CRM user can enter Sales and Purchases information while creating a new profile when clicked on Sales&Purchases button.
        //1.5.1.Click on Sales&Purchases button.
        //1.5.2. Select if a customer by using the checkbox.
        //1.5.3.Select if a Vendor by using the checkbox.
        //1.5.4. Click on save button or create button on the new profile window to create the profile
        extentLogger=report.createTest("Enter sales/purchases info to the customer profile");

        extentLogger.info("Logging in");
        loginAsUser();

        //Thread.sleep(5000);
        extentLogger.info("Verifying that CRM user can click on CRM Module");
        pages.login().clickCRModule();

        Thread.sleep(5000);
        extentLogger.info("Verify that search box is cleaned.");
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();

        Thread.sleep(5000);
        extentLogger.info("Verifying that CRM user can click on Customers page");
        pages.getCrmUserCustomersPage().customersLink.click();

        Thread.sleep(5000);
        extentLogger.info("Clicking on create to create a new customer profile");
        pages.getCrmUserCustomersPage().newCustomerProfile.click();

        extentLogger.info("Entering name");
        pages.getCrmUserCustomersPage().nameField.sendKeys("Mr. Jones");

        extentLogger.info("Clicking on sales/purchases option");
        pages.getCrmUserCustomersPage().salesPurchasesbutton.click();

        extentLogger.info("Selecting customer");
        pages.getCrmUserCustomersPage().customerButton.click();

        extentLogger.info("Selecting vendor");
        pages.getCrmUserCustomersPage().vendorButton.click();

        extentLogger.info("Verifying if vendor is selected");
        Assert.assertTrue(pages.getCrmUserCustomersPage().vendorButton.isSelected());

        Thread.sleep(10000);
        extentLogger.info("Saving the profile");
        pages.getCrmUserCustomersPage().saveButton.click();

    }


    @Test (description = "BRIT-3004")
    public void editProfile() throws InterruptedException {
        //1.6. Verify that CRM user can edit the profile when cliked on edit button.
        //1.6.1. Click on edit.
        //1.6.2. Make changes on the profile.
        //1.6.3. Click on save button to save changes.

        extentLogger=report.createTest("Testing edit function on Customers page");

        loginAsUser();
        pages.login().clickCRModule();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().customersLink.click();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().selectProfile.click();
        pages.getCrmUserCustomersPage().editProfile.click();
        pages.getCrmUserCustomersPage().nameField.sendKeys("Mr. Frank");
        pages.getCrmUserCustomersPage().saveButton.click();

    }

    @Test (description = "BRIT-3006")
    public void discardChanges() throws InterruptedException {
        //1.7. Verify that CRM user can discard any changes while editing the profile when clicked on discard.
        //1.7.1. Click on discard after any changes.
        //1.7.2. Receive the warning ""The record has been modified, your changes will be discarded. Do you want to proceed?""
        //1.7.3. Click ok to discard.
        //1.7.4  Click cancel if you would like to keep the changes.
        extentLogger=report.createTest("Testing edit function on Customers page");

        loginAsUser();
        pages.login().clickCRModule();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().customersLink.click();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().selectProfile.click();
        pages.getCrmUserCustomersPage().editProfile.click();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().nameField.clear();
        pages.getCrmUserCustomersPage().nameField.sendKeys("Mrs. Frankie");
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().discard.click();
        Assert.assertTrue(pages.getCrmUserCustomersPage().warningMessage.getText().contains("The record has been modified, your changes will be discarded. Do you want to proceed?"));
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().confirmChanges.click();
        String actualTitle= pages.getCrmUserCustomersPage().NameDisplay.getText();
        Assert.assertEquals(actualTitle, "Mrs. Frankie");

    }

    @Test (description = "BRIT-3007")
    public void searchCustomer() throws InterruptedException {
        //1.8. Verify that CRM user can search with customer or company name using search box.
        //1.8.1. Click on the search box.
        //1.8.2. Enter key terms to view certain customers.

        extentLogger=report.createTest("Testing search box");

        loginAsUser();
        pages.login().clickCRModule();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();
        Thread.sleep(10000);
        pages.getCrmUserCustomersPage().customersLink.click();
        Thread.sleep(10000);
        pages.getCrmUserCustomersPage().searchbox.sendKeys("Mr. Jones"+Keys.ENTER);
        Thread.sleep(10000);
        Assert.assertTrue(pages.getCrmUserCustomersPage().customerSearched.getText().contains("Mr. Jones"));
    }

    @Test (description = "BRIT-3008")
    public void clearSearch() throws InterruptedException {
        //1.9. Verify that CRM user can clear the search box.
        //1.9.1 Click on the x next to the key terms.
        extentLogger=report.createTest("Testing search box");

        loginAsUser();
        pages.login().clickCRModule();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();
        Thread.sleep(10000);
        pages.getCrmUserCustomersPage().customersLink.click();
        Thread.sleep(10000);
        pages.getCrmUserCustomersPage().searchbox.sendKeys("Mr. Jones"+Keys.ENTER);
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();
        Assert.assertTrue(pages.getCrmUserCustomersPage().searchbox.getText().contains(""));
    }

    @Test (description = "BRIT-3013")
    public void changeListView() throws InterruptedException {
        //1.10. Verify that CRM user can change the thumbnail view to list view. .
        //1.10.1 Click on list view button
        //1.10.2.View the list of Customers
        extentLogger=report.createTest("Changing view of customer list");

        loginAsUser();
        pages.login().clickCRModule();
        Thread.sleep(5000);
        pages.getCrmUserCustomersPage().xbuttononsearchbox.click();
        Thread.sleep(10000);
        pages.getCrmUserCustomersPage().customersLink.click();
        Thread.sleep(10000);
        pages.getCrmUserCustomersPage().listView.click();
        Assert.assertTrue(pages.getCrmUserCustomersPage().list.getText().contains("Name"));

    }


}

