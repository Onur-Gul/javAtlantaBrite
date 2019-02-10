package com.briteErp.pages;

import com.briteErp.utilities.ConfigurationReader;
import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPipelinePage {

    public ManagerPipelinePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement pipelineXXXXX;

    @FindBy(linkText = "Pipeline")
    public WebElement pipelineLink;

    @FindBy(xpath = "//div[@class='o_cp_buttons']//div//button[1]")
    public WebElement createButtonOnPipelinePage;

    @FindBy(xpath = "//span[@class='o_kanban_title']")
    public WebElement addNewColumn;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[5]/div[2]/div/input")
    public WebElement columnTitleEntryBox;

    @FindBy(xpath = "//button[@class ='btn btn-primary o_kanban_add']")
    public WebElement columnNameAddButton;

    @FindBy(xpath = "//div[@data-id='7']/div/div/span")
    public WebElement newColumnTitle;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement importButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_import_cancel']")
    public WebElement importCancelButton;

    @FindBy(xpath = "//div[@data-id='1']/div[2]")
    public WebElement createdOpportunityBox;

    @FindBy(xpath = "//div[@data-id='2']")
    public WebElement target;












    public String getPipelineTitle(){
        String title = Driver.getDriver().getTitle();
     return title;
    }





}
