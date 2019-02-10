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


    //YENILER

    @Test   //Test gecmedi. Sayfa yavas oldugu icin olabilir. Tekrar dene
    public void BRIT_3167() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        pages.getCustomersPage().Create.click();
        Assert.assertTrue( pages.getCustomersPage().radioButtonIndividual.isSelected()
                          && !pages.getCustomersPage().radioButtonCompany.isSelected() );
        pages.getCustomersPage().radioButtonCompany.click();
        Assert.assertTrue( !pages.getCustomersPage().radioButtonIndividual.isSelected()
                            && pages.getCustomersPage().radioButtonCompany.isSelected() );
    }


    @Test   //Test gecti. Ancak Olusturdugum listin locatorunu pagese tasiyinca olmuyor. Tekrar dene
    public void BRIT_3170() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        List<WebElement> customerCards = Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']/div[2]/strong/span"));
        List<String> namesList80= new ArrayList<>();
        for(WebElement a : customerCards){
        namesList80.add(a.getText());
        }
        Assert.assertTrue(namesList80.size() == 80);
    }


    @Test
    public void BRIT_3174() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
        pages.getCustomersPage().rightArrowButton.click();
        Assert.assertEquals(pages.getCustomersPage().numberInterval2.getText(), "81-160");
        List<WebElement> customerCards = Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']/div[2]/strong/span"));
        Assert.assertTrue(customerCards.size() == 80);
    }


    @Test       // gecmedi, site cok agir
    public void BRIT_3178() throws InterruptedException {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));

        List<WebElement> customerCardsFirst = Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']/div[2]/strong/span"));
        List<String> namesList80First= new ArrayList<>();
        for(WebElement a : customerCardsFirst){
            namesList80First.add(a.getText());
        }
        pages.getCustomersPage().rightArrowButton.click();
            Thread.sleep(5000);
        pages.getCustomersPage().leftArrowButton.click();
        List<WebElement> customerCardsSecond = Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']/div[2]/strong/span"));
        List<String> namesList80Second= new ArrayList<>();
        for(WebElement a : customerCardsSecond){
            namesList80Second.add(a.getText());
        }
        Assert.assertNotEquals(namesList80First, namesList80Second);
    }


    @Test   //Test gecmedi. Tekrar dene
    public void BRIT_3151() {
        extentLogger = report.createTest("CRM Manager should be able to see current customer cards on the Customers page)");
        getCRMModule();
        pages.getCustomersPage().Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));

        List<WebElement> customerCardsK = Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']/div[2]/strong/span"));
        List<String> namesList80Kanban= new ArrayList<>();
        for(WebElement name : customerCardsK){
            namesList80Kanban.add(name.getText());
        }
            pages.getCustomersPage().listViewButton.click();
        List<WebElement> customerCardsL = Driver.getDriver().findElements(By.xpath("//td[@class='o_data_cell o_readonly_modifier']"));
        List<String> namesList80ListView= new ArrayList<>();
        for(WebElement name : customerCardsL){
            namesList80ListView.add(name.getText());
        }
        Assert.assertEquals(namesList80Kanban, namesList80ListView);
    }

}
