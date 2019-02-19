package com.briteErp.pages;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CustomersPage extends TestBase {

    public CustomersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='list-group-item'][2]")
    public WebElement BriteErpDemo ;

    @FindBy(xpath = "//a[@data-action-id='365'][1]")
    public WebElement CRM1;

    @FindBy(xpath = "(//a[@data-action-id='48'])[1]")
    public WebElement Customers;

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement Create;

    @FindBy(xpath = "//ol[@class='breadcrumb']/li")
    public WebElement CustomersHeader;

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement nameField;

    @FindBy(xpath = "//div[@class='o_form_buttons_edit']/button")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='o_form_buttons_edit']/button[2]")
    public WebElement discardButton;

    @FindBy(xpath = "//li[@modifiers='{}']/span")
    public WebElement customerNameOnCart;

    @FindBy(xpath = "(//li[@class='active'])[2]")
    public WebElement customerNameOnAccount;

    @FindBy(className = "modal-body")
    public WebElement warningPopUp;

    @FindBy(xpath = "//div[@class='modal-footer']/button[1]")
    public WebElement warningOkButton;

    @FindBy(xpath = "//button[@aria-label='kanban']")
    public WebElement kanbanViewButton;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement listViewButton;

    @FindBy(xpath = "(//div[@class='o_radio_item']/input)[1]")
    public WebElement radioButtonIndividual;

    @FindBy(xpath = "(//div[@class='o_radio_item']/input)[2]")
    public WebElement radioButtonCompany;

    @FindBy(xpath = "//span[@class='btn-group btn-group-sm']/button[2]")
    public WebElement rightArrowButton;

    @FindBy(xpath = "//span[@class='btn-group btn-group-sm']/button")
    public WebElement leftArrowButton;

    @FindBy(xpath = "//span[@class='o_pager_value']")
    public WebElement numberInterval2;

    @FindBy(xpath = "//input[@placeholder='Company']")
    public WebElement companyDropdown;


    public List<String> nameListMakerKanbanView(){
        List<WebElement> customerCards = Driver.getDriver().findElements(By.xpath("//strong[@modifiers='{}']/span"));
        List<String> namesList80= new ArrayList<>();
        for(WebElement a : customerCards){
            namesList80.add(a.getText());
        }
        return namesList80;
    }

    public List<String> nameListMakerListView(){
        List<WebElement> customerCards = Driver.getDriver().findElements(By.xpath("//td[@class='o_data_cell o_readonly_modifier']"));
        List<String> namesList80= new ArrayList<>();
        for(WebElement a : customerCards){
            namesList80.add(a.getText());
        }
        return namesList80;
    }

    public void goToCustomersPage(){
        extentLogger.info("Navigating to the Customers page");
        Customers.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Customers - Odoo"));
    }

}
