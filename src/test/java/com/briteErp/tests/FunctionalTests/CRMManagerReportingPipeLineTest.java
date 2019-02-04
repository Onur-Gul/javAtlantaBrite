package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ApplicationConstants;
import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.testng.annotations.Test;

public class CRMManagerReportingPipeLineTest extends TestBase {

    @Test
    public void BRITE_0203() throws InterruptedException {

    extentLogger = report.createTest("CRM Manager should be able to " +
            "see reports (BRIT-0203)");

    extentLogger.info("Verifying to open main page");
    pages.login().open();

    extentLogger.info("Verifying to select BriteErpDemo");
    pages.login().selectBriteErpDemo();

    extentLogger.info("Verifying to login Manager account");
    pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail"),
            ConfigurationReader.getProperty("CRMManagerPassword"));

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


}
