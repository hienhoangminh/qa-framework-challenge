package com.rocktester.automation.qaframework.core.service;

import com.rocktester.automation.qaframework.core.annotation.LazyAutowired;
import com.rocktester.automation.qaframework.core.exception.AutomationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

@Service
@Slf4j
public class PDFService {

    @LazyAutowired
    private JavascriptExecutor js;

    private String getBytesFromUrl(String url) {
        String script = " "
                + "var uri = arguments[0];"
                + "var callback = arguments[1];"
                + "var toBase64 = function(buffer){for(var r,n=new Uint8Array(buffer),t=n.length,a=new Uint8Array(4*Math.ceil(t/3)),i=new Uint8Array(64),o=0,c=0;64>c;++c)i[c]='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'.charCodeAt(c);for(c=0;t-t%3>c;c+=3,o+=4)r=n[c]<<16|n[c+1]<<8|n[c+2],a[o]=i[r>>18],a[o+1]=i[r>>12&63],a[o+2]=i[r>>6&63],a[o+3]=i[63&r];return t%3===1?(r=n[t-1],a[o]=i[r>>2],a[o+1]=i[r<<4&63],a[o+2]=61,a[o+3]=61):t%3===2&&(r=(n[t-2]<<8)+n[t-1],a[o]=i[r>>10],a[o+1]=i[r>>4&63],a[o+2]=i[r<<2&63],a[o+3]=61),new TextDecoder('ascii').decode(a)};"
                + "var xhr = new XMLHttpRequest();"
                + "xhr.responseType = 'arraybuffer';"
                + "xhr.onload = function(){ callback(toBase64(xhr.response)) };"
                + "xhr.onerror = function(){ callback(xhr.status) };"
                + "xhr.open('GET','" + url + "');"
                + "xhr.send();";
        return (String) js.executeAsyncScript(script, url);
    }

    private File savePdfFile(String path, String content) throws AutomationException {
        File file = new File(path);
        try (FileOutputStream fos = new FileOutputStream(file);) {
            byte[] decoder = Base64.getDecoder().decode(content);
            fos.write(decoder);
            log.debug("PDF File Saved");
        } catch (Exception e) {
            throw new AutomationException("Error happened with message: " + e.getMessage());
        }
        return file;
    }

    private PDDocument loadPdfFile(File file) throws AutomationException {
        PDDocument document = null;
        if (Objects.nonNull(file)) {
            try {
                document = PDDocument.load(file);
            } catch (IOException e) {
                throw new AutomationException("We can not load PDF file due to error " + e.getMessage());
            }
        }
        return document;
    }

    public String getContentFromDownloadedFile(String path, String url) throws AutomationException {
        String content = getBytesFromUrl(url);
        File file = savePdfFile(path, content);
        PDDocument document = null;
        try {
            document = loadPdfFile(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (Exception e) {
            return "";
        } finally {
            try {
                if (Objects.nonNull(document)) {
                    document.close();
                }
            } catch (IOException e) {
                // do nothing
            }
        }
    }

}
