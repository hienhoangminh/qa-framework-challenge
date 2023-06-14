package com.rocktester.automation.qaframework.page;

import com.rocktester.automation.qaframework.core.annotation.LazyAutowired;
import com.rocktester.automation.qaframework.core.annotation.Page;
import com.rocktester.automation.qaframework.core.annotation.Window;
import com.rocktester.automation.qaframework.core.exception.AutomationException;
import com.rocktester.automation.qaframework.core.service.PDFService;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;


@Page
@Window(2)
@Slf4j
public class AirwayBillPage extends Base {

    @LazyAutowired
    private PDFService pdfService;

    public void verifyTrackingIdDetail(String id) throws AutomationException {
        String text = pdfService.getContentFromDownloadedFile("src/test/resources/download/test.pdf", driver.getCurrentUrl());
        assertThat(text).contains(id);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.driver.getCurrentUrl().contains("blob"));
    }
}
