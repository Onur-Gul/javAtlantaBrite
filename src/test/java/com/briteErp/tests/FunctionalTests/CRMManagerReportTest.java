package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;

public class CRMManagerReportTest extends TestBase {

    @Test
    public void BRITE_1617() throws InterruptedException {

    extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis page.(BRIT-1617)");

    extentLogger.info("Verifying to open main page");
    pages.login().open();

    extentLogger.info("Verifying to select BriteErpDemo");
    pages.login().selectBriteErpDemo();

    extentLogger.info("Verifying to login Manager account");
    pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),ConfigurationReader.getProperty("CRMManagerPassword"));

    extentLogger.info("Verifing to open CRM module page is ready for usage");
    pages.login().clickCRModule();

    extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
    pages.reportPage().ReportPipeline.click();

    extentLogger.info("Verifying the ReportPipeline page is ready for usage");
    softAssert.assertEquals(pages.reportPage().getreportpipelineTitle(), ApplicationConstants.REPORTINGPIPELINE_TITLE);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();
        extentLogger.info("Verifying the ReportPipeline measures menu count option is clickable");
        pages.reportPage().RPMeasuresCount.click();
    }


    @Test
    public void BRITE_2071() throws InterruptedException {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Activities Analysis page.(BRIT-2071)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifing to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifing to open Report/Activities page is ready for usage");
        pages.reportPage().ReportActivities.click();

        extentLogger.info("Verifying the ReportActivities page is ready for usage");
        softAssert.assertEquals(pages.reportPage().getreportpipelineTitle(), ApplicationConstants.REPORTINGACTIVITIES_TITLE);

    }


    @Test
    public void BRITE_2072() throws InterruptedException {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/SalesChannel Analysis page.(BRIT-2072)");

        extentLogger.info("Verifying to open main page");
        pages.login().open();

        extentLogger.info("Verifying to select BriteErpDemo");
        pages.login().selectBriteErpDemo();

        extentLogger.info("Verifying to login Manager account");
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),ConfigurationReader.getProperty("CRMManagerPassword"));

        extentLogger.info("Verifing to open CRM module page is ready for usage");
        pages.login().clickCRModule();

        extentLogger.info("Verifing to open Report/SalesChannels page is ready for usage");
        pages.reportPage().ReportSalesChannel.click();

        extentLogger.info("Verifying the ReportSalesChannels page is ready for usage");
        softAssert.assertEquals(pages.reportPage().getreportpipelineTitle(), ApplicationConstants.REPORTINGSALESCHANNELS_TITLE);

    }

}
