package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManagerQuotationsPage {

    public ManagerQuotationsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "/html/body/div[1]/div[1]/div[1]/div[5]/ul[1]/li[2]/a/span")
    public WebElement Quotations;

    @FindBy (xpath = "//button[@accesskey='c']")
    public WebElement createButtonInQuotations;

    @FindBy (xpath = "//h1/span")
    public WebElement newQuotationsFunctionHeader;

    @FindBy (xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='o_notification_manager']/div/div")
    public WebElement errorMessageInQuotation;

    @FindBy (xpath = "//*[@name='partner_id']/div/input")
    public WebElement customerBox;

    @FindBy (xpath = "//*[@id=\"modal_175\"]/div/div/div[3]/button[1]/span")
    public WebElement createBottonOfCustomerBox;


    @FindBy (xpath = "//*[@name='partner_invoice_id']/div/input")
    public WebElement invoiceAddressEntryBox;

    @FindBy (xpath = "//*[@name='partner_shipping_id']/div/input")
    public WebElement deliveryAddressEntryBox;

    @FindBy (xpath = "//*[@name='pricelist_id']/div/input")
    public WebElement priceListEntryBox;

    @FindBy (xpath = "//div[@class='o_searchview_facet']//*[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement XButtonInQutotationsPageSearchBox;

    @FindBy (xpath = "//table/tbody/tr[1]/td[2]")
    public WebElement quotationNumber;

    @FindBy (xpath = "(//button[.='Confirm Sale'])[2]")
    public WebElement confirmSaleButton;

    @FindBy (xpath = "//button[@data-value='sale']")
    public WebElement arrowSalesOrder;

    @FindBy (xpath = "//button[@data-value='sale']")
    public WebElement cancelSalesOrderButton;

    @FindBy (xpath = "//button[@data-value='cancel']")
    public WebElement arrowCancelled;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/input")
    public WebElement searchBox;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement quotationNumberAfterSearchBox;

    @FindBy(xpath = "//div[@class='btn-group btn-group-sm o_cp_switch_buttons']//button[3]")
    public WebElement quotationPageCalender;

    @FindBy(xpath = "//div[@class='o_control_panel']/div[2]/div/div/button[2]")
    public WebElement todayButton;




    public String getQuotationsTitle(){
        String title = Driver.getDriver().getTitle();
        return title;
    }


}
