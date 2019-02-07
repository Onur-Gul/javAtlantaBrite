package com.briteErp.tests.FunctionalTests;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRMManagerCustomersTest extends TestBase {


    @Test
    public void BRIT_3186() {
        Driver.getDriver().get("http://52.39.162.23/web/login");
        pages.getCustomersPage().BriteErpDemo.click();
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail") , ConfigurationReader.getProperty("CRMManagerPassword") );
        pages.getCustomersPage().CRM1.click();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        Assert.assertEquals(pages.getCustomersPage().CustomersHeader.getText() , "Customers");
    }


    @Test
    public void BRIT_3181() {
        Driver.getDriver().get("http://52.39.162.23/web/login");
        pages.getCustomersPage().BriteErpDemo.click();
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail") , ConfigurationReader.getProperty("CRMManagerPassword") );
        pages.getCustomersPage().CRM1.click();
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
        Driver.getDriver().get("http://52.39.162.23/web/login");
        pages.getCustomersPage().BriteErpDemo.click();
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail") , ConfigurationReader.getProperty("CRMManagerPassword") );
        pages.getCustomersPage().CRM1.click();
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
        Driver.getDriver().get("http://52.39.162.23/web/login");
        pages.getCustomersPage().BriteErpDemo.click();
        pages.login().login(ConfigurationReader.getProperty("CRMManagerEmail") , ConfigurationReader.getProperty("CRMManagerPassword") );
        pages.getCustomersPage().CRM1.click();
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



}
