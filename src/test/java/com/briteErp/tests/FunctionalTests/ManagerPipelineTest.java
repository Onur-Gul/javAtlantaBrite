package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class ManagerPipelineTest extends TestBase {

    @Test(priority = 1)
    public void managerNavigateToCRMModule() {

        extentLogger = report.createTest("CRM Manager should be able to " +
                "navigate to CRM module(BRIT-1387)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifing to open CRM module page is ready for usage");
        pages.login().clickCRModule();
    }

    @Test (priority = 2)
    public void managerCreateAnOpportunity () throws InterruptedException {

    extentLogger = report.createTest("CRM Manager should be able to " +
            "create an opportunity(BRIT-1411)");

    extentLogger.info("Verifying to open main page");
    pages.login().open();

    extentLogger.info("Verifying to select BriteErpDemo");
    pages.login().selectBriteErpDemo();

    extentLogger.info("Verifying to login Manager account");
    pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
            ConfigurationReader.getProperty("CRMManagerPassword"));

    extentLogger.info("Verifing to open CRM module page is ready for usage");
    pages.login().clickCRModule();

    extentLogger.info("Verifying the Pipeline page is ready for usage");
    softAssert.assertEquals(pages.getPipelinePage().getPipelineTitle(), ApplicationConstants.PIPELINE_TITLE);

    extentLogger.info("Verifying the Pipeline func. is clickable");
    pages.getPipelinePage().pipelineLink.click();

    extentLogger.info("Verifying the Create button on the Pipeline page is clickable");
    Thread.sleep(5000);
    pages.getPipelinePage().createButtonOnPipelinePage.click();

    }

   @Test (priority = 3)
   public void managerCreateASalesProcessColumn()throws Exception{

   extentLogger = report.createTest("CRM Manager should be able to " +
                "create an new Column for the sales process (BRIT-2503)");
   extentLogger.info("Verifying to open main page");
   pages.login().open();

   extentLogger.info("Verifying to select BriteErpDemo");
   pages.login().selectBriteErpDemo();

   extentLogger.info("Verifying to login Manager account");
   pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

   extentLogger.info("Verifing to open CRM module page is ready for usage");
   pages.login().clickCRModule();

   extentLogger.info("Verifying the Pipeline func. is clickable");
   pages.getPipelinePage().pipelineLink.click();

   extentLogger.info("Verifying Add new Column link is working in CRM Manager PipelinePage");
   pages.getPipelinePage().addNewColumn.click();

   Thread.sleep(5000);
   extentLogger.info("Verifying Column Title accepts Entry Value");
   pages.getPipelinePage().columnTitleEntryBox.sendKeys("Lost Opportunities");
   pages.getPipelinePage().columnNameAddButton.click();

   extentLogger.info("Verifying Column created with correct Header in PipeLine Home page");
   softAssert.assertEquals(pages.getPipelinePage().columnTitleEntryBox.getText(), "Lost Opportunities");

   }

    @Test (priority = 4)
    public void importAnFileTest(){

    extentLogger = report.createTest("CRM Manager should be able to " +
            "import a new CSV or Excel File (BRIT-1408)");

    extentLogger.info("Verifying to open main page");
    pages.login().open();

    extentLogger.info("Verifying to select BriteErpDemo");
    pages.login().selectBriteErpDemo();

    extentLogger.info("Verifying to login Manager account");
    pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

    extentLogger.info("Verifing to open CRM module page is ready for usage");
    pages.login().clickCRModule();

    extentLogger.info("Verifing to click import button");
    pages.getPipelinePage().importButton.click();

    extentLogger.info("Verifing to click Load_File button");
    pages.getPipelinePage().importCancelButton.click();
    }

    @Test (priority = 5)
    public void dragAnOpportunityTest() {

        extentLogger = report.createTest("CRM Manager should be able to " +
                "drag the opportunity into the any column or any line at the pipeline page (BRIT-1414)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
                ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifing to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifing to opportunity boxes are draggable");

        actions.dragAndDrop(pages.getPipelinePage().createdOpportunityBox, pages.getPipelinePage().target).perform();
    }




}
