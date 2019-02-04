package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import com.briteErp.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PipelinePage{

    public PipelinePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement pipelineXXXXX;

    @FindBy(linkText = "Pipeline")
    public WebElement pipelineLink;

    @FindBy(xpath = "//div[@class='o_cp_buttons']//div//button[1]")
    public WebElement createButtonOnPipelinePage;




//div[@class='o_cp_buttons']/div/button[1]

    public String getpipelineTitle(){
        String title = Driver.getDriver().getTitle();
     return title;
    }




}
