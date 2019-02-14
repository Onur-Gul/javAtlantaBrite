package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CRMUserPipelinePage {

    public CRMUserPipelinePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-menu-xmlid='crm.menu_crm_opportunities']")
    public WebElement pipelineLink;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new']")
    public WebElement createButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement importButton;

    @FindBy(xpath = "//ol[@class='breadcrumb']//li[2]")
    public WebElement importAFileTitle;

    @FindBy(xpath = "//span[@class='input-group-btn'][1]")
    public WebElement loadFile;

    @FindBy(xpath = "//td//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement opportunityTitle;

    @FindBy(xpath = "(//div[@class='o_input_dropdown']//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement customer;

    @FindBy(xpath = "//div[@class='o_row']//input[@class='o_field_float o_field_number o_field_widget o_input']")
    public WebElement expectedRevenue;

    @FindBy(xpath = "//tbody//tr[4]//td[2]//div//a[2]")
    public WebElement priority;

    @FindBy(xpath = "//div[@class='o_searchview_facet']//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement xIconOnSearchBox;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "(//div//ul[@class='dropdown-menu o_searchview_autocomplete']//li[1])")
    public WebElement searchBoxFirstItem;


    public List<WebElement> getListOfHeaders(){
        List<WebElement> headers = Driver.getDriver().findElements(
                By.xpath("//ul[@class='nav navbar-nav navbar-left oe_application_menu_placeholder']//li//a//span"));
        for (WebElement header:headers) {
            System.out.println(header.getText());
        }
        return headers;
    }


}
