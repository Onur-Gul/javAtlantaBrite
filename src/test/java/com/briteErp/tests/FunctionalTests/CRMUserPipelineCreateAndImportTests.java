package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CRMUserPipelineCreateAndImportTests extends TestBase {

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-526")
    public void pipelineClickTest() {

        extentLogger = report.createTest("Pipeline Click Test");

        extentLogger.info(" 1.1.1 Open the URL, ");
        pages.login().BriteErpDemo.click();

        extentLogger.info("1.1.2 Login using valid username and password as CRM user.");
        pages.login().signIn.click();
        pages.login().email.sendKeys(ConfigurationReader.getProperty("CRMUserEmail"));
        pages.login().password.sendKeys(ConfigurationReader.getProperty("CRMUserPassword"));
        pages.login().loginButton.click();

        extentLogger.info(" 1.1.3 Click on CRM tab on top.");
        pages.login().CRMButton.click();
        pages.CRMUserPipelinePage().pipelineLink.click();

    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-624")
    public void createOpportunityTest(){

        extentLogger = report.createTest("Create an Opportunity as User");

        extentLogger.info("Method: Login as CRM User with valid username and password and click on CRM button");
        loginAsUser();

        extentLogger.info("1.2.1 Click on Create button.");
        pages.CRMUserPipelinePage().createButton.click();

        extentLogger.info("1.2.2 Enter new opportunity's general information to the respective lines.");
        pages.CRMUserPipelinePage().opportunityTitle.sendKeys("2019 Huge Sale 5");

        extentLogger.info("Enter Random number for expected revenue");
        pages.CRMUserPipelinePage().expectedRevenue.clear();
        pages.CRMUserPipelinePage().expectedRevenue.sendKeys(randomQuantity());
        pages.CRMUserPipelinePage().priority.click();

        extentLogger.info("1.2.3 Save the changes by clicking create button.");
        driver.findElement(By.xpath("//footer//button[1]")).click();
    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-626")
    public void changeOpportunityInformation() throws InterruptedException{

        extentLogger = report.createTest("Create an Opportunity Information as User");

        extentLogger.info("Method: Login as CRM User with valid username and password and click on CRM button");
        loginAsUser();

//      THROWS NULLPOINTER EXCEPTION for changing opportunity test for failure test
        extentLogger.info("1.3.1 Click on the new opportunity created.");
        pages.changeOpportunityInfoPage().newCreatedOpportunity.click();

        extentLogger.info("1.3.2 Click on edit button");
        pages.changeOpportunityInfoPage().editButton.click();

        extentLogger.info("1.3.3 Change any information needed.");
        pages.changeOpportunityInfoPage().infoNeededToChange.clear();

        pages.changeOpportunityInfoPage().infoNeededToChange.sendKeys("2019 Huge Sale 2");

        extentLogger.info("1.3.4 Save the changes by clicking save button.");
        pages.changeOpportunityInfoPage().saveButton.click();

    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-627")
    public void clearingSearchBox() throws InterruptedException{

        extentLogger = report.createTest("Clearing Searchbox Test");

        extentLogger.info("Method: Login as CRM User with valid username and password and click on CRM button");
        loginAsUser();
//
        extentLogger.info("1.4.1 Clear the search box by clicking the x.");
        pages.CRMUserPipelinePage().xIconOnSearchBox.click();
    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-628")
    public void searchOpportunity(){

        extentLogger = report.createTest("Searching Opportunity Test");

        extentLogger.info("Method: Login as CRM User with valid username and password and click on CRM button");
        loginAsUser();

        extentLogger.info("1.5.1 Clear the search box by clicking the x.");
        pages.CRMUserPipelinePage().xIconOnSearchBox.click();

        extentLogger.info("1.5.2 Enter the name of newly created oppurtunity \"2019 Huge Sale 2\"");
        pages.CRMUserPipelinePage().searchBox.sendKeys("2019 Huge Sale 2");

        extentLogger.info("1.5.3 Verify the name of the oppurtunity is matching with the name of oppurtunity created.");
        String expectedOpportunity = pages.CRMUserPipelinePage().searchBoxFirstItem.getText();
        softAssert.assertTrue(expectedOpportunity.contains("2019 Huge Sale 2"));
    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-629")
    public void importAFile(){

        extentLogger = report.createTest("Importing a File Test");

        extentLogger.info("Method: Login as CRM User with valid username and password and click on CRM button");
        loginAsUser();

        extentLogger.info("1.6.1 Click on \"\"Import\"\" button");
        pages.CRMUserPipelinePage().importButton.click();

        extentLogger.info("1.6.2 Verify the the title includes \"\"Import a File\"\"extentLogger.info(\"1.4.1 Clear the search box by clicking the x.\")");
        softAssert.assertEquals(pages.CRMUserPipelinePage().importAFileTitle.getText(), "Import a File");

        extentLogger.info("1.6.3 Click on \"\"Load File\"\" button.");
        pages.CRMUserPipelinePage().loadFile.click();
    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-2576")
    public void verifyCreateAndImport(){

        extentLogger = report.createTest("Verifying Create and Import Test");

        extentLogger.info("1.7.1 Click on CRM module and 1.7.2 Click on Pipeline");
        loginAsUser();

        extentLogger.info("1.7.3 Verify the \"\"Create\"\" and \"\"import\"\" buttons are existing.");
        softAssert.assertTrue(pages.CRMUserPipelinePage().createButton.getText().contains("Create"));
        softAssert.assertTrue(pages.CRMUserPipelinePage().importButton.getText().contains("Import"));
    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-684")
    public void itemUnderQualified(){

        extentLogger = report.createTest("Item Under Qualified Category");

        extentLogger.info("Method: Login as CRM User with valid username and password and click on CRM button");
        loginAsUser();

        extentLogger.info("2.1.1 Clear the search box by clicking the x.");
        pages.CRMUserPipelinePage().xIconOnSearchBox.click();

        extentLogger.info("2.1.2 Click on any opportunity under Qualified.");
        pages.qualifiedPage().opportunityUnderQualified.click();

        extentLogger.info("2.1.3 Verify the the title includes expected Title");
        softAssert.assertEquals(
                pages.qualifiedPage().expectedTitleOfOpportunityUnderQualified.getText(),
                pages.qualifiedPage().actualTitleOfOpportunityUnderQualified.getText());
    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-688, http://jira.cybertekschool.com/browse/BRIT-690")
    public void changeStatus(){

        extentLogger = report.createTest("Changing Status Tests");

        extentLogger.info("Method: Login as CRM User with valid username and password and click on CRM button");
        loginAsUser();

        extentLogger.info("2.2.1 Clear the search box by clicking the x.");
        pages.CRMUserPipelinePage().xIconOnSearchBox.click();

        extentLogger.info("2.2.2 Click on any opportunity under Qualified.");
        pages.qualifiedPage().opportunityUnderQualified.click();

        extentLogger.info("2.2.3 Click on \"\"Mark Won\"\"");
        pages.qualifiedPage().markWon.click();

        extentLogger.info("2.2.4 Verify that the status has changed to \"\"won\"\".");
        softAssert.assertTrue(pages.qualifiedPage().wonOrLostStatus.isDisplayed());

        extentLogger.info("2.2.5 Click on \"\"Mark Lost\"\"");
        pages.qualifiedPage().markLost.click();

        extentLogger.info("2.3.6 enter any reason to change the status.");
        pages.qualifiedPage().reasonForLost.sendKeys("very expensive", Keys.ENTER);

        extentLogger.info("2.3.7 Click on submit.");
        pages.qualifiedPage().submitOnReason.click();

        extentLogger.info("2.3.8 Verify that the status has changed to \"\"lost\"\"");
        softAssert.assertTrue(pages.qualifiedPage().wonOrLostStatus.isDisplayed());
    }

    @Test (description = "http://jira.cybertekschool.com/browse/BRIT-3262")
    public void moduleOptions(){

        extentLogger = report.createTest("Module Options Tests");

        extentLogger.info("3.1.1 Open URL.");
        pages.login().BriteErpDemo.click();

        extentLogger.info("3.1.2 Login to the website.");
        pages.login().signIn.click();
        pages.login().email.sendKeys(ConfigurationReader.getProperty("CRMUserEmail"));
        pages.login().password.sendKeys(ConfigurationReader.getProperty("CRMUserPassword"));
        pages.login().loginButton.click();

        extentLogger.info("3.1.3 Verify the module tabs contains CRM module.");
        softAssert.assertEquals(pages.login().CRMButton.getText(), "CRM");
    }


}

