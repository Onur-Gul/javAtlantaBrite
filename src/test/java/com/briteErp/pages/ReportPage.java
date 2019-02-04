package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {
    public ReportPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(xpath = "//a[@data-menu='279']")
   public WebElement ReportPipeline ;

    @FindBy(xpath = "//a[@data-menu='278']")
    public WebElement ReportActivities ;

    @FindBy(xpath = "//a[@data-menu='269']")
    public WebElement ReportSalesChannel ;




    @FindBy(xpath = "//div//button[@class='btn btn-primary btn-sm dropdown-toggle']")
    public WebElement RPMeasures ;

    @FindBy(xpath = "(//div[@class='btn-group btn-group-sm open']//li)[9]")
    public WebElement RPMeasuresCount;





    public String getreportpipelineTitle(){
        String title = Driver.getDriver().getTitle();
        return title;
    }
}
