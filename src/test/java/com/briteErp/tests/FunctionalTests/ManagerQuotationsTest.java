package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.BrowserUtilities;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ManagerQuotationsTest extends TestBase {


    @Test (priority = 1)
    public void navigateToQuotationsTest (){

        extentLogger = report.createTest("CRM Manager should be able to " +
                "navigate to Quotation functionality(BRIT-1409)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifying to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        BrowserUtilities.waitForVisibility(pages.getQuotationsPage().Quotations,10);
        extentLogger.info("Verifying to click Quotations link");
        pages.getQuotationsPage().Quotations.click();

    }

    @Test (priority = 2)
    public void confirmationOfCreationQuotationTest() {

        extentLogger = report.createTest("CRM Manager should be able to " +
                "create an Quotation(Page Confirmation Test)(BRIT-1418)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifying to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifying to click Quotations link");
        pages.getQuotationsPage().Quotations.click();

        BrowserUtilities.wait(10);
        //BrowserUtilities.waitForClickability(pages.getQuotationsPage().createButtonInQuotations,10);
        extentLogger.info("Verifying to click on Create button");
        pages.getQuotationsPage().createButtonInQuotations.click();

        extentLogger.info("Verifying to open new quotations page");
        String header = pages.getQuotationsPage().newQuotationsFunctionHeader.getText();
        softAssert.assertEquals(header, "New");
    }

    @Test (priority = 3)
    public void createANewQuotationTestNegativeScenario () {

        extentLogger = report.createTest("CRM Manager should be able to " +
                    "create an Quotation(Negative Scenario)(BRIT-1421)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifying to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifying to click Quotations link");
        pages.getQuotationsPage().Quotations.click();

        BrowserUtilities.waitForClickability(pages.getQuotationsPage().createButtonInQuotations,10);
        extentLogger.info("Verifying to click on Create button");
        pages.getQuotationsPage().createButtonInQuotations.click();

        BrowserUtilities.wait(10);
        //BrowserUtilities.waitForClickability(pages.getQuotationsPage().saveButton,10);
        extentLogger.info("Verifying to click on Save button");
        pages.getQuotationsPage().saveButton.click();

        extentLogger.info("Verifying the error Message appears");
        String errorMessage = pages.getQuotationsPage().errorMessageInQuotation.getText();
        softAssert.assertTrue(errorMessage.contains("The following fields are invalid:"));



    }

    @Test (priority = 4)
    public void verifySearchBoxFunctionality () {

        extentLogger = report.createTest("CRM Manager should be able to " +
                "confirm the new quotations to Sales Order)(BRIT-1424)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifying to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifying to click Quotations link");
        pages.getQuotationsPage().Quotations.click();

        BrowserUtilities.waitForClickability(pages.getQuotationsPage().XButtonInQutotationsPageSearchBox,10);
        extentLogger.info("Verifying to click on X button on Quotations Page Search Box");
        pages.getQuotationsPage().XButtonInQutotationsPageSearchBox.click();

        pages.getQuotationsPage().searchBox.sendKeys("SO199"+Keys.ENTER);

        BrowserUtilities.wait(5);
        String actualQuotNumber = pages.getQuotationsPage().quotationNumberAfterSearchBox.getText();
        softAssert.assertEquals(actualQuotNumber,"SO199");
    }

    @Test (priority = 5)
    public void confirmCalenderFunctionOfQuotPage() {

        extentLogger = report.createTest("CRM Manager should be able to " +
                "confirm the new quotations to Sales Order)(BRIT-1423)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifying to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifying to click Quotations link");
        pages.getQuotationsPage().Quotations.click();

        BrowserUtilities.wait(5);
//      BrowserUtilities.waitForClickability(pages.getQuotationsPage().quotationPageCalender,10);
        extentLogger.info("Verifying to click on Calender on Quotations Page");
        pages.getQuotationsPage().quotationPageCalender.click();

        extentLogger.info("Verifying that calender page opened");
        String actualDay = pages.getQuotationsPage().todayButton.getText();
        softAssert.assertEquals(actualDay,"Today");


//        BrowserUtilities.wait(5);
//        BrowserUtilities.waitForClickability(pages.getQuotationsPage().quotationNumber,10);
//
//        pages.getQuotationsPage().quotationNumber.click();

//        extentLogger.info("Verifying to click on Sales Button");
        //pages.getQuotationsPage().confirmSaleButton.click();

//        extentLogger.info("Verifying that quotation turns to Sales Order");
//        String salesOrderMes = pages.getQuotationsPage().arrowSalesOrder.getText();
//        softAssert.assertTrue(salesOrderMes.contains("Sales Order"));
    }


//    @Test (priority = 6)
//    public void creationANewQuotationTest () throws InterruptedException {
//
//        extentLogger = report.createTest("CRM Manager should be able to " +
//                "create an Quotation(Page Confirmation Test)(BRIT-1409)");
//
//        extentLogger.info("Verifying to open main page");
//        pages.login().open();
//
//        extentLogger.info("Verifying to select BriteErpDemo");
//        pages.login().selectBriteErpDemo();
//
//        extentLogger.info("Verifying to login Manager account");
//        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
//                ConfigurationReader.getProperty("CRMManagerPassword"));
//
//        extentLogger.info("Verifying to open CRM module page is ready for usage");
//        pages.login().clickCRModule();
//
//        BrowserUtilities.waitForVisibility(pages.getQuotationsPage().Quotations,10);
//        extentLogger.info("Verifying to click Quotations link");
//        pages.getQuotationsPage().Quotations.click();
//
//        BrowserUtilities.wait(10);
//        BrowserUtilities.waitForVisibility(pages.getQuotationsPage().createButtonInQuotations,10);
//        extentLogger.info("Verifying to click on Create button");
//        pages.getQuotationsPage().createButtonInQuotations.click();
//
//        BrowserUtilities.waitForPageToLoad(10);
//        extentLogger.info("Verifying to enter all mandatory fields");
//
//        BrowserUtilities.wait(10);
//        pages.getQuotationsPage().customerBox.sendKeys("Mark Saplin");
//        pages.getQuotationsPage().invoiceAddressEntryBox.sendKeys("13060 Cogburn Road");
//      pages.getQuotationsPage().deliveryAddressEntryBox.sendKeys("671 North Main Street");
//      pages.getQuotationsPage().priceListEntryBox.sendKeys("126.54");
//
//        BrowserUtilities.wait(10);
//        extentLogger.info("Verifying to click on Save button");
//        pages.getQuotationsPage().saveButton.click();
//
//        extentLogger.info("Verifying to new quotation number");
//        String header = pages.getQuotationsPage().newQuotationsFunctionHeader.getText();
//        softAssert.assertTrue(header.contains("SO"));
//    }












}
