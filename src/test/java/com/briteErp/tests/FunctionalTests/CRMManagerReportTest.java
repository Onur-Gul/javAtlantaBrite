package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.BrowserUtilities;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;

public class CRMManagerReportTest extends TestBase {

    @Test
    public void BRITE_1624()  {

    extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis page)");

    getCRMModule();
    BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 20);
    extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
    pages.reportPage().ReportPipeline.click();
    extentLogger.info("Verifying the ReportPipeline page is ready for usage");
    softAssert.assertEquals(pages.reportPage().getreportpipelineTitle(), ApplicationConstants.REPORTINGACTIVITIES_TITLE);


    }

    @Test
    public void BRITE_2065()  {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis/Total Revenue )");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 20);
        extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
        pages.reportPage().ReportPipeline.click();
        BrowserUtilities.waitForClickability(pages.reportPage().RPMeasures, 10);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();

        extentLogger.info("Verifying the ReportPipeline Measures Total Revenue menu count option is clickable");
        pages.reportPage().RPMeasuresTotalRevenue.click();
        extentLogger.info("Verifying the ReportPipeline page is ready for usage");
        softAssert.assertTrue(pages.reportPage().RPMeasuresTotalRevenue.isSelected());


    }


    @Test
    public void BRITE_2068()  {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis/Count)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 10);
        extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
        pages.reportPage().ReportPipeline.click();
        BrowserUtilities.waitForClickability(pages.reportPage().RPMeasures, 10);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();

        extentLogger.info("Verifying the ReportPipeline Measures/Count menu count option is clickable");
        pages.reportPage().RPMeasuresCount.click();

        extentLogger.info("Verifying the ReportPipeline page is ready for usage");
        softAssert.assertTrue(pages.reportPage().RPMeasuresCount.isSelected());

    }


    @Test
    public void BRITE_2077()  {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis/Delay to Assign)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 10);
        extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
        pages.reportPage().ReportPipeline.click();
        BrowserUtilities.waitForClickability(pages.reportPage().RPMeasures, 10);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();

        extentLogger.info("Verifying the ReportPipeline Measures/Delay to Assign  option is clickable");
        pages.reportPage().RPMeasuresDelayToAssign.click();

        extentLogger.info("Verifying the ReportPipeline page is ready for usage");
        softAssert.assertTrue(pages.reportPage().RPMeasuresDelayToAssign.isSelected());

    }


    @Test
    public void BRITE_2079()  {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis/Delay to Close)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 20);
        extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
        pages.reportPage().ReportPipeline.click();
        BrowserUtilities.waitForClickability(pages.reportPage().RPMeasures, 10);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();

        extentLogger.info("Verifying the ReportPipeline Measures/Delay to Close option is clickable");
        pages.reportPage().RPMeasuresDelayToClose.click();

        extentLogger.info("Verifying the ReportPipeline page is ready for usage");
        softAssert.assertTrue(pages.reportPage().RPMeasuresDelayToClose.isSelected());

    }


    @Test
    public void BRITE_2080() {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis/Overpassed Deadline)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 20);
        extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 10);
        pages.reportPage().ReportPipeline.click();
        BrowserUtilities.waitForClickability(pages.reportPage().RPMeasures, 10);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();

        extentLogger.info("Verifying the ReportPipeline Measures/Overpassed Deadline option is clickable");
        pages.reportPage().RPMeasuresOverPassedDeadLine.click();

        extentLogger.info("Verifying the ReportPipeline page is ready for usage");
        softAssert.assertTrue(pages.reportPage().RPMeasuresOverPassedDeadLine.isSelected());

    }


    @Test
    public void BRITE_2081()  {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis/Number of Activities)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 10);
        extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
        pages.reportPage().ReportPipeline.click();
        BrowserUtilities.waitForClickability(pages.reportPage().RPMeasures, 10);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();

        extentLogger.info("Verifying the ReportPipeline Measures/Number of Activities  option is clickable");
        pages.reportPage().RPMeasuresNumberofActivities.click();

        extentLogger.info("Verifying the ReportPipeline page is ready for usage");
        softAssert.assertTrue(pages.reportPage().RPMeasuresNumberofActivities.isSelected());

    }

    @Test
    public void BRITE_2082()  {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Pipeline Analysis/Probability)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportPipeline, 15);
        extentLogger.info("Verifing to open Report/Pipeline page is ready for usage");
        pages.reportPage().ReportPipeline.click();
        BrowserUtilities.waitForClickability(pages.reportPage().RPMeasures, 10);
        extentLogger.info("Verifying the ReportPipeline measures menu is clickable ");
        pages.reportPage().RPMeasures.click();

        extentLogger.info("Verifying the ReportPipeline Measures/Probability option is clickable");
        pages.reportPage().RPMeasuresProbability.click();

        extentLogger.info("Verifying the ReportPipeline page is ready for usage");
        softAssert.assertTrue(pages.reportPage().RPMeasuresProbability.isSelected());

    }




    @Test
    public void BRITE_2071() {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/Activities Analysis page.(BRIT-2071)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportActivities, 10);
        extentLogger.info("Verifing to open Report/Activities page is ready for usage");
        pages.reportPage().ReportActivities.click();

        extentLogger.info("Verifying the ReportActivities page is ready for usage");
        softAssert.assertEquals(pages.reportPage().getreportpipelineTitle(), ApplicationConstants.REPORTINGACTIVITIES_TITLE);

    }


    @Test
    public void BRITE_2072()  {

        extentLogger = report.createTest("CRM Manager should be able view Reporting/SalesChannel Analysis page.(BRIT-2072)");

        getCRMModule();
        BrowserUtilities.waitForClickability(pages.reportPage().ReportSalesChannel, 20);
        extentLogger.info("Verifing to open Report/SalesChannels page is ready for usage");
        pages.reportPage().ReportSalesChannel.click();

        extentLogger.info("Verifying the ReportSalesChannels page is ready for usage");
        softAssert.assertEquals(pages.reportPage().getreportpipelineTitle(), ApplicationConstants.REPORTINGSALESCHANNELS_TITLE);

    }

}
