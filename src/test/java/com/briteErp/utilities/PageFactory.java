package com.briteErp.utilities;

import com.briteErp.pages.*;

public class PageFactory {

    private LoginPage loginPage;
    private PipelinePage pipelinePage;
    private UserCrmPipelinePage userCrmPipelinePage;

    private CRMUserCustomersPage crmUserCustomersPage;

    private UserCrmPipelineChangeOpportunityInfoPage changeOppurtunityInfoPage;
    private ReportPage reportPage;
    private CustomersPage customersPage;

    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public PipelinePage getPipelinePage() {
        if (pipelinePage == null) {
            pipelinePage = new PipelinePage();
        }
        return pipelinePage;
    }

    public UserCrmPipelinePage userCrmPipelinePage() {
        if (userCrmPipelinePage == null) {
            userCrmPipelinePage = new UserCrmPipelinePage();
        }
        return userCrmPipelinePage;
    }

    public UserCrmPipelineChangeOpportunityInfoPage changeOppurtunityInfoPage() {
        if (changeOppurtunityInfoPage == null) {
            changeOppurtunityInfoPage= new UserCrmPipelineChangeOpportunityInfoPage();
        }
        return changeOppurtunityInfoPage;
    }

    public ReportPage reportPage() {
        if (reportPage == null) {
            reportPage = new ReportPage();
        }
        return reportPage;

    }
    public CRMUserCustomersPage getCrmUserCustomersPage() {
        if (crmUserCustomersPage == null) {
            crmUserCustomersPage = new CRMUserCustomersPage();
        }
        return crmUserCustomersPage;
    }

    public CustomersPage getCustomersPage() {
        if (customersPage == null) {
            customersPage = new CustomersPage();
        }
        return customersPage;
    }

}