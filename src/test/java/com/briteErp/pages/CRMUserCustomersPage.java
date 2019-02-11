package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CRMUserCustomersPage {

    public CRMUserCustomersPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//span[@class='oe_menu_text'])[19]")
    public WebElement customersLink;

    public String getCustomersTitle(){
        String title = Driver.getDriver().findElement(By.xpath("//div[@class='o_control_panel']//ol//li")).getText();

        return title;
    }

    @FindBy (xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public  WebElement xbuttononsearchbox;


    @FindBy (xpath = "btn btn-primary btn-sm o_form_button_save")
    public WebElement newCustomerProfile;

    @FindBy (xpath = "o_field_input_328")
    public WebElement nameField;


}


