package com.briteErp.tests.FunctionalTests;


import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class CRMManagerCustomersTest extends TestBase {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);


    @Test
    public void BRIT_3186() {
        extentLogger = report.createTest("User should be able to navigate to the Customers page");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Verifying that navigated to Customers page");
        Assert.assertEquals(pages.getCustomersPage().CustomersHeader.getText() , "Customers");
    }



    @Test
    public void BRIT_3181() {
        extentLogger = report.createTest("User must fill the name field to be able to create a new customer card");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Clicking on Create button");
        pages.getCustomersPage().Create.click();
        extentLogger.info("Emptying the name check box and saving");
        pages.getCustomersPage().nameField.clear();
        pages.getCustomersPage().saveButton.click();
        extentLogger.info("Verifying that error message exists");
        Assert.assertEquals(Driver.getDriver().getTitle(), "New - Odoo");
    }



    @Test
    public void BRIT_3157() {
        extentLogger = report.createTest("Verify that it navigates to the customers account after new customer card created ");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Clicking on Create button");
        pages.getCustomersPage().Create.click();
        extentLogger.info("Entering a value to name field and saving");
        pages.getCustomersPage().nameField.clear();
        pages.getCustomersPage().nameField.sendKeys("SampleName123");
        pages.getCustomersPage().saveButton.click();
        extentLogger.info("Verifying the name match in new customer page");
        wait.until(ExpectedConditions.titleIs("SampleName123 - Odoo"));
        Assert.assertEquals("SampleName123", pages.getCustomersPage().customerNameOnAccount.getText());
    }



    @Test
    public void BRIT_3161() {
        extentLogger = report.createTest("On the Create Customers page, after filling the form, Discard button should cancel the process and open the Customers page");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Clicking on Create button");
        pages.getCustomersPage().Create.click();
        extentLogger.info("Filling the name field");
        pages.getCustomersPage().nameField.clear();
        pages.getCustomersPage().nameField.sendKeys("Sample NameXYZ");
        extentLogger.info("Clicking on Discard button");
        pages.getCustomersPage().discardButton.click();
        String warningText = pages.getCustomersPage().warningPopUp.getText();
        extentLogger.info("Verifying the warning message");
        Assert.assertTrue(warningText.contains("Do you want to proceed?"));
        pages.getCustomersPage().warningOkButton.click();
        extentLogger.info("Checking the new page navigated");
        Assert.assertEquals(pages.getCustomersPage().CustomersHeader.getText(), "Customers");
    }



    @Test
    public void BRIT_3183() {
        extentLogger = report.createTest("Verify that Customers page open in Kanban style view, and List button switches the view to the list view");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Verifying that Kanban button is selected as default");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view_type=kanban&model"));
        extentLogger.info("Verifying that list button switches the page to list view");
        pages.getCustomersPage().listViewButton.click();
        wait.until(ExpectedConditions.urlContains("view_type=list&model"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view_type=list&model"));
    }



    @Test
    public void BRIT_3167() {
        extentLogger = report.createTest("Verify that Individual radio button is selected as default, and Company radio button is selectable on the Customers/New page");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Clicking on Create page");
        pages.getCustomersPage().Create.click();
        extentLogger.info("Verifying that Individual Button is selected as default and Company button is not selected");
        Assert.assertTrue( pages.getCustomersPage().radioButtonIndividual.isSelected() && !pages.getCustomersPage().radioButtonCompany.isSelected() );
        extentLogger.info("Clicking on Company radio button");
        pages.getCustomersPage().radioButtonCompany.click();
        wait.until(ExpectedConditions.invisibilityOf(pages.getCustomersPage().companyDropdown));
        extentLogger.info("Verifying that Individual Button is not selected and Company button is selected");
        Assert.assertTrue( !pages.getCustomersPage().radioButtonIndividual.isSelected() && pages.getCustomersPage().radioButtonCompany.isSelected() );
    }



    @Test
    public void BRIT_3170() {
        extentLogger = report.createTest("Verify that 80 customers in total displayed on the Customers screen");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Verifying that total number of customer cards is equal to 80");
        Assert.assertTrue(pages.getCustomersPage().nameListMakerKanbanView().size() == 80);
    }



    @Test
    public void BRIT_3174() {
        extentLogger = report.createTest("Verify that the right arrow button brings the next set of 80 customers");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Clicking on the right arrow button");
        pages.getCustomersPage().rightArrowButton.click();
        extentLogger.info("Verifying that the number interval 81-160 is shown");
        Assert.assertEquals(pages.getCustomersPage().numberInterval2.getText(), "81-160");
        List<String> customerCards = pages.getCustomersPage().nameListMakerKanbanView();
        extentLogger.info("Verifying that total number customer cards is 80");
        Assert.assertTrue(customerCards.size() == 80);
    }



    @Test
    public void BRIT_3178() throws InterruptedException {
        extentLogger = report.createTest("Verify that the left arrow button brings the previous set of 80 customer cards");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Saving the names appear in the Customers main page");
        List<String> namesList80First= pages.getCustomersPage().nameListMakerKanbanView();
        extentLogger.info("Navigating to the next page of customer cards");
        pages.getCustomersPage().rightArrowButton.click();
        Thread.sleep(3000);
        extentLogger.info("Navigating back to the previous page of customer cards");
        pages.getCustomersPage().leftArrowButton.click();
        extentLogger.info("Saving the names appear in the page");
        List<String> namesList80Second= pages.getCustomersPage().nameListMakerKanbanView();
        extentLogger.info("Verifying that two lists are matching");
        Assert.assertNotEquals(namesList80First, namesList80Second);
    }



    @Test
    public void BRIT_3151() {
        extentLogger = report.createTest("Verify that the same customers are listed in the same order when user switch to the list view");
        getCRMModule();
        pages.getCustomersPage().goToCustomersPage();
        extentLogger.info("Saving the names appear in Kanban View");
        List<String> namesList80KanbanView = pages.getCustomersPage().nameListMakerKanbanView();
        extentLogger.info("Switching to List View");
        pages.getCustomersPage().listViewButton.click();
        extentLogger.info("Saving the names appear in List View");
        List<String> namesList80ListView= pages.getCustomersPage().nameListMakerListView();
        extentLogger.info("Verifying that names are the same in Kanban View and List View");
        Assert.assertEquals(namesList80KanbanView, namesList80ListView);
    }


}