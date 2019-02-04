package com.briteErp.utilities;

import com.briteErp.pages.*;

public class PageFactory {

    private LoginPage loginPage;
    private PipelinePage pipelinePage;
    private CRMUserPipelinePage CRMUserPipelinePage;

    private CRMUserPipelineChangeOpportunityInfoPage changeOppurtunityInfoPage;
    private ReportPage reportPage;

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

    public CRMUserPipelinePage CRMUserPipelinePage() {
        if (CRMUserPipelinePage == null) {
            CRMUserPipelinePage = new CRMUserPipelinePage();
        }
        return CRMUserPipelinePage;
    }

    public CRMUserPipelineChangeOpportunityInfoPage changeOppurtunityInfoPage() {
        if (changeOppurtunityInfoPage == null) {
            changeOppurtunityInfoPage= new CRMUserPipelineChangeOpportunityInfoPage();
        }
        return changeOppurtunityInfoPage;
    }

    public ReportPage reportPage() {
        if (reportPage == null) {
            reportPage = new ReportPage();
        }
        return reportPage;

    }}