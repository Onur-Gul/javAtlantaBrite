package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CRMManagerCustomersTest extends TestBase {


    @Test
    public void BRIT_3186() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        Assert.assertEquals(pages.getCustomersPage().CustomersHeader.getText() , "Customers");
    }


    @Test
    public void BRIT_3181() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        pages.getCustomersPage().Create.click();
        pages.getCustomersPage().nameField.clear();
        pages.getCustomersPage().saveButton.click();
        Assert.assertEquals(Driver.getDriver().getTitle(), "New - Odoo");
    }


    @Test
    public void BRIT_3157() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        String nameOnCart = pages.getCustomersPage().customerNameOnCart.getText();
        pages.getCustomersPage().customerNameOnCart.click();
        String nameOnAccount = pages.getCustomersPage().customerNameOnAccount.getText();
        Assert.assertEquals(nameOnCart, nameOnAccount);
    }


    @Test
    public void BRIT_3161() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        pages.getCustomersPage().Create.click();
        pages.getCustomersPage().nameField.clear();
        pages.getCustomersPage().nameField.sendKeys("Sample NameXYZ");
        pages.getCustomersPage().discardButton.click();
        String warningText = pages.getCustomersPage().warningPopUp.getText();
        Assert.assertTrue(warningText.contains("Do you want to proceed?"));
        pages.getCustomersPage().warningOkButton.click();
        Assert.assertEquals(pages.getCustomersPage().CustomersHeader.getText(), "Customers");
    }


    @Test
    public void BRIT_3183() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        extentLogger.info("Navigating to the Customers page");
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        extentLogger.info("Verify that Kanban button is selected as default");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view_type=kanban&model"));
        extentLogger.info("Verify that list button switches the page to list view");
        pages.getCustomersPage().listViewButton.click();
        WebDriverWait waitX = new WebDriverWait(Driver.getDriver(), 10);
        waitX.until(ExpectedConditions.urlContains("view_type=list&model"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view_type=list&model"));
    }



    @Test
    public void BRIT_3167() {
        extentLogger = report.createTest("Verify that Individual radio button is selected as default, and Company radio button is selectable on the Customers/New page");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        pages.getCustomersPage().Create.click();
        Assert.assertTrue( pages.getCustomersPage().radioButtonIndividual.isSelected()
                          && !pages.getCustomersPage().radioButtonCompany.isSelected() );
        pages.getCustomersPage().radioButtonCompany.click();
        wait.until(ExpectedConditions.invisibilityOf(pages.getCustomersPage().companyDropdown));
        Assert.assertTrue( !pages.getCustomersPage().radioButtonIndividual.isSelected()
                            && pages.getCustomersPage().radioButtonCompany.isSelected() );
    }


    @Test
    public void BRIT_3170() {
        extentLogger = report.createTest("Verify that 80 customers in total displayed on the Customers screen");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        Assert.assertTrue(pages.getCustomersPage().nameListMakerKanbanView().size() == 80);
    }


    @Test
    public void BRIT_3174() throws InterruptedException {
        extentLogger = report.createTest("Verify that the right arrow button brings the next set of 80 customers");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        pages.getCustomersPage().rightArrowButton.click();
        Thread.sleep(5000);
        Assert.assertEquals(pages.getCustomersPage().numberInterval2.getText(), "81-160");
        List<String> customerCards = pages.getCustomersPage().nameListMakerKanbanView();
        Assert.assertTrue(customerCards.size() == 80);
    }


    @Test
    public void BRIT_3178() throws InterruptedException {
        extentLogger = report.createTest("Verify that the left arrow button brings the previous set of 80 customer cards");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));

        List<String> namesList80First= pages.getCustomersPage().nameListMakerKanbanView();
        pages.getCustomersPage().rightArrowButton.click();
            Thread.sleep(5000);
        pages.getCustomersPage().leftArrowButton.click();
        List<String> namesList80Second= pages.getCustomersPage().nameListMakerKanbanView();
        Assert.assertNotEquals(namesList80First, namesList80Second);
    }


    @Test
    public void BRIT_3151() {
        extentLogger = report.createTest("Verify that the same customers are listed in the same order when user switch to the list view");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        List<String> namesList80KanbanView = pages.getCustomersPage().nameListMakerKanbanView();
        pages.getCustomersPage().listViewButton.click();
        List<String> namesList80ListView= pages.getCustomersPage().nameListMakerListView();
        Assert.assertEquals(namesList80KanbanView, namesList80ListView);
    }

}
