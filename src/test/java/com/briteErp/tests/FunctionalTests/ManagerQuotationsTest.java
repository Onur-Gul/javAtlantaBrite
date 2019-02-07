package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.BrowserUtilities;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ManagerQuotationsTest extends TestBase {


//    @Test
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

        BrowserUtilities.waitForClickability(pages.getQuotationsPage().createButtonInQuotations,10);
        extentLogger.info("Verifying to click on Create button");
        pages.getQuotationsPage().createButtonInQuotations.click();

        extentLogger.info("Verifying to open new quotations page");
        String header = pages.getQuotationsPage().newQuotationsFunctionHeader.getText();
        softAssert.assertEquals(header, "New");
    }

    @Test
    public void createANewQuotationTestNegativeScenario () {

        extentLogger = report.createTest("CRM Manager should be able to " +
                    "create an Quotation(Negative Scenarie)(BRIT-1421)");

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

        BrowserUtilities.waitForClickability(pages.getQuotationsPage().saveButton,10);
        extentLogger.info("Verifying to click on Save button");
        pages.getQuotationsPage().saveButton.click();

        extentLogger.info("Verifying the error Message appears");
        String errorMessage = pages.getQuotationsPage().errorMessageInQuotation.getText();
        softAssert.assertTrue(errorMessage.contains("The following fields are invalid:"));



    }
    @Test
    public void creationANewQuotationTest () throws InterruptedException {

        extentLogger = report.createTest("CRM Manager should be able to " +
                "create an Quotation(Page Confirmation Test)(BRIT-1409)");

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

        BrowserUtilities.waitForVisibility(pages.getQuotationsPage().createButtonInQuotations,10);
        extentLogger.info("Verifying to click on Create button");
        pages.getQuotationsPage().createButtonInQuotations.click();

        BrowserUtilities.waitForPageToLoad(10);
        extentLogger.info("Verifying to enter all mandatory fields");

        pages.getQuotationsPage().customerBox.sendKeys("Bandywine"+Keys.ENTER);
//        pages.getQuotationsPage().invoiceAddressEntryBox.sendKeys("13060 Cogburn Road"+ Keys.ENTER);
//        pages.getQuotationsPage().deliveryAddressEntryBox.sendKeys("671 North Main Street"+ Keys.ENTER);
//        pages.getQuotationsPage().priceListEntryBox.sendKeys("126.54"+ Keys.ENTER);

        extentLogger.info("Verifying to click on Save button");
        pages.getQuotationsPage().saveButton.click();

        extentLogger.info("Verifying to new quotation number");
        String header = pages.getQuotationsPage().newQuotationsFunctionHeader.getText();
        softAssert.assertTrue(header.contains("SO"));
    }
















}
