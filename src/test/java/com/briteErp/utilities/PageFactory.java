package com.briteErp.utilities;

import com.briteErp.pages.*;

public class PageFactory {

    private LoginPage loginPage;
    private ManagerPipelinePage pipelinePage;
    private ManagerQuotationsPage quotationsPage;
    private CRMUserCustomersPage crmUserCustomersPage;
    private CRMUserPipelinePage CRMUserPipelinePage;
    private CRMUserPipelineQualifiedPage qualifiedPage;
    private CRMUserPipelineChangeOpportunityInfoPage changeOpportunityInfoPage;
    private ReportPage reportPage;
    private CustomersPage customersPage;



    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public ManagerPipelinePage getPipelinePage() {
        if (pipelinePage == null) {
            pipelinePage = new ManagerPipelinePage();
        }
        return pipelinePage;
    }


    public ManagerQuotationsPage getQuotationsPage() {
        if (quotationsPage == null) {
            quotationsPage = new ManagerQuotationsPage();
        }
        return quotationsPage;
    }


    public CRMUserPipelinePage CRMUserPipelinePage() {
        if (CRMUserPipelinePage == null) {
            CRMUserPipelinePage = new CRMUserPipelinePage();
        }
        return CRMUserPipelinePage;
    }

    public CRMUserPipelineChangeOpportunityInfoPage changeOpportunityInfoPage() {
        if (changeOpportunityInfoPage == null) {
            changeOpportunityInfoPage= new CRMUserPipelineChangeOpportunityInfoPage();
        }
        return changeOpportunityInfoPage;
    }

    public CRMUserPipelineQualifiedPage qualifiedPage(){
        if (qualifiedPage == null) {
            qualifiedPage = new CRMUserPipelineQualifiedPage();
        }
        return qualifiedPage;
    }

    public ReportPage reportPage() {
        if (reportPage == null) {
            reportPage = new ReportPage();
        }
        return reportPage;

    }


    public CustomersPage getCustomersPage() {
        if (customersPage == null) {
            customersPage = new CustomersPage();
        }
        return customersPage;
    }

        public CRMUserCustomersPage getCrmUserCustomersPage(){
            if (crmUserCustomersPage  == null) {
                crmUserCustomersPage = new CRMUserCustomersPage();
            }
            return crmUserCustomersPage;

        }



}